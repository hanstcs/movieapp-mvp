package com.hanstcs.movieapp.repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.Nullable;

public class MoviesRepository {
    @Nullable
    private static MoviesRepository INSTANCE = null;

    private MoviesRepository() {
    }

    public static MoviesRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MoviesRepository();
        }
        return INSTANCE;
    }

    public List<String> getMovies() {
        List<String> movies = new ArrayList<>();
        movies.add("The lord of the rings");
        movies.add("The fallen and rise of the rome empire");
        return movies;
    }
}
