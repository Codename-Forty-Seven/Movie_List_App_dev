package com.example.movielistapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class MovieReleaseDateComparator implements Comparator<Movie> {
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("d MMMM yyyy", Locale.ENGLISH);

    @Override
    public int compare(Movie movie1, Movie movie2) {
        try {
            Date releaseDate1 = dateFormatter.parse(movie1.getReleaseDate());
            Date releaseDate2 = dateFormatter.parse(movie2.getReleaseDate());

            if (releaseDate1 != null && releaseDate2 != null) {
                return releaseDate2.compareTo(releaseDate1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
