package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BreweryServiceImpl {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    private static final String API_URL = "https://api.openbrewerydb.org/v1";

    public Brewery getBrewery(String id) throws Exception{
        Brewery response = restTemplate.exchange(
                        API_URL + id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Brewery>() {}
                )
                .getBody();

        return response;
    }

    public List<Brewery> getAllBreweries() throws Exception{
        List<Brewery> responseJson =  restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Brewery>>() {}
                )
            .getBody();

        return responseJson;
    }



}
