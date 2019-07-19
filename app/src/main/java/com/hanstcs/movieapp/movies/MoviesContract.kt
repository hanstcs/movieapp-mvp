package com.hanstcs.movieapp.movies;

import com.hanstcs.movieapp.base.BaseView;
import com.hanstcs.movieapp.data.Movies;

interface MoviesContract {
    interface View : BaseView<Presenter> {
        fun showMovies(movies: MutableList<Movies>)
    }

    interface Presenter {
        fun loadMovies()
    }
}
