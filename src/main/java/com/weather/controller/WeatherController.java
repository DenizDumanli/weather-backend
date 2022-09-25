package com.weather.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.weather.model.Weather;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class WeatherController {

    WeatherService userService = new WeatherService();

    @Value("${city.name}")
    private String cityName;

    @RequestMapping(value = "/country", method = RequestMethod.GET, headers = "Accept=application/json")
    public Weather getCountry() throws JsonProcessingException {
        return userService.getCountryValues(cityName);
    }

}
