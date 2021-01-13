package com.example.getalbum;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {

    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static Retrofit getInstance() {
        Retrofit.Builder builder = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(GsonConverterFactory.create())
    }

}
