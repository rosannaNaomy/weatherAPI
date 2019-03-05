package com.portillo.naomyportillo.weatherapi.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.portillo.naomyportillo.weatherapi.R;
import com.portillo.naomyportillo.weatherapi.WeatherModel;

public class WeatherHolder extends RecyclerView.ViewHolder {

    private static final String PARTLY_CLOUDY = "Partly Cloudy";
    private static final String MOSTLY_SUNNY = "Mostly Sunny";
    private static final String MOSTLY_CLOUD_LWM = "Mostly Cloudy with Chance of Light Wintry Mix";

    private static TextView dateTextView;
    private static ImageView weatherImageView;
    private static TextView maxTextView;
    private static TextView minTextView;
    private static Button toggleButton;


    public WeatherHolder(@NonNull View itemView) {
        super(itemView);

        this.dateTextView = itemView.findViewById(R.id.date_text);
        this.weatherImageView = itemView.findViewById(R.id.weather_imageview);
        this.maxTextView = itemView.findViewById(R.id.maxtemp_textview);
        this.minTextView = itemView.findViewById(R.id.mintemp_textview);
        this.toggleButton = itemView.findViewById(R.id.toggle_weather_button);

    }

    public static void onBind(final WeatherModel weatherModel) {


        String lowTemp = String.valueOf(weatherModel.getMinTempF()) + "\u00b0" + "f";
        String highTemp = String.valueOf(weatherModel.getMaxTempF()) + "\u00b0" + "f";

        dateTextView.setText(weatherModel.getDateTimeISO());
        checkWeather(weatherModel.getWeather());
        minTextView.setText(lowTemp);
        maxTextView.setText(highTemp);


        //toggle(weatherModel);

    }

    private static void toggle(final WeatherModel weatherModel) {
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String lowTemp = String.valueOf(weatherModel.getMinTempC()) + "\u00b0" + "C";
                String highTemp = String.valueOf(weatherModel.getMaxTempC()) + "\u00b0" + "C";
                minTextView.setText(lowTemp);
                maxTextView.setText(highTemp);

            }
        });
    }


    public static void checkWeather(String weather) {

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
