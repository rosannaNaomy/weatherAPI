package com.portillo.naomyportillo.weatherapi.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.portillo.naomyportillo.weatherapi.MainActivity;
import com.portillo.naomyportillo.weatherapi.R;
import com.portillo.naomyportillo.weatherapi.WeatherModel;

public class WeatherHolder extends RecyclerView.ViewHolder {

    private static final String PARTLY_CLOUDY = "Partly Cloudy";
    private static final String MOSTLY_SUNNY = "Mostly Sunny";
    private static final String MOSTLY_CLOUD_LWM = "Mostly Cloudy with Chance of Light Wintry Mix";

    private TextView dateTextView;
    private ImageView weatherImageView;
    private TextView maxTextView;
    private TextView minTextView;
    private Button toggleButton;


    public WeatherHolder(@NonNull View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.date_text);
        weatherImageView = itemView.findViewById(R.id.weather_imageview);
        maxTextView = itemView.findViewById(R.id.maxtemp_textview);
        minTextView = itemView.findViewById(R.id.mintemp_textview);
        //toggleButton = itemView.findViewById(R.id.toggle_weather_button);
    }

    public void onBind(final WeatherModel weatherModel, SharedPreferences sharedPreferences) {


        dateTextView.setText(weatherModel.getDateTimeISO());
        checkWeather(weatherModel.getWeather());

        if (sharedPreferences.getString(MainActivity.WEATHER_KEY, MainActivity.WEATHER_F).equals(MainActivity.WEATHER_F)) {
            String lowTemp = String.valueOf(weatherModel.getMinTempF()) + "\u00b0" + "F";
            String highTemp = String.valueOf(weatherModel.getMaxTempF()) + "\u00b0" + "F";

            minTextView.setText(lowTemp);
            maxTextView.setText(highTemp);
        } else if (sharedPreferences.getString(MainActivity.WEATHER_KEY, MainActivity.WEATHER_C).equals(MainActivity.WEATHER_C)) {

            String lowTemp = String.valueOf(weatherModel.getMinTempC()) + "\u00b0" + "C";
            String highTemp = String.valueOf(weatherModel.getMaxTempC()) + "\u00b0" + "C";

            minTextView.setText(lowTemp);
            maxTextView.setText(highTemp);
        }
    }

    public void checkWeather(String weather) {

        switch (weather) {
            case MOSTLY_CLOUD_LWM:
                weatherImageView.setImageResource(R.drawable.pcloudysfw);
                break;
            case MOSTLY_SUNNY:
                weatherImageView.setImageResource(R.drawable.sunny);
                break;
            case PARTLY_CLOUDY:
                weatherImageView.setImageResource(R.drawable.pcloudy);
                break;
            default:
                break;
        }
    }

}
