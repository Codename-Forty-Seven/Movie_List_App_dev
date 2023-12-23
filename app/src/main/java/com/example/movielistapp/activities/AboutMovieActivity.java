package com.example.movielistapp.activities;

import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_AVENGERS;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_GUARDIANS;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_KNIVES;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_SPIDER;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_TENET;
import static com.example.movielistapp.utils.Constants.MOVIE_POSTER_ID;
import static com.example.movielistapp.utils.Constants.NAME_MOVIE;
import static com.example.movielistapp.utils.Constants.NAME_PREF;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movielistapp.MainActivity;
import com.example.movielistapp.R;

public class AboutMovieActivity extends AppCompatActivity {
    private ImageView img_v_current_movie, img_back_to_movies;
    private TextView tv_name_current_movie, tv_rating_current_movie, tv_btn_remove_from_watch_list, tv_btn_watch_trailer, tv_short_description,
            tv_genre_current_movie, tv_release_date_current_movie;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_movie);
        initAllComponents();

        img_back_to_movies.setOnClickListener(v -> {
            onBackPressed();
        });

        tv_btn_watch_trailer.setOnClickListener(v -> {
            showTrailer(tv_name_current_movie.getText().toString().trim());
        });

        tv_btn_remove_from_watch_list.setOnClickListener(v -> {
            if (tv_btn_remove_from_watch_list.getText().toString().contentEquals(getString(R.string.txt_remove_from_watch_list))) {
                tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                addToWatchList(tv_name_current_movie.getText().toString().trim(), false);
            } else {
                tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                addToWatchList(tv_name_current_movie.getText().toString().trim(), true);
            }
        });

    }

    private void initAllComponents() {
        prefs = getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        editor = prefs.edit();
        img_back_to_movies = findViewById(R.id.img_back_to_movies);
        img_v_current_movie = findViewById(R.id.img_v_current_movie);
        tv_name_current_movie = findViewById(R.id.tv_name_current_movie);
        tv_rating_current_movie = findViewById(R.id.tv_rating_current_movie);
        tv_btn_remove_from_watch_list = findViewById(R.id.tv_btn_remove_from_watch_list);
        tv_btn_watch_trailer = findViewById(R.id.tv_btn_watch_trailer);
        tv_short_description = findViewById(R.id.tv_short_description);
        tv_genre_current_movie = findViewById(R.id.tv_genre_current_movie);
        tv_release_date_current_movie = findViewById(R.id.tv_release_date_current_movie);
        getIntentsFromName();
    }

    private void getIntentsFromName() {
        Intent comes = getIntent();
        switch (comes.getStringExtra(NAME_MOVIE)) {
            case "Tenet (2020)": {
                Drawable img = getDrawable(R.drawable.tenet);
                img_v_current_movie.setImageDrawable(img);
                tv_name_current_movie.setText(comes.getStringExtra(NAME_MOVIE));
                tv_rating_current_movie.setText(getText(R.string.txt_rating_movie_tenet));
                if (comes.getIntExtra(ADD_TO_WATCH_LIST, View.VISIBLE) == View.GONE)
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                else
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                tv_short_description.setText(getString(R.string.txt_description_movie_tenet));
                tv_genre_current_movie.setText(getString(R.string.txt_short_info_genre_movie_tenet));
                tv_release_date_current_movie.setText(getString(R.string.txt_release_date_movie_tenet));
                break;
            }
            case "Spider-Man: Into the Spider-Verse (2018)": {
                Drawable img = getDrawable(R.drawable.spider_man);
                img_v_current_movie.setImageDrawable(img);
                tv_name_current_movie.setText(comes.getStringExtra(NAME_MOVIE));
                tv_rating_current_movie.setText(getText(R.string.txt_rating_movie_spider));
                if (comes.getIntExtra(ADD_TO_WATCH_LIST, View.VISIBLE) == View.GONE)
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                else
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                tv_short_description.setText(getString(R.string.txt_description_movie_spider));
                tv_genre_current_movie.setText(getString(R.string.txt_short_info_genre_movie_spider));
                tv_release_date_current_movie.setText(getString(R.string.txt_release_date_movie_spider));
                break;
            }
            case "Knives out (2018)": {
                Drawable img = getDrawable(R.drawable.knives_out);
                img_v_current_movie.setImageDrawable(img);
                tv_name_current_movie.setText(comes.getStringExtra(NAME_MOVIE));
                tv_rating_current_movie.setText(getText(R.string.txt_rating_movie_knives_out));
                if (comes.getIntExtra(ADD_TO_WATCH_LIST, View.VISIBLE) == View.GONE)
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                else
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                tv_short_description.setText(getString(R.string.txt_description_movie_knives_out));
                tv_genre_current_movie.setText(getString(R.string.txt_short_info_genre_movie_knives_out));
                tv_release_date_current_movie.setText(getString(R.string.txt_release_date_movie_knives_out));
                break;
            }
            case "Guardians of the Galaxy (2014)": {
                Drawable img = getDrawable(R.drawable.guardians_of_the_galaxy);
                img_v_current_movie.setImageDrawable(img);
                tv_name_current_movie.setText(comes.getStringExtra(NAME_MOVIE));
                tv_rating_current_movie.setText(getText(R.string.txt_rating_movie_guardians_of_the_galaxy));
                if (comes.getIntExtra(ADD_TO_WATCH_LIST, View.VISIBLE) == View.GONE)
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                else
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                tv_short_description.setText(getString(R.string.txt_description_movie_guardians_of_the_galaxy));
                tv_genre_current_movie.setText(getString(R.string.txt_short_info_genre_movie_guardians_of_the_galaxy));
                tv_release_date_current_movie.setText(getString(R.string.txt_release_date_movie_guardians_of_the_galaxy));
                break;
            }
            case "Avengers: Age of Ultron (2015)": {
                Drawable img = getDrawable(R.drawable.avengers);
                img_v_current_movie.setImageDrawable(img);
                tv_name_current_movie.setText(comes.getStringExtra(NAME_MOVIE));
                tv_rating_current_movie.setText(getText(R.string.txt_rating_movie_avengers));
                if (comes.getIntExtra(ADD_TO_WATCH_LIST, View.VISIBLE) == View.GONE)
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                else
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                tv_short_description.setText(getString(R.string.txt_description_movie_avengers));
                tv_genre_current_movie.setText(getString(R.string.txt_short_info_genre_movie_avengers));
                tv_release_date_current_movie.setText(getString(R.string.txt_release_date_movie_avengers));
                break;
            }
        }
    }

    private void showTrailer(String nameMovie) {
        Intent showTrailer = null;
        switch (nameMovie) {
            case "Tenet (2020)": {
                showTrailer = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.txt_link_movie_tenet)));
                break;
            }
            case "Spider-Man: Into the Spider-Verse (2018)": {
                showTrailer = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.txt_link_movie_spider)));
                break;
            }
            case "Knives out (2018)": {
                showTrailer = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.txt_link_movie_knives_out)));
                break;
            }
            case "Guardians of the Galaxy (2014)": {
                showTrailer = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.txt_link_movie_guardians_of_the_galaxy)));
                break;
            }
            case "Avengers: Age of Ultron (2015)": {
                showTrailer = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.txt_link_movie_avengers)));
                break;
            }
        }
        startActivity(showTrailer);
    }


    private void addToWatchList(String nameMovie, boolean visible) {
        switch (nameMovie) {
            case "Tenet (2020)": {
                editor.putBoolean(ADD_TO_WATCH_LIST_TENET, visible);
                editor.commit();
                break;
            }
            case "Spider-Man: Into the Spider-Verse (2018)": {
                editor.putBoolean(ADD_TO_WATCH_LIST_SPIDER, visible);
                editor.commit();
                break;
            }
            case "Knives out (2018)": {
                editor.putBoolean(ADD_TO_WATCH_LIST_KNIVES, visible);
                editor.commit();
                break;
            }
            case "Guardians of the Galaxy (2014)": {
                editor.putBoolean(ADD_TO_WATCH_LIST_GUARDIANS, visible);
                editor.commit();
                break;
            }
            case "Avengers: Age of Ultron (2015)": {
                editor.putBoolean(ADD_TO_WATCH_LIST_AVENGERS, visible);
                editor.commit();
                break;
            }
        }
    }
}