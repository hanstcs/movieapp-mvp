package com.hanstcs.movieapp.movies

import android.support.annotation.NonNull
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.hanstcs.movieapp.R
import com.hanstcs.movieapp.data.Movies

class MoviesAdapter(var movies: List<Movies>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item, parent, false))
    }

    override fun onBindViewHolder(@NonNull viewHolder:  ViewHolder, position: Int) {
        viewHolder.bind(movies[position])
    }

    override fun getItemCount() : Int {
        return this.movies.size
    }

    fun replaceData(movies : List<Movies>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class ViewHolder(@NonNull itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val tvMovieTitle = itemView.findViewById<TextView>(R.id.tvMovieTitle)

        fun bind(movie: Movies) {
            tvMovieTitle.text = movie.title
        }
    }
}
