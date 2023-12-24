package com.example.movielistapp;

import static android.content.ContentValues.TAG;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_AVENGERS;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_GUARDIANS;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_KNIVES;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_SPIDER;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_TENET;
import static com.example.movielistapp.utils.Constants.NAME_PREF;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielistapp.utils.Movie;
import com.example.movielistapp.utils.MovieNameComparator;
import com.example.movielistapp.utils.MovieReleaseDateComparator;
import com.example.movielistapp.utils.MoviesAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_btn_sort, tv_cancel_sort, tv_sort_by_title, tv_sort_by_release_date;
    private RecyclerView rv_with_movies;
    private List<Movie> movieList;
    private MoviesAdapter moviesAdapter;
    private SharedPreferences prefs;
    private ConstraintLayout cl_with_fragment_sort;
    private boolean openSortMenu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAllComponents();

        tv_btn_sort.setOnClickListener(v -> {
            showFragmentWithAnimation();
        });
        tv_sort_by_title.setOnClickListener(v -> {
            sortMoviesByName();
            hideFragmentWithAnimation();
        });
        tv_sort_by_release_date.setOnClickListener(v -> {
            sortMoviesByReleaseDate();
            hideFragmentWithAnimation();
        });
        tv_cancel_sort.setOnClickListener(v -> {
            hideFragmentWithAnimation();
        });
        cl_with_fragment_sort.setOnClickListener(v -> {
            hideFragmentWithAnimation();
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        movieList = createMovieList();
        moviesAdapter.updateList(movieList);
    }

    @Override
    public void onBackPressed() {
        if (openSortMenu)
            hideFragmentWithAnimation();
        else
            super.onBackPressed();
    }

    private void initAllComponents() {
        prefs = getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        tv_btn_sort = findViewById(R.id.tv_btn_sort);
        tv_sort_by_title = findViewById(R.id.tv_sort_by_title);
        tv_sort_by_release_date = findViewById(R.id.tv_sort_by_release_date);
        tv_cancel_sort = findViewById(R.id.tv_cancel_sort);
        rv_with_movies = findViewById(R.id.rv_with_movies);
        rv_with_movies.setLayoutManager(new LinearLayoutManager(this));
        movieList = createMovieList();
        moviesAdapter = new MoviesAdapter(this, movieList);
        rv_with_movies.setAdapter(moviesAdapter);
        cl_with_fragment_sort = findViewById(R.id.cl_with_fragment_sort);
    }

    private List<Movie> createMovieList() {
        Drawable tenetDrawable = getDrawable(R.drawable.tenet);
        Drawable spiderDrawable = getDrawable(R.drawable.spider_man);
        Drawable knivesDrawable = getDrawable(R.drawable.knives_out);
        Drawable guardianDrawable = getDrawable(R.drawable.guardians_of_the_galaxy);
        Drawable avengersDrawable = getDrawable(R.drawable.avengers);
        Movie tenet = new Movie(tenetDrawable, getString(R.string.txt_name_movie_tenet), getString(R.string.txt_release_date_movie_tenet), getString(R.string.txt_short_info_movie_tenet), prefs.getBoolean(ADD_TO_WATCH_LIST_TENET, false));
        Movie spider = new Movie(spiderDrawable, getString(R.string.txt_name_movie_spider), getString(R.string.txt_release_date_movie_spider), getString(R.string.txt_short_info_movie_spider), prefs.getBoolean(ADD_TO_WATCH_LIST_SPIDER, false));
        Movie knives = new Movie(knivesDrawable, getString(R.string.txt_name_movie_knives_out), getString(R.string.txt_release_date_movie_knives_out), getString(R.string.txt_short_info_movie_knives_out), prefs.getBoolean(ADD_TO_WATCH_LIST_KNIVES, false));
        Movie guardians = new Movie(guardianDrawable, getString(R.string.txt_name_movie_guardians_of_the_galaxy), getString(R.string.txt_release_date_movie_guardians_of_the_galaxy), getString(R.string.txt_short_info_movie_guardians_of_the_galaxy), prefs.getBoolean(ADD_TO_WATCH_LIST_GUARDIANS, false));
        Movie avengers = new Movie(avengersDrawable, getString(R.string.txt_name_movie_avengers), getString(R.string.txt_release_date_movie_avengers), getString(R.string.txt_short_info_movie_avengers), prefs.getBoolean(ADD_TO_WATCH_LIST_AVENGERS, false));

        List<Movie> movies = new ArrayList<>();
        movies.add(tenet);
        movies.add(spider);
        movies.add(knives);
        movies.add(guardians);
        movies.add(avengers);
        return movies;
    }

    private void sortMoviesByName() {
        movieList = createMovieList();
        movieList.sort(new MovieNameComparator());
        moviesAdapter.updateList(movieList);
    }

    private void sortMoviesByReleaseDate() {
        movieList = createMovieList();
        movieList.sort(new MovieReleaseDateComparator());
        moviesAdapter.updateList(movieList);
    }

    private void showFragmentWithAnimation() {
        openSortMenu = true;
        TranslateAnimation animate = new TranslateAnimation(0, 0, cl_with_fragment_sort.getHeight(), 0);
        animate.setDuration(500);
        animate.setFillAfter(true);

        cl_with_fragment_sort.startAnimation(animate);
        cl_with_fragment_sort.setVisibility(View.VISIBLE);
        cl_with_fragment_sort.setClickable(true);
        cl_with_fragment_sort.setFocusable(true);
        tv_sort_by_title.setClickable(true);
        tv_sort_by_title.setFocusable(true);
        tv_sort_by_release_date.setClickable(true);
        tv_sort_by_release_date.setFocusable(true);
        tv_cancel_sort.setClickable(true);
        tv_cancel_sort.setFocusable(true);
    }

    private void hideFragmentWithAnimation() {
        openSortMenu = false;
        TranslateAnimation animate = new TranslateAnimation(0, 0, 0, cl_with_fragment_sort.getHeight());
        animate.setDuration(500);
        animate.setFillAfter(true);

        cl_with_fragment_sort.startAnimation(animate);
        cl_with_fragment_sort.setVisibility(View.GONE);
        cl_with_fragment_sort.setClickable(false);
        cl_with_fragment_sort.setFocusable(false);
        tv_sort_by_title.setClickable(false);
        tv_sort_by_title.setFocusable(false);
        tv_sort_by_release_date.setClickable(false);
        tv_sort_by_release_date.setFocusable(false);
        tv_cancel_sort.setClickable(false);
        tv_cancel_sort.setFocusable(false);
    }
}