package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreweryServiceImpl implements IBreweryService {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    private static final String API_URL = "https://api.openbrewerydb.org/v1/breweries";


    @Override
    public Brewery getBrewery(String id) {
        Brewery brewery = new Brewery();

        try {
            ResponseEntity<Brewery> response = restTemplate.exchange(
                    API_URL + id,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            brewery = response.getBody();
            return brewery;
        } catch (RestClientException e) {
            // Todo: Log
        }
        return brewery;
    }

    @Override
    public List<Brewery> getBreweries() {
        List<Brewery> list = new ArrayList<>();

        try {
            ResponseEntity<List<Brewery>> response = restTemplate.exchange(
                    API_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            list = response.getBody();
            return list;
        } catch (RestClientException e) {
            // Todo: Log error
            System.out.println(e);
        }
        return list;
    }

    @Override
    public List<Brewery> searchForBreweries(String... criteria) {
        return null;
    }

    @Override
    public List<Brewery> getRandomBrewery() {
        String randomURL = "/random";

        List<Brewery> list;
        ResponseEntity<List<Brewery>> response = restTemplate.exchange(
                API_URL + randomURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                });

        list = response.getBody();
        return list;
    }
}


// Todo: Refactor those requests
// Todo: