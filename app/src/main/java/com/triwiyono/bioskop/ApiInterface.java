package com.triwiyono.bioskop;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.triwiyono.bioskop.ApiInterface.DB_API;


/**
 * Created by twonno on 2/25/2018.
 */

public interface ApiInterface {

    public static String DB_API = "f46e14c5f5e0e7be5260d75ee36e86dc";

    @GET("3/movie/popular?api_key="+DB_API)
    Call<Movie> getPopular();

    @GET("3/movie/top_rated?api_key="+DB_API)
    Call<Movie> getTopRated();

    @GET("3/movie/upcoming?api_key="+DB_API)
    Call<Movie> getUpcoming();

    @GET("3/movie/now_playing?api_key="+DB_API)
    Call<Movie> getNowplaying();


    //MOVIE SEARCH AUTOCOMPLETE
    @GET("3/search/movie?api_key="+DB_API)
    Call<Movie> getSearch(@Query("search") String search);


    
}
