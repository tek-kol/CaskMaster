package com.example.caskmaster.controller;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.BreweryApiMetaData;
import com.example.caskmaster.service.BreweryServiceImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BreweryController {

    private final BreweryServiceImpl breweryServiceImpl;

    public BreweryController(BreweryServiceImpl breweryServiceImpl) {
        this.breweryServiceImpl = breweryServiceImpl;
    }


    @GetMapping("/brewery/{id}")
    public ResponseEntity<Brewery> getBrewery(@PathVariable("id") String id) {
        Brewery brewery = breweryServiceImpl.getBrewery(id);

        if (brewery.equals(null)) {
            return new ResponseEntity<>(brewery, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(brewery, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/breweries")
    public ResponseEntity<List<Brewery>> getBreweries() {
        List<Brewery> list = breweryServiceImpl.getBreweries();

        if (list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/breweries/search")
    public ResponseEntity<List<Brewery>> searchForBreweries(@PathVariable("criteria") String criteria) {
        List<Brewery> list = breweryServiceImpl.searchForBreweries(criteria);

        if (list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/breweries/random")
    public ResponseEntity<List<Brewery>> getRandomBreweries() {
        List<Brewery> list = breweryServiceImpl.getRandomBrewery();

        if (list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/breweries/meta")
    public ResponseEntity<BreweryApiMetaData> getMetaData(@PathVariable("criteria") String criteria) {
        BreweryApiMetaData breweryApiMetaData = breweryServiceImpl.getMetaData(criteria);

        if (breweryApiMetaData.equals(new BreweryApiMetaData())) {
            return new ResponseEntity<>(breweryApiMetaData, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(breweryApiMetaData, HttpStatusCode.valueOf(200));
    }

}

