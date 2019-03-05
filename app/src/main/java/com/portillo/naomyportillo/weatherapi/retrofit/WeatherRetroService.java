package com.portillo.naomyportillo.weatherapi.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherRetroService {
//    String ENDPOINT = "forecasts/new york city, ny?&format=json&filter=day&limit=7&fields=response.dateTimeISO,response.maxTempF,loc,response.minTempF,response.maxTempC,response.minTempC,response.response&client_id=n2YHtRnS0qfH7etNeOsFQ&client_secret=8fzYO96DFdlATtsTU9oQtgLHbWLhSp8ZlrzawYHG";
String ENDPOINT = "forecasts/new%20york%20city,%20ny?&format=json&filter=day&limit=7&fields=periods.dateTimeISO,periods.maxTempF,loc,periods.minTempF,periods.maxTempC,periods.minTempC,periods.weather&client_id=n2YHtRnS0qfH7etNeOsFQ&client_secret=8fzYO96DFdlATtsTU9oQtgLHbWLhSp8ZlrzawYHG";
    @GET(ENDPOINT)
    Call<WeatherData> getWeather();
}
