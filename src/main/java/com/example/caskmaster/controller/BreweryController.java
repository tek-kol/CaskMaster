package com.example.caskmaster.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreweryController {
final String API_URL= "https://api.openbrewerydb.org/v1";
    @GetMapping(API_URL + "/breweries")
        public String test() {
            return "Hey";
        }


}
