package com.portillo.naomyportillo.weatherapi.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRetroSingleton {

    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance != null){
            return instance;
        }
        instance = new Retrofit.Builder()
                .baseUrl("https://api.aerisapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return instance;
    }

    private WeatherRetroSingleton(){}
}
