package com.hanstcs.movieapp.movies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar

import com.hanstcs.movieapp.R

class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        var moviesFragment =
                supportFragmentManager.findFragmentById(R.id.contentFrame)
        if (moviesFragment == null) {
            moviesFragment = MoviesFragment()
            addFragmentToActivity(moviesFragment);
        }
    }

    private fun addFragmentToActivity(moviesFragment: MoviesFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.contentFrame, moviesFragment)
        transaction.commit()
    }
}
