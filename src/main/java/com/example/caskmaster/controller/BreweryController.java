package com.example.caskmaster.controller;

import com.example.caskmaster.service.BreweryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BreweryController {

private final BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }


    @GetMapping("/breweries")
public ResponseEntity<String> getAllBreweries() {
    // FIXME: implement this
    // call service class
        ResponseEntity<String> response = breweryService.getAllBreweries();
    // return  results in the form of a ResponseEntity
        return response;
}







}
