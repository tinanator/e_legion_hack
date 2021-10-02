package com.example.aq.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    public static final String BASE_URL = "https://elegioner.000webhostapp.com/api/";
    private static Retrofit sRetrofit;

    public static Retrofit getInstance() {
        if(sRetrofit != null) {
            return sRetrofit;
        }

        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return sRetrofit;
    }
}
