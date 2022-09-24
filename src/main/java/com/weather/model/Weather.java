package com.weather.model;

import java.util.Date;

public class Weather {
    String temp;
    Date dt;
    String country;
    String cityName;


    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Weather(String temp, Date dt, String country, String cityName) {
        super();
        this.temp = temp;
        this.dt = dt;
        this.country = country;
        this.cityName = cityName;
    }

}