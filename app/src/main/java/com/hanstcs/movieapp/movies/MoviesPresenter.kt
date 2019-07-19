package com.hanstcs.movieapp.movies

import com.hanstcs.movieapp.data.repository.MoviesRepository

class MoviesPresenter(
        private val moviesView: MoviesContract.View,
        private val moviesRepository: MoviesRepository
) : MoviesContract.Presenter {

    init {
        moviesView.setPresenter(this)
    }

    override fun loadMovies() {
        moviesView.showMovies(moviesRepository.getMovies())
    }
}
