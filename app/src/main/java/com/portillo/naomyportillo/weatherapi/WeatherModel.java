package com.portillo.naomyportillo.weatherapi;

public class WeatherModel {

    private int maxTempF;
    private int minTempF;
    private int maxTempC;
    private int minTempC;
    private String dateTimeISO;
    private String weather;

    public WeatherModel(int maxTempF, int minTempF, int maxTempC, int minTempC, String dateTimeISO, String weather) {
        this.maxTempF = maxTempF;
        this.minTempF = minTempF;
        this.maxTempC = maxTempC;
        this.minTempC = minTempC;
        this.dateTimeISO = dateTimeISO;
        this.weather = weather;
    }

    public int getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(int maxTempC) {
        this.maxTempC = maxTempC;
    }

    public int getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(int minTempC) {
        this.minTempC = minTempC;
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
