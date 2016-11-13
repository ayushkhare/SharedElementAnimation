package com.example.ayush.sharedelementanimation.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ayush.sharedelementanimation.NextActivity;
import com.example.ayush.sharedelementanimation.R;
import com.example.ayush.sharedelementanimation.model.Movie;

import java.util.List;

/**
 * Created by ayush on 12/11/16
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private List<Movie> mMovieList;
    private Context mContext;

    public MovieAdapter(List<Movie> mMovieList, Context context) {
        this.mMovieList = mMovieList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Movie movie = mMovieList.get(position);
        //Loading image using Glide
        Glide.with(mContext)
                .load(movie.getImage())
                .into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.description.setText(movie.getDescription());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, NextActivity.class);
                intent.putExtra("poster", movie.getImage());
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("genre", movie.getGenre());
                intent.putExtra("year", movie.getYear());
                Pair<View, String> p1 = Pair.create((View) holder.poster, mContext.getString(R.string.image_transition));
                Pair<View, String> p2 = Pair.create(((View) holder.title), mContext.getString(R.string.title_transition));
                Pair<View, String> p3 = Pair.create(((View) holder.genre), mContext.getString(R.string.genre_transition));
                Pair<View, String> p4 = Pair.create(((View) holder.year), mContext.getString(R.string.year_transition));
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext, p1, p2, p3, p4);
                mContext.startActivity(intent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView poster;
        private TextView title;
        private TextView description;
        private TextView genre;
        private TextView year;

        public ViewHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.image);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            genre = (TextView) itemView.findViewById(R.id.genre);
            year = (TextView) itemView.findViewById(R.id.year);
        }
    }
}
