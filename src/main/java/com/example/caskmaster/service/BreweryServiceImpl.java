package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.MetaData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    private static final String API_URL = "https://api.openbrewerydb.org/v1/breweries";


    @Override
    public Brewery getBrewery(String id) {
        ResponseEntity<Brewery> responseEntity = execute(id);
        return responseEntity.getBody();
    }

    @Override
    public List<Brewery> getBreweries() {
        ResponseEntity<List<Brewery>> responseEntity = execute();
        return responseEntity.getBody();
    }

    @Override
    public List<Brewery> searchForBreweries(String... criteria) {
        return null;
    }

    @Override
    public List<Brewery> getRandomBrewery() {
        String randomURL = "/random";
        ResponseEntity<List<Brewery>> responseEntity = execute(randomURL);
        return responseEntity.getBody();
    }

    @Override
    public MetaData getMetaData(String... criteria) {
        // Todo: Dont leave metaDataURL
        String metaDataURl = "/meta";
        MetaData metaData = new MetaData();
        try {
            ResponseEntity<MetaData> response = restTemplate.exchange(
                    API_URL + metaDataURl + criteria,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            metaData = response.getBody();
            return metaData;
        } catch (RestClientException e) {
            // Todo: Log
        }
        return metaData;
    }

    private ResponseEntity execute() {
        try {
            ResponseEntity<List<Brewery>> response = restTemplate.exchange(
                    API_URL,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            return response;
        } catch (RestClientException e) {
            // Todo: Log error
            System.out.println(e);
            return null;
        }
    }

    private ResponseEntity execute(String id) {
        StringBuilder url = new StringBuilder(API_URL);
        url.append("/" + id);
        try {
            ResponseEntity<Brewery> response = restTemplate.exchange(
                    url.toString(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            return response;
        } catch (RestClientException e) {
            // Todo: Log error
            System.out.println(e);
            return null;
        }
    }




}
