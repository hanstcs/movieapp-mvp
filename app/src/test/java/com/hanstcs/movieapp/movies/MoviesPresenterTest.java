package com.hanstcs.movieapp.movies;

import com.hanstcs.movieapp.data.Movies;
import com.hanstcs.movieapp.data.repository.MoviesRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class MoviesPresenterTest {

    private static List<Movies> MOVIES;

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
        MOVIES.add(new Movies("1", "The lord of the rings", "2009-12-10"));
        MOVIES.add(new Movies("2", "The lord of the rings 2", "2012-12-10"));
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
