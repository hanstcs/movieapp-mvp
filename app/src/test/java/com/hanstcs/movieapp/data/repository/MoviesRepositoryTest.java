package com.hanstcs.movieapp.data.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class MoviesRepositoryTest {

    private static List<String> MOVIES;

    @Mock
    private MoviesRepository mMoviesRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        MOVIES = new ArrayList<>();
        MOVIES.add("Lord of The Rings");
        MOVIES.add("Lord of The Rings 2");
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
