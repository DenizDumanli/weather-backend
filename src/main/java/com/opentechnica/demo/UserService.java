//-----------------------------------------------------
// Title: UserService
// Author: Deniz Dumanlı
// ID: 25337236168
// Section: 1
// Description: In this class there are methods for CRUD operations.
//-----------------------------------------------------
package com.opentechnica.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserService {



    public User getCountryValues(String cityName){

        //String name = properties.getName();
        String uri = "https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=25ce9a4245e57db06b97a903fa9987f5";
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(uri, String.class);
        s = s.replaceAll("[\"]*", "");
        s = s.replaceAll("[{}]",",");
        String[] arr = s.split(",");
        String country = "";
        String temp = "";
        String dt = "";
        for(String c: arr){
            String[] split = c.split(":");
            if(c.contains("country")){
                country = split[1] ;
            }else if(c.contains("temp:")){
                temp = split[1] ;
            }else if(c.contains("dt:")){
                dt = split[1] ;
            }
        }
        long unix_seconds = Long.valueOf(dt);
        //convert seconds to milliseconds
        Date date = new Date(unix_seconds*1000L);
        double val = Double.valueOf(temp)-273.15;
        temp = String.valueOf(val).substring(0,3) + "Celsius";
        // format of the date
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        User dolma = new User(temp, date, country, cityName);

        return dolma;
    }
}

