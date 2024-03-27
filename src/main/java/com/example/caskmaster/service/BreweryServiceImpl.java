package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.BreweryApiMetaData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BreweryServiceImpl implements BreweryService {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    private static final String BASE_URL = "https://api.openbrewerydb.org/v1/breweries";


    @Override
    public Brewery getBrewery(String id){
        ResponseEntity<Brewery> response = restTemplate.getForEntity(buildUrl(id), Brewery.class);
        return response.getBody();
    }

    @Override
    public List<Brewery> getBreweries() {
        ResponseEntity<List<Brewery>> responseEntity = execute(BASE_URL);
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
    public BreweryApiMetaData getMetaData(String... criteria) {
        // Todo: Dont leave metaDataURL
        String metaDataURl = "/meta";
        BreweryApiMetaData breweryApiMetaData = new BreweryApiMetaData();
        try {
            ResponseEntity<BreweryApiMetaData> response = restTemplate.exchange(
                    BASE_URL + metaDataURl + criteria,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            breweryApiMetaData = response.getBody();
            return breweryApiMetaData;
        } catch (RestClientException e) {
            // Todo: Log
        }
        return breweryApiMetaData;
    }

    private ResponseEntity execute(String url) {
        ResponseEntity<List<Brewery>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );
        return response;
    }

    private String buildUrl(String fragment) {
        StringBuilder url = new StringBuilder(BASE_URL);
        url.append("/" + fragment);
        return url.toString();
    }


}
