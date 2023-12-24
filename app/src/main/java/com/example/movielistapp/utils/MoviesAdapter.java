package com.example.movielistapp.utils;

import static android.content.ContentValues.TAG;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_AVENGERS;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_GUARDIANS;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_KNIVES;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_SPIDER;
import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST_TENET;
import static com.example.movielistapp.utils.Constants.NAME_MOVIE;
import static com.example.movielistapp.utils.Constants.NAME_PREF;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielistapp.R;
import com.example.movielistapp.activities.AboutMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movies = new ArrayList<>();
    private final Activity activity;
    private SharedPreferences prefs;
    private static SharedPreferences.Editor editor;

    public MoviesAdapter(Activity activity, List<Movie> movies) {
        this.activity = activity;
        this.movies = movies;
    }

    public void updateList(List<Movie> newMovies) {
        movies.clear();
        movies.addAll(newMovies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        prefs = activity.getSharedPreferences(NAME_PREF, Context.MODE_PRIVATE);
        editor = prefs.edit();

        holder.tv_name_movie.setText(movie.getNameMovie());
        holder.tv_short_info_movie.setText(movie.getShortInfo());
        if (movie.isAddedToWatchList()) {
            holder.tv_add_on_my_watch_list.setVisibility(View.INVISIBLE);
        } else
            holder.tv_add_on_my_watch_list.setVisibility(View.VISIBLE);
        holder.img_v_photo_movie.setImageDrawable(movie.getMoviePoster());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name_movie, tv_short_info_movie, tv_add_on_my_watch_list;
        ImageView img_v_photo_movie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name_movie = itemView.findViewById(R.id.tv_name_movie);
            tv_short_info_movie = itemView.findViewById(R.id.tv_short_info_movie);
            tv_add_on_my_watch_list = itemView.findViewById(R.id.tv_add_on_my_watch_list);
            img_v_photo_movie = itemView.findViewById(R.id.img_v_photo_movie);

            tv_add_on_my_watch_list.setOnClickListener(v -> {
                addInfoAboutWatchList(tv_name_movie);
                tv_add_on_my_watch_list.setVisibility(View.INVISIBLE);
            });

            itemView.setOnClickListener(view -> {
                Context context = itemView.getContext();
                Intent openInfoAboutMovie = new Intent(context, AboutMovieActivity.class);
                openInfoAboutMovie.putExtra(NAME_MOVIE, tv_name_movie.getText().toString().trim());
                context.startActivity(openInfoAboutMovie);
            });
        }

        private void addInfoAboutWatchList(TextView tv_name_movie) {
            Log.d(TAG, "addInfoAboutWatchList: " + tv_name_movie.getText().toString().trim());
            switch (tv_name_movie.getText().toString().trim()) {
                case "Tenet (2020)": {
                    editor.putBoolean(ADD_TO_WATCH_LIST_TENET, true);
                    break;
                }
                case "Spider-Man: Into the Spider-Verse (2018)": {
                    editor.putBoolean(ADD_TO_WATCH_LIST_SPIDER, true);
                    break;
                }
                case "Knives out (2018)": {
                    editor.putBoolean(ADD_TO_WATCH_LIST_KNIVES, true);
                    break;
                }
                case "Guardians of the Galaxy (2014)": {
                    editor.putBoolean(ADD_TO_WATCH_LIST_GUARDIANS, true);
                    break;
                }
                case "Avengers: Age of Ultron (2015)": {
                    editor.putBoolean(ADD_TO_WATCH_LIST_AVENGERS, true);
                    break;
                }
            }
            editor.commit();
        }
    }
}
