package com.portillo.naomyportillo.weatherapi.retrofit;

import com.portillo.naomyportillo.weatherapi.WeatherModel;

import java.util.List;

public class WeatherResponse {

    private List<WeatherModel> periods;

    public List<WeatherModel> getPeriods() {
        return periods;
    }

    public void setPeriods(List<WeatherModel> periods) {
        this.periods = periods;
    }
}
