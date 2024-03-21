package com.example.caskmaster.controller;

import com.example.caskmaster.service.BreweryService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreweryController {

private final BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }


    @GetMapping("/breweries")
public ResponseEntity<String> getAllBreweries() {
    // call service class
    // return results in the form of a ResponseEntity
        return new ResponseEntity<>(breweryService.getAllBreweries(), HttpStatusCode.valueOf(201));
}







}
