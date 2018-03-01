package com.triwiyono.bioskop;

import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by twonno on 2/25/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MovieHolder>{

    List<Result> results;
    public SearchAdapter(List<Result> results){
        this.results = results;
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_movie, parent, false);
        return new MovieHolder(view);

    }

    @Override
    public void onBindViewHolder(final MovieHolder holder, final int position) {
        Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/"+results.get(position).getPosterPath())
                .into(holder.Poster);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result data = results.get(position);
                Intent i = new Intent(holder.itemView.getContext(), DetailMovie.class);
                i.putExtra("movie", new GsonBuilder().create().toJson(data));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    public void setData(List<Result> results){
        this.results = results;
    }

    @Override
    public int getItemCount() {
        //return 0;
        return results.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        ImageView Poster;
        public MovieHolder(View itemView) {
            super(itemView);
            Poster = (ImageView)itemView.findViewById(R.id.poster);
        }
    }
}