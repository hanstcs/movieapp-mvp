package com.hanstcs.movieapp.movies

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hanstcs.movieapp.R
import com.hanstcs.movieapp.data.Movies
import com.hanstcs.movieapp.data.repository.MoviesRepository

import java.util.ArrayList

class MoviesFragment : Fragment(), MoviesContract.View {

    private lateinit var mPresenter: MoviesContract.Presenter
    private lateinit var mAdapter: MoviesAdapter

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = MoviesPresenter(this, MoviesRepository.getInstance())
    }

    @Nullable
    @Override
    override fun onCreateView(@NonNull inflater: LayoutInflater,
                              @Nullable container: ViewGroup?,
                              @Nullable savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.movies_fragment, container, false)

        val rvMovies = root.findViewById<RecyclerView>(R.id.rvMovies)
        addMoviesRecyclerView(rvMovies)
        mPresenter.loadMovies()

        return root
    }

    private fun addMoviesRecyclerView(rvMovies: RecyclerView) {
        val layoutManager = LinearLayoutManager(activity)
        rvMovies.layoutManager = layoutManager
        mAdapter = MoviesAdapter(ArrayList(0))
        rvMovies.adapter = mAdapter
    }

    override fun setPresenter(presenter: MoviesContract.Presenter) {
        mPresenter = presenter
    }

    override fun showMovies(movies: MutableList<Movies>) {
        mAdapter.replaceData(movies)
    }
}
