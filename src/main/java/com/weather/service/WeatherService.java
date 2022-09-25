package com.weather.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.model.Weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WeatherService {


    public Weather getCountryValues(String cityName) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=25ce9a4245e57db06b97a903fa9987f5";
        RestTemplate restTemplate = new RestTemplate();
        String s = restTemplate.getForObject(uri, String.class);
        JsonNode jsonNode = objectMapper.readTree(s);

        String temp = jsonNode.get("main").get("temp").asText();
        String dt = jsonNode.get("dt").asText();
        String country = jsonNode.get("sys").get("country").asText();

        double val = Double.parseDouble(temp) - 273.15;
        temp = String.valueOf(val).substring(0, 3) + " Celsius";

        long unix_seconds = Long.parseLong(dt);
        Date date = new Date(unix_seconds * 1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        jdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));
        Weather weather = new Weather(temp, date, country, cityName);

        return weather;
    }
}

