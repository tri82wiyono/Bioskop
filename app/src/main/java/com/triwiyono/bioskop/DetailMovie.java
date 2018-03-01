package com.triwiyono.bioskop;

import android.media.tv.TvContract;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetailMovie extends AppCompatActivity {
    ImageView Poster;
    TextView Judul, Rating, Tgl, Overview, Genres, Popularity, Originallanguage;

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        Poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView) findViewById(R.id.judul);
        Rating = (TextView) findViewById(R.id.rating);
        Tgl = (TextView) findViewById(R.id.tgl);
        Overview = (TextView) findViewById(R.id.overview);
        Genres = (TextView) findViewById(R.id.genres);
        Popularity = (TextView) findViewById(R.id.popularity);
        Originallanguage = (TextView) findViewById(R.id.originallanguage);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"), Result.class);

        Picasso.with(DetailMovie.this)
                .load("http://image.tmdb.org/t/p/w185"+result.getPosterPath())
                .into(Poster);
        Judul.setText("Movie Title :\n" +result.getTitle());
        Rating.setText("Vote Average :" +Double.toString(result.getVoteAverage()));
        Tgl.setText("Release Date :" +result.getReleaseDate());
        Genres.setText("Genres :" +result.getGenreIds());
        Popularity.setText("Popularity :" +result.getPopularity());
        Originallanguage.setText("Original Language :" +result.getOriginalLanguage());
        Overview.setText("Overview :" +result.getOverview());

    }
}
