package com.example.bottomactivity.ui.notifications.Adapter;


public class Model {

    private String image_link, image_title, author, date_maker;

    public Model() {

    }

    public Model(String image, String title, String auteur, String date) {
        this.image_link = image;
        this.image_title = title;
        this.author = auteur;
        this.date_maker = date;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate_maker() {
        return date_maker;
    }

    public void setDate_maker(String date_maker) {
        this.date_maker = date_maker;
    }
}
