package com.example.android.newsapp;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

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

        //TODO: Finds and displays TextView for the publication date.

        //Finds and displays TextView for the publication date.
        TextView date = (TextView) listItemView.findViewById(R.id.date_published);
        date.setText(currentNews.getDate());

        //Finds and displays TextView for the news description.
        //TODO: TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_textview);

        return listItemView;
    }
}

