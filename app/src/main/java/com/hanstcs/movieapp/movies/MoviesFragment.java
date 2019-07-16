package com.hanstcs.movieapp.movies;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanstcs.movieapp.R;
import com.hanstcs.movieapp.data.repository.MoviesRepository;

import java.util.ArrayList;
import java.util.List;

public class MoviesFragment extends Fragment implements MoviesContract.View {

    private MoviesContract.Presenter mPresenter;
    private MoviesAdapter mAdapter;

    public MoviesFragment() {
    }

    public static MoviesFragment newInstance() {
        return new MoviesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new MoviesPresenter(this, MoviesRepository.getInstance());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.movies_fragment, container, false);

        RecyclerView rvMovies = root.findViewById(R.id.rvMovies);
        addMoviesRecyclerView(rvMovies);
        mPresenter.loadMovies();

        return root;
    }

    private void addMoviesRecyclerView(RecyclerView rvMovies) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMovies.setLayoutManager(layoutManager);
        mAdapter = new MoviesAdapter(new ArrayList<String>(0));
        rvMovies.setAdapter(mAdapter);
    }

    @Override
    public void setPresenter(MoviesContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMovies(List<String> movies) {
        mAdapter.replaceData(movies);
    }
}
