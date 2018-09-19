package com.example.android.newsapp;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<News>> {

    private static final String LOG_TAG = MainActivity.class.getName();

    //Loader id.
    private static final int NEWS_LOADER_ID = 1;

    //URL for news data from The Guardian.
    private static final String GUARDIAN_REQUEST_URL =
            "https://content.guardianapis.com/search?q=videogames&api-key=c950363b-c7d7-4c5a-a17f-27d7a91f674c&show-tags=contributor";

    private NewsAdapter nAdapter;
    private TextView nEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        Log.i(LOG_TAG, "TEST: MainActivity onCreate is being called!!");

        //Finds the ListView in the layout.
        ListView newsListView = (ListView) findViewById(R.id.list_item);

        //Finds the empty state TextView in the layout.
        nEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsListView.setEmptyView(nEmptyStateTextView);

        nAdapter = new NewsAdapter(this, new ArrayList<News>());

        //Sets the adapter to the listview so it can populate the UI.
        newsListView.setAdapter(nAdapter);

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                News currentNews = nAdapter.getItem(position);

                Uri newsUri = Uri.parse(currentNews.getUrl());

                Intent newsIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                startActivity(newsIntent);
            }
        });

        //Checks the state of network connectivity by referencing the ConnectivityManager.
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        //Checks if the network is active.
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            //Gets reference to LoaderManager, to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            loaderManager.initLoader(NEWS_LOADER_ID, null, this);
        } else {
            //Hides progress bar.
            View progressBar = findViewById(R.id.progress_bar);
            progressBar.setVisibility(GONE);

            //Sets empty state to "Unable to connect to internet."
            nEmptyStateTextView.setText(R.string.no_internet);
        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "TEST: onCreateLoader() called!!");
        //New loader for the url.
        return new NewsLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {

        Log.i(LOG_TAG, "TEST: Calling onLoadFinished!!");

        //Hides progress bar.
        View progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(GONE);

        //Clears the adapter of any existing data.
        nAdapter.clear();

        //Updates ListView if there's valid news to add.
        if (news != null && !news.isEmpty()) {
            nAdapter.addAll(news);
        }

        //Checks the state of network connectivity by referencing the ConnectivityManager.
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        //Checks if the network is active.
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        //If the network is active but there is no news data, sets text to 'No news.'
        //Else the network isn't active, sets text to 'No internet.'
        if (activeNetwork != null && activeNetwork.isConnected()) {
            //Sets empty display text to "No news data found".
            nEmptyStateTextView.setText(R.string.empty);
        } else {
            //Sets empty state to "Unable to connect to internet."
            nEmptyStateTextView.setText(R.string.no_internet);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        Log.i(LOG_TAG, "TESTING: onLoaderReset is being called!!");
        //Resets the Loader to clear all existing data.
        nAdapter.clear();
    }
}
