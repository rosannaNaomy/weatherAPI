package com.portillo.naomyportillo.weatherapi;

public class WeatherModel {

    private String maxTempF;
    private String minTempF;
    private String dateTimeISO;
    private String weather;

    public WeatherModel(String maxTempF, String minTempF, String dateTimeISO, String weather) {
        this.maxTempF = maxTempF;
        this.minTempF = minTempF;
        this.dateTimeISO = dateTimeISO;
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getMaxTempF() {
        return maxTempF;
    }

    public void setMaxTempF(String maxTempF) {
        this.maxTempF = maxTempF;
    }

    public String getMinTempF() {
        return minTempF;
    }

    public void setMinTempF(String minTempF) {
        this.minTempF = minTempF;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }
}
