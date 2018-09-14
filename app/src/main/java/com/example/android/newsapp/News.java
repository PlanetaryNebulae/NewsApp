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

    //TODO: Provides String for news desciption.
    //private String nDescription;

    //TODO: Add news description here if you figure out how.
    public News(String aTitle, String aCategory, String aAuthor, String aDate, String aUrl) {

        nTitle = aTitle;
        nCategory = aCategory;
        nAuthor = aAuthor;
        nDate = aDate;
        nUrl = aUrl;
        //TODO: nDescription = aDescription;
    }

    //Gets title of news article.
    public String getTitle() {
        return nTitle;
    }

    //Gets category of news article.
    public String getCategory() {
        return nCategory;
    }

    public String getAuthor() {
        return nAuthor;
    }

    public String getDate() {
        return nDate;
    }

    public String getUrl() {
        return nUrl;
    }

    //Gets description of news article.
    //TODO: public String getDescription() {
    //return nDescription;
}