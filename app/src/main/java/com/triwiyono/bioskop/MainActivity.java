package com.triwiyono.bioskop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView mView;
    MovieAdapter adapter;
    SearchAdapter sAdapter;
    List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mView = (RecyclerView)findViewById(R.id.moviewView);
        mView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        // movieLoad("toprated");
        movieSearch("search");

    }

    private void movieSearch(String value) {
        ApiInterface api = ApiClient.getRetforit().create(ApiInterface.class);
        Call<Movie> call = api.getSearch("value");

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
               
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.list_sort, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.popular){
            movieLoad("popular");
        }else if (id == R.id.toprated){
            movieLoad("toprated");
        }else if (id == R.id.upcoming) {
            movieLoad("upcoming");
        }else if (id == R.id.nowplaying) {
            movieLoad("now_playing");
        }
        return super.onOptionsItemSelected(item);
    }


    private void movieLoad(String value){
        ApiInterface api = ApiClient.getRetforit().create(ApiInterface.class);
        Call<Movie> call = null; //api.getSearch("search");

        if (value.equals("popular")){
            call = api.getPopular();
        }else if (value.equals("toprated")){
            call = api.getTopRated();
        }else if (value.equals("upcoming")) {
            call = api.getUpcoming();
        }else if (value.equals("now_playing")) {
            call = api.getNowplaying();
        }

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();
                adapter = new MovieAdapter(results);
                adapter.setData(movie.getResults());
                mView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }


}
