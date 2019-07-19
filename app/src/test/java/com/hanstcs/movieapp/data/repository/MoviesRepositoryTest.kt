package com.hanstcs.movieapp.data.repository

import com.hanstcs.movieapp.data.Movies

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class MoviesRepositoryTest {

    private lateinit var MOVIES: List<Movies>

    private lateinit var moviesRepository: MoviesRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        moviesRepository = MoviesRepository.getInstance()
        MOVIES = ArrayList()

        (MOVIES as ArrayList<Movies>).add(Movies("1", "The lord of the rings", "2009-12-10"))
        (MOVIES as ArrayList<Movies>).add(Movies("2", "The fallen and rise of the rome empire", "2017-10-25"))
        (MOVIES as ArrayList<Movies>).add(Movies("3", "Thor: Ragnarok", "2017-10-25"))
    }

    @Test
    fun getMovies_willReturnListOfMovies() {
        Assert.assertEquals(moviesRepository.getMovies(), MOVIES)
    }

    @Test
    fun getInstance_willReturnInstanceOfMoviesRepository() {
        moviesRepository = MoviesRepository.getInstance()
        Assert.assertSame(MoviesRepository.getInstance(), moviesRepository)
    }
}
