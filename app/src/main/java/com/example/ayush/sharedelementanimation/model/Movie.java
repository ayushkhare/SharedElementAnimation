package com.example.ayush.sharedelementanimation.model;

/**
 * Created by ayush on 12/11/16
 */
public class Movie {

    private String image;
    private String title;
    private String description;
    private String genre;
    private String year;

    public Movie(String image, String title, String description, String genre, String year) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
