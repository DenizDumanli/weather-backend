//-----------------------------------------------------
// Title: User
// Author: Deniz Dumanlı
// ID: 25337236168
// Section: 1
// Description: This class has the attributes of user's.
//-----------------------------------------------------
package com.opentechnica.demo;

import java.util.Date;

public class User {

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

    String temp;
    Date dt;
    String country; // Name attribute for users

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    String cityName;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // This is a constructor for user.
    public User(String temp, Date dt, String country, String cityName) {
        super();

        this.temp = temp;
        this.dt = dt;
        this.country = country;
        this.cityName = cityName;
    }

}