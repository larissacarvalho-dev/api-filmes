package com.larissa.filmesapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.larissa.filmesapi.R;
import com.larissa.filmesapi.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterHolder> {

    private List<Movie> movies;

    private Context context;

    public MovieAdapter(List<Movie> movies, Context context)
    {
        this.movies = movies;
        this.context= context;
    }

    @NonNull
    @Override
    public MovieAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);

        return new MovieAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterHolder holder, int position) {

        Movie movie = movies.get(position);
        holder.txtVotes.setText(movie.getVotes());
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w342/" + movie.getPoster())
                .apply(RequestOptions.placeholderOf(R.drawable.progress_animation))
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setData(List<Movie> movies){
        this.movies = movies;
        notifyDataSetChanged();
    }

    public class MovieAdapterHolder extends RecyclerView.ViewHolder{
        private TextView txtVotes;
        private ImageView imgPoster;

        public MovieAdapterHolder (@NonNull View itemView){
            super(itemView);
            txtVotes = itemView.findViewById(R.id.txtVotes1);
            imgPoster = itemView.findViewById(R.id.imgPoster1);
        }

    }
}
