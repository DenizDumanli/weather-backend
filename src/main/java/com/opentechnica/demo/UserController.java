//-----------------------------------------------------
// Title: UserController
// Author: Deniz Dumanlı
// ID: 25337236168
// Section: 1
// Description: This class makes the CRUD operations of our program.
//-----------------------------------------------------
package com.opentechnica.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    UserService userService = new UserService(); // Here we create userService object.

    @Value("${city.name}")
    private String cityName;

    @RequestMapping(value = "/country", method = RequestMethod.GET, headers = "Accept=application/json")
    public User getCountry() {
        return userService.getCountryValues(cityName);
    }

}
