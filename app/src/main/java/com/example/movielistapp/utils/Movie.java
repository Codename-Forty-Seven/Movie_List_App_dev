package com.example.movielistapp.utils;

import android.graphics.drawable.Drawable;

public class Movie {
    private String nameMovie, shortInfo, releaseDate;
    private boolean addedToWatchList;
    private Drawable moviePoster;

    public Movie() {
    }

    public Movie(Drawable moviePoster, String nameMovie, String releaseDate, String shortInfo, boolean addedToWatchList) {
        this.nameMovie = nameMovie;
        this.releaseDate = releaseDate;
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

    public Drawable getMoviePoster() {
        return moviePoster;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
