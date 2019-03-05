package com.portillo.naomyportillo.weatherapi;

public class WeatherModel {

    private int maxTempF;
    private int minTempF;
    private String dateTimeISO;
    private String weather;

    public WeatherModel(int maxTempF, int minTempF, String dateTimeISO, String weather) {
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

    public int getMaxTempF() {
        return maxTempF;
    }

    public void setMaxTempF(int maxTempF) {
        this.maxTempF = maxTempF;
    }

    public int getMinTempF() {
        return minTempF;
    }

    public void setMinTempF(int minTempF) {
        this.minTempF = minTempF;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }
}
