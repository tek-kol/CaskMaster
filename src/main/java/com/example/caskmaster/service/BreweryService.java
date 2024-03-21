package com.example.caskmaster.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BreweryService {
//RestTemplate restTemplate = new RestTemplate();
private static final String API_URL= "https://api.openbrewerydb.org/v1";



    public String getAllBreweries(){
        // configure rest template
        RestTemplate restTemplate = new RestTemplate();
        // call brewery api
        // return results
        return restTemplate.getForEntity(API_URL + "/breweries", String.class).getBody();
    }

}
