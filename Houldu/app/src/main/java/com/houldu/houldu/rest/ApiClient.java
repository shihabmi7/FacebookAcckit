package com.ucabs.passenger.rest;

import com.ucabs.passenger.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amir on 11/26/2016.
 */

public class ApiClient {

//    http://u-cabs.com/ksa
//    public static final String BASE_URL = "http://dev.riverbelt.com/taxiapi/api/";
//    public static final String BASE_URL = "http://u-cabs.com";
    //    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.TAXI_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}