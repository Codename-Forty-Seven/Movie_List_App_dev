package com.example.movielistapp.utils;

import static com.example.movielistapp.utils.Constants.ADD_TO_WATCH_LIST;
import static com.example.movielistapp.utils.Constants.MOVIE_POSTER_ID;
import static com.example.movielistapp.utils.Constants.NAME_MOVIE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movielistapp.R;
import com.example.movielistapp.activities.AboutMovieActivity;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movies = new ArrayList<>();

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
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

        holder.tv_name_movie.setText(movie.getNameMovie());
        holder.tv_short_info_movie.setText(movie.getShortInfo());
        if (!movie.isAddedToWatchList())
            holder.tv_add_on_my_watch_list.setVisibility(View.VISIBLE);
        else
            holder.tv_add_on_my_watch_list.setVisibility(View.GONE);
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
                tv_add_on_my_watch_list.setVisibility(View.GONE);
            });

            itemView.setOnClickListener(view -> {
                Context context = itemView.getContext();
                Intent openInfoAboutMovie = new Intent(context, AboutMovieActivity.class);
                openInfoAboutMovie.putExtra(NAME_MOVIE, tv_name_movie.getText().toString().trim());
                openInfoAboutMovie.putExtra(ADD_TO_WATCH_LIST, tv_add_on_my_watch_list.getVisibility());
                context.startActivity(openInfoAboutMovie);
            });
        }
    }
}
