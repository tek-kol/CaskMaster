package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BreweryService {
    //RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.openbrewerydb.org/v1";


    public String getAllBreweries() {
        // configure rest template
        RestTemplate restTemplate = new RestTemplate();
        // call brewery api
        // return results

        return restTemplate.getForEntity(API_URL + "/breweries", String.class).getBody();
    }


    public List<Brewery> getBreweries() {
        // FIXME: implement this and remove previous method
        return null;
    }
}
