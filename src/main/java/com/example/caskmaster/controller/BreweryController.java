package com.example.caskmaster.controller;

import com.example.caskmaster.service.BreweryServiceImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreweryController {

    private final BreweryServiceImpl breweryServiceImpl;

    public BreweryController(BreweryServiceImpl breweryServiceImpl) {
        this.breweryServiceImpl = breweryServiceImpl;
    }


//    @GetMapping("/breweries")
//public ResponseEntity<String> getAllBreweries() {
//    // call service class
//    // return results in the form of a ResponseEntity
//        return new ResponseEntity<>(breweryServiceImpl.getAllBreweries(), HttpStatusCode.valueOf(201));
//}







}
