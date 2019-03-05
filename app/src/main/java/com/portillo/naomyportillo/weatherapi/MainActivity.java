package com.portillo.naomyportillo.weatherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.portillo.naomyportillo.weatherapi.retrofit.WeatherData;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherResponse;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherRetroService;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherRetroSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    List<WeatherModel> weatherModelList;
    private static final String TAG = ".MainActivity" ;
    private static final String CLIENT_ID = "n2YHtRnS0qfH7etNeOsFQ";
    private static final String CLIENT_SECRET = "8fzYO96DFdlATtsTU9oQtgLHbWLhSp8ZlrzawYHG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        retrofitCall();

    }

    private void retrofitCall() {
        Retrofit retrofit = WeatherRetroSingleton.getInstance();
        WeatherRetroService weatherRetroService = retrofit.create(WeatherRetroService.class);
        Call<WeatherData> weatherDataCall = weatherRetroService.getWeather();
        weatherDataCall.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                weatherModelList = response.body().getResponse().get(0).getPeriods();

                Log.d(TAG, "Nummy - This retrofit call was successful " + response.body().toString());
                Log.d(TAG, "Nummy - " + weatherModelList.get(0).getWeather());

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d(TAG, "Nummy - On Failure, This retrofit call was not successful" + t.getMessage());
            }
        });
    }


}
