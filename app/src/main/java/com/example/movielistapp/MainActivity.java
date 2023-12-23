package com.example.movielistapp;

import static com.example.movielistapp.utils.Constants.*;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielistapp.utils.Movie;
import com.example.movielistapp.utils.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_btn_sort;
    private RecyclerView rv_with_movies;
    private List<Movie> movieList;
    private MoviesAdapter moviesAdapter;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAllComponents();

        tv_btn_sort.setOnClickListener(v -> {
            showPopupMenu(v);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        moviesAdapter.notifyDataSetChanged();
    }

    private void initAllComponents() {
        prefs = getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        editor = prefs.edit();
        tv_btn_sort = findViewById(R.id.tv_btn_sort);
        rv_with_movies = findViewById(R.id.rv_with_movies);
        rv_with_movies.setLayoutManager(new LinearLayoutManager(this));
        movieList = createMovieList();
        moviesAdapter = new MoviesAdapter(this, movieList);
        rv_with_movies.setAdapter(moviesAdapter);
    }

    private List<Movie> createMovieList() {
        Drawable tenetDrawable = getDrawable(R.drawable.tenet);
        Drawable spiderDrawable = getDrawable(R.drawable.spider_man);
        Drawable knivesDrawable = getDrawable(R.drawable.knives_out);
        Drawable guardianDrawable = getDrawable(R.drawable.guardians_of_the_galaxy);
        Drawable avengersDrawable = getDrawable(R.drawable.avengers);
        Movie tenet = new Movie(tenetDrawable, getString(R.string.txt_name_movie_tenet), getString(R.string.txt_short_info_movie_tenet), prefs.getBoolean(ADD_TO_WATCH_LIST_TENET, false));
        Movie spider = new Movie(spiderDrawable, getString(R.string.txt_name_movie_spider), getString(R.string.txt_short_info_movie_spider), prefs.getBoolean(ADD_TO_WATCH_LIST_SPIDER, false));
        Movie knives = new Movie(knivesDrawable, getString(R.string.txt_name_movie_knives_out), getString(R.string.txt_short_info_movie_knives_out), prefs.getBoolean(ADD_TO_WATCH_LIST_KNIVES, false));
        Movie guardians = new Movie(guardianDrawable, getString(R.string.txt_name_movie_guardians_of_the_galaxy), getString(R.string.txt_short_info_movie_guardians_of_the_galaxy), prefs.getBoolean(ADD_TO_WATCH_LIST_GUARDIANS, false));
        Movie avengers = new Movie(avengersDrawable, getString(R.string.txt_name_movie_avengers), getString(R.string.txt_short_info_movie_avengers), prefs.getBoolean(ADD_TO_WATCH_LIST_AVENGERS, false));

        List<Movie> movies = new ArrayList<>();
        movies.add(tenet);
        movies.add(spider);
        movies.add(knives);
        movies.add(guardians);
        movies.add(avengers);
        return movies;
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.sort_menu, popupMenu.getMenu());

        // Обробник натискання на елемент меню
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.sortByName:
                    // Логіка сортування за іменем
//                    yourTextView.setText("Сортування за іменем");
                    Toast.makeText(this, "Сортування за іменем", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.sortByReleaseDate:
                    // Логіка сортування за датою релізу
//                    yourTextView.setText("Сортування за датою релізу");
                    Toast.makeText(this, "Сортування за датою релізу", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                    return false;
            }
        });

        popupMenu.show();
    }
}