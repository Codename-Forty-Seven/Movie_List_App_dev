package com.example.movielistapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.movielistapp.R;

public class AboutMovieActivity extends AppCompatActivity {
    private ImageView img_v_current_movie;
    private TextView tv_name_current_movie, tv_rating_current_movie, tv_btn_remove_from_watch_list, tv_btn_watch_trailer, tv_short_description,
            tv_header_short_description, tv_header_details_current_movie, tv_genre_current_movie, tv_release_date_current_movie;

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
        tv_header_short_description = findViewById(R.id.tv_header_short_description);
        tv_header_details_current_movie = findViewById(R.id.tv_header_details_current_movie);
        tv_genre_current_movie = findViewById(R.id.tv_genre_current_movie);
        tv_release_date_current_movie = findViewById(R.id.tv_release_date_current_movie);
    }
}