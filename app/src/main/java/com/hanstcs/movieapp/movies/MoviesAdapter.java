package com.hanstcs.movieapp.movies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanstcs.movieapp.R;
import com.hanstcs.movieapp.data.Movies;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movies> mMovieList;

    MoviesAdapter(List<Movies> movies) {
        setList(movies);
    }

    private void setList(List<Movies> list) {
        mMovieList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.movie_item,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(mMovieList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public void replaceData(List<Movies> movies) {
        setList(movies);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void bind(Movies movie) {
            tvMovieTitle.setText(movie.getTitle());
        }
    }

}
