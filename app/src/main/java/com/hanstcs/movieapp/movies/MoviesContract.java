package com.hanstcs.movieapp.movies;

import java.util.List;

public interface MoviesContract {
    interface View {
        void setPresenter(MoviesContract.Presenter presenter);
        void showMovies(List<String> movies);
    }

    interface Presenter {
        void loadMovies();
    }
}
