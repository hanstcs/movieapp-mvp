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

    private MoviesRepository mMoviesRepository;

    @Mock
    private MoviesContract.View mMovieView;

    private MoviesPresenter mMoviesPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        mMoviesRepository = MoviesRepository.Companion.getInstance();
        mMoviesPresenter = new MoviesPresenter(mMovieView, mMoviesRepository);

        MOVIES = new ArrayList<>();
        MOVIES.add(new Movies("1", "The lord of the rings", "2009-12-10"));
        MOVIES.add(new Movies("2", "The fallen and rise of the rome empire", "2017-10-25"));
        MOVIES.add(new Movies("3", "Thor: Ragnarok", "2017-10-25"));
    }

    @Test
    public void createPresenter_willSetPresenterToView() {
        Mockito.verify(mMovieView).setPresenter(mMoviesPresenter);
    }

    @Test
    public void loadMoviesFromRepository_showToView() {
        mMoviesPresenter.loadMovies();
        Mockito.verify(mMovieView).showMovies(MOVIES);
    }
}
