package com.hanstcs.movieapp.movies;

import com.hanstcs.movieapp.repository.MoviesRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoviesPresenterTest {

    private static List<String> MOVIES;

    @Mock
    private MoviesRepository mMoviesRepository;

    @Mock
    private MoviesContract.View mMovieView;

    private MoviesPresenter mMoviesPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mMoviesPresenter = new MoviesPresenter(mMovieView, mMoviesRepository);

        MOVIES = new ArrayList<>();
        MOVIES.add("The rainbow flowers");
        MOVIES.add("Clash of Titan");
    }

    @Test
    public void createPresenter_willSetPresenterToView() {
        Mockito.verify(mMovieView).setPresenter(mMoviesPresenter);
    }

    @Test
    public void loadMoviesFromRepository_showToView() {
        Mockito.when(mMoviesRepository.getMovies()).thenReturn(MOVIES);
        mMoviesPresenter.loadMovies();
        Mockito.verify(mMovieView).showMovies(MOVIES);
    }
}
