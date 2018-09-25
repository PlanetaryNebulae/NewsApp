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

    //Separates the authors if there's an "and" between them.
    private static final String AND_AUTHOR_SEPARATOR = "and";

    //Separates the authors if there's a "," between them.
    private static final String COMMA_AUTHOR_SEPARATOR = ",";

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

        //Finds the authors.
        String originalAuthor = currentNews.getAuthor();

        //A split string for the authors.
        String firstAuthor;

        //An if/else statement to divide the authors and only show the first one.
        if (originalAuthor.contains(AND_AUTHOR_SEPARATOR)) {
            String[] parts = originalAuthor.split(AND_AUTHOR_SEPARATOR);
            firstAuthor = parts[0];
        } else if (originalAuthor.contains(COMMA_AUTHOR_SEPARATOR)) {
            String[] parts = originalAuthor.split(COMMA_AUTHOR_SEPARATOR);
            firstAuthor = parts[0];
        } else {
            firstAuthor = originalAuthor;
        }

        //Finds and displays TextView for the article writer.
        TextView author = (TextView) listItemView.findViewById(R.id.author_textview);
        author.setText(firstAuthor);

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

