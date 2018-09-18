package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    //Separates the date and time.
    private static final String DATE_SEPARATOR = "T";

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        }

        //Finds news objects current position.
        News currentNews = getItem(position);

        //Finds and displays TextView for the news title.
        TextView title = (TextView) listItemView.findViewById(R.id.title_textview);
        title.setText(currentNews.getTitle());

        //Finds and displays TextView for the news category.
        TextView category = (TextView) listItemView.findViewById(R.id.category_textview);
        category.setText(currentNews.getCategory());

        //Finds and displays TextView for the article writer.
        TextView author = (TextView) listItemView.findViewById(R.id.author_textview);
        author.setText(currentNews.getAuthor());

        //Finds the publication date and time.
        String originalDate = currentNews.getDate();

        //A split string for the publication date.
        String datePublished;

        //An if/else statement to divide the date and time.
        if (originalDate.contains(DATE_SEPARATOR)) {
            String[] parts = originalDate.split(DATE_SEPARATOR);
            datePublished = parts[0];
        } else {
            datePublished = originalDate;
        }

        //Finds and displays TextView for the publication date.
        TextView date = (TextView) listItemView.findViewById(R.id.date_published);
        date.setText(datePublished);

        return listItemView;
    }
}

