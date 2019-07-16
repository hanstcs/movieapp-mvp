package com.hanstcs.movieapp.data.repository;

import com.hanstcs.movieapp.data.Movies;

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

    public List<Movies> getMovies() {
        List<Movies> movies = new ArrayList<>();
        movies.add(new Movies("1", "The lord of the rings", "2009-12-10"));
        movies.add(new Movies("2", "The fallen and rise of the rome empire", "2017-10-25"));
        movies.add(new Movies("2", "Thor: Ragnarok", "2017-10-25"));
        return movies;
    }
}
