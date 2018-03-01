package com.triwiyono.bioskop;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by twonno on 2/25/2018.
 */

public class ApiClient{
    public static final String BASE_URL = "https://api.themoviedb.org/";
    public static Retrofit getRetforit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
