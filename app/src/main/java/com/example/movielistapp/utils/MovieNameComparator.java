package com.example.movielistapp.utils;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {
        return movie1.getNameMovie().compareTo(movie2.getNameMovie());
    }
}