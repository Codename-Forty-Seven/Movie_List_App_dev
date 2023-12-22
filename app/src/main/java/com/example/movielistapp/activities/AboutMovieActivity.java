package com.example.movielistapp.activities;

import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST;
import static com.example.movielistapp.utils.Constants.MOVIE_POSTER_ID;
import static com.example.movielistapp.utils.Constants.NAME_MOVIE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movielistapp.R;

public class AboutMovieActivity extends AppCompatActivity {
    private ImageView img_v_current_movie;
    private TextView tv_name_current_movie, tv_rating_current_movie, tv_btn_remove_from_watch_list, tv_btn_watch_trailer, tv_short_description,
            tv_genre_current_movie, tv_release_date_current_movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_movie);
        initAllComponents();

    }

    private void initAllComponents() {
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
                if (comes.getIntExtra(ADD_TO_WATCH_LIST, View.VISIBLE) == View.GONE)
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_remove_from_watch_list));
                else
                    tv_btn_remove_from_watch_list.setText(getString(R.string.txt_add_to_watch_list));
                tv_short_description.setText(getString(R.string.txt_description_movie_spider));
                tv_genre_current_movie.setText(getString(R.string.txt_short_info_genre_movie_spider));
                tv_release_date_current_movie.setText(getString(R.string.txt_release_date_movie_spider));
                break;
            }
        }
    }
}