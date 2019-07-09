package com.hanstcs.movieapp.movies;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanstcs.movieapp.R;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<String> mMovieList;

    MoviesAdapter(List<String> movies) {
        setList(movies);
    }

    private void setList(List<String> list) {
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

    public void replaceData(List<String> movies) {
        setList(movies);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void bind(String movie) {
            tvMovieTitle.setText(movie);
        }
    }

}
