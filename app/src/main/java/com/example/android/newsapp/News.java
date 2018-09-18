package com.example.android.newsapp;

public class News {

    //Provides string for news title.
    private String nTitle;

    //Provides string for news category.
    private String nCategory;

    //Provides String for news author.
    private String nAuthor;

    //Provides String for news date.
    private String nDate;

    //Provides String for news URL.
    private String nUrl;

    public News(String aTitle, String aCategory, String aAuthor, String aDate, String aUrl) {

        nTitle = aTitle;
        nCategory = aCategory;
        nAuthor = aAuthor;
        nDate = aDate;
        nUrl = aUrl;
    }

    //Gets title of news article.
    public String getTitle() {
        return nTitle;
    }

    //Gets category of news article.
    public String getCategory() {
        return nCategory;
    }

    //Gets author of news article.
    public String getAuthor() {
        return nAuthor;
    }

    //Gets date of news article.
    public String getDate() {
        return nDate;
    }

    //Gets URL of news article.
    public String getUrl() {
        return nUrl;
    }

}