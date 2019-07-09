package com.hanstcs.movieapp.movies;

import com.hanstcs.movieapp.base.BaseView;

import java.util.List;

public interface MoviesContract {
    interface View extends BaseView<Presenter> {
        void showMovies(List<String> movies);
    }

    interface Presenter {
        void loadMovies();
    }
}
