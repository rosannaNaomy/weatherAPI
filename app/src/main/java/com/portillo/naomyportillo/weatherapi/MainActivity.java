package com.portillo.naomyportillo.weatherapi;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.portillo.naomyportillo.weatherapi.recyclerview.WeatherAdapter;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherData;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherResponse;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherRetroService;
import com.portillo.naomyportillo.weatherapi.retrofit.WeatherRetroSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    List<WeatherModel> weatherModelList;
    private static final String TAG = ".MainActivity";
    RecyclerView recyclerView;
    WeatherAdapter weatherAdapter;
    private static Button toggleButton;
    SharedPreferences sharedPreferences;
    private final String SHAREDPREFERENCES_KEY = "SharedPrefs.Weather";
    public static final String WEATHER_F = "Farenheit";
    public static final String WEATHER_C = "Celsius";
    public static final String WEATHER_KEY = "Weather";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<WeatherModel> list = new ArrayList<>();
        sharedPreferences = getSharedPreferences(SHAREDPREFERENCES_KEY, MODE_PRIVATE);
        recyclerView = findViewById(R.id.weather_recycler_container);
        toggleButton = findViewById(R.id.toggle_weather_button);
        weatherAdapter = new WeatherAdapter(list, sharedPreferences);
        retrofitCall();

        toggle();

    }

    /**
     * Toggle Button:
     *
     * if my textview text equals Farenheit
     *
     * update shared prefrecnes
     */
    private void toggle() {
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( toggleButton.getText().toString().equalsIgnoreCase("FAHRENHEIT")) {

                    sharedPreferences.edit().putString( WEATHER_KEY, WEATHER_C).apply();
                    weatherAdapter.updateSP(sharedPreferences);
                    toggleButton.setText(WEATHER_C);
                    weatherAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
                } else if ( toggleButton.getText().toString().equalsIgnoreCase(WEATHER_C)) {

                    sharedPreferences.edit().putString( WEATHER_KEY, WEATHER_F).apply();
                    weatherAdapter.updateSP(sharedPreferences);
                    toggleButton.setText(WEATHER_F);
                    weatherAdapter.notifyDataSetChanged();
                }
            }
        });
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
                Log.d(TAG, "Nummy - " + weatherModelList.get(0).getMaxTempC());


                weatherAdapter = new WeatherAdapter(weatherModelList, sharedPreferences);
                recyclerView.setAdapter(weatherAdapter);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(layoutManager);
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d(TAG, "Nummy - On Failure, This retrofit call was not successful" + t.getMessage());
            }
        });
    }


}
