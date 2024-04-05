package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.BreweryApiMetaData;
import com.example.caskmaster.dto.SearchCriteria;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BreweryServiceImpl implements BreweryService {
    RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "https://api.openbrewerydb.org/v1/breweries";


    @Override
    public Brewery getBrewery(String id){
        StringBuilder fragment = new StringBuilder();
        fragment.append(buildUrl(id));
        ResponseEntity<Brewery> response = restTemplate.getForEntity(fragment.toString(), Brewery.class);
        return response.getBody();
    }

    @Override
    public List<Brewery> getBreweries() {
        ResponseEntity<List<Brewery>> responseEntity = execute(BASE_URL);
        return responseEntity.getBody();
    }

    @Override
    public List<Brewery> searchForBreweries(SearchCriteria searchCriteria) {
        String url = buildUrl("search", searchCriteria);
        ResponseEntity<List<Brewery>> response = execute(url);
        return response.getBody();
    }

    @Override
    public List<Brewery> getRandomBrewery() {
        ResponseEntity<List<Brewery>> response = execute(buildUrl("random"));
        return response.getBody();
    }

    @Override
    public BreweryApiMetaData getMetaData() {
        ResponseEntity<BreweryApiMetaData> response = restTemplate.getForEntity(buildUrl("meta"), BreweryApiMetaData.class);
        return response.getBody();
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
        url.append("/").append(fragment);
        return url.toString();
    }

    private String buildUrl(String fragment, SearchCriteria searchCriteria){
        String frag = buildUrl(fragment);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(frag);


        return uriComponentsBuilder
                .queryParam("query", searchCriteria.getSearchTerm())
                .queryParam("per_page", searchCriteria.getPerPage())
                .toUriString();
    }


}
