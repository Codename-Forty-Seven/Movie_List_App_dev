package com.example.movielistapp.utils;

import android.graphics.drawable.Drawable;

public class Movie {
    private String nameMovie, shortInfo;
    private boolean addedToWatchList;
    private Drawable moviePoster;

    public Movie() {
    }

    public Movie(Drawable moviePoster, String nameMovie, String shortInfo, boolean addedToWatchList) {
        this.nameMovie = nameMovie;
        this.shortInfo = shortInfo;
        this.moviePoster = moviePoster;
        this.addedToWatchList = addedToWatchList;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public boolean isAddedToWatchList() {
        return addedToWatchList;
    }

    public void setAddedToWatchList(boolean addedToWatchList) {
        this.addedToWatchList = addedToWatchList;
    }

    public Drawable getMoviePoster() {
        return moviePoster;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }
}
