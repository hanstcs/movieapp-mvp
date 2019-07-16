package com.hanstcs.movieapp.data.repository;

import com.hanstcs.movieapp.data.Movies;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class MoviesRepositoryTest {

    private static List<Movies> MOVIES;

    @Mock
    private MoviesRepository mMoviesRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        MOVIES = new ArrayList<>();
        MOVIES.add(new Movies("1", "The lord of the rings", "2009-12-10"));
        MOVIES.add(new Movies("2", "The lord of the rings 2", "2012-12-10"));
    }

    @Test
    public void getMovies_willReturnListOfMovies() {
        Mockito.when(mMoviesRepository.getMovies()).thenReturn(MOVIES);
    }

    @Test
    public void getInstance_willReturnInstanceOfMoviesRepository() {
        mMoviesRepository = MoviesRepository.getInstance();
        Assert.assertSame(MoviesRepository.getInstance(), mMoviesRepository);
    }
}
