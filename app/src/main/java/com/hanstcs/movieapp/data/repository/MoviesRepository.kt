package com.hanstcs.movieapp.data.repository

import com.hanstcs.movieapp.data.Movies

import java.util.ArrayList

class MoviesRepository private constructor() {

    companion object {
        // For singleton instantiation
        @Volatile
        private var INSTANCE: MoviesRepository? = null

        fun getInstance(): MoviesRepository {
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: MoviesRepository().also { INSTANCE = it }
            }

            return INSTANCE!!
        }
    }

    fun getMovies(): MutableList<Movies> {
        val movies = ArrayList<Movies>()
        movies.add(Movies("1", "The lord of the rings", "2009-12-10"))
        movies.add(Movies("2", "The fallen and rise of the rome empire", "2017-10-25"))
        movies.add(Movies("3", "Thor: Ragnarok", "2017-10-25"))
        return movies
    }
}
