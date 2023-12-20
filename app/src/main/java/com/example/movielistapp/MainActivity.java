package com.example.movielistapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_btn_sort;
    private RecyclerView rv_with_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAllComponents();

    }

    private void initAllComponents() {
        tv_btn_sort = findViewById(R.id.tv_btn_sort);
        rv_with_movies = findViewById(R.id.rv_with_movies);
    }
}