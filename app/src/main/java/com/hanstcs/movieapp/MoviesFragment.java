package com.hanstcs.movieapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MoviesFragment extends Fragment {

    public MoviesFragment() {
    }

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.movies_fragment, container, false);
        RecyclerView rvMovies = root.findViewById(R.id.rvMovies);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMovies.setLayoutManager(layoutManager);
        MoviesAdapter adapter = new MoviesAdapter(getMovies());
        rvMovies.setAdapter(adapter);
        return root;
    }

    private List<String> getMovies() {
        List<String> movies = new ArrayList<>();
        movies.add("The lord of the rings");
        movies.add("The fallen and rise of the rome empire");
        return movies;
    }
}
