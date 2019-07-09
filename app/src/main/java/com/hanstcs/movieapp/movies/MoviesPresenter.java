package com.hanstcs.movieapp.movies;

import com.hanstcs.movieapp.repository.MoviesRepository;

public class MoviesPresenter implements MoviesContract.Presenter {

    private final MoviesRepository mMoviesRepository;
    private final MoviesContract.View mMoviesView;

    public MoviesPresenter(MoviesContract.View moviesView, MoviesRepository moviesRepository) {
        mMoviesView = moviesView;
        mMoviesRepository = moviesRepository;

        mMoviesView.setPresenter(this);
    }

    @Override
    public void loadMovies() {
        mMoviesView.showMovies(mMoviesRepository.getMovies());
    }
}
