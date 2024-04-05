package com.example.caskmaster.controller;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.BreweryApiMetaData;
import com.example.caskmaster.dto.SearchCriteria;
import com.example.caskmaster.service.BreweryServiceImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/breweries")
public class BreweryController {

    private final BreweryServiceImpl breweryServiceImpl;

    public BreweryController(BreweryServiceImpl breweryServiceImpl) {
        this.breweryServiceImpl = breweryServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Brewery> getBrewery(@PathVariable String id) {
        Brewery brewery = breweryServiceImpl.getBrewery(id);

        if (brewery.equals(null)) {
            return new ResponseEntity<>(brewery, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(brewery, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<Brewery>> getBreweries() {
        List<Brewery> list = breweryServiceImpl.getBreweries();


        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Brewery>> searchForBreweries(@RequestBody SearchCriteria searchCriteria) {
        List<Brewery> list = breweryServiceImpl.searchForBreweries(searchCriteria);

        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/search2")
    public ResponseEntity<List<Brewery>> searchTest(@RequestParam("qq") String searchTerm, @RequestParam("pp") int perPage) {
        SearchCriteria searchCriteria = SearchCriteria
                .builder()
                .searchTerm(searchTerm)
                .perPage(perPage)
                .build();

        List<Brewery> list = breweryServiceImpl.searchForBreweries(searchCriteria);
        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }


    @GetMapping("/random")
    public ResponseEntity<List<Brewery>> getRandomBreweries() {
        List<Brewery> list = breweryServiceImpl.getRandomBrewery();

        if (list.isEmpty()) {
            return new ResponseEntity<>(list, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/meta")
    public ResponseEntity<BreweryApiMetaData> getMetaData() {
        BreweryApiMetaData breweryApiMetaData = breweryServiceImpl.getMetaData();

        if (breweryApiMetaData.equals(null)) {
            return new ResponseEntity<>(breweryApiMetaData, HttpStatusCode.valueOf(404));
        }

        return new ResponseEntity<>(breweryApiMetaData, HttpStatusCode.valueOf(200));
    }

}

