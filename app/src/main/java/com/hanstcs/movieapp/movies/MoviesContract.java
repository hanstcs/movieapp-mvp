package com.hanstcs.movieapp.movies;

import com.hanstcs.movieapp.base.BaseView;
import com.hanstcs.movieapp.data.Movies;

import java.util.List;

public interface MoviesContract {
    interface View extends BaseView<Presenter> {
        void showMovies(List<Movies> movies);
    }

    interface Presenter {
        void loadMovies();
    }
}
