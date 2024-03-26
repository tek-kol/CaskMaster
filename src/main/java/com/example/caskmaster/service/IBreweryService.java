package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.List;

public interface IBreweryService {

    Brewery getBrewery(String id);

    List<Brewery> getBreweries();

    List<Brewery> searchForBreweries(String... criteria);

    List<Brewery> getRandomBrewery();

    // TODO: add getMetaData call
}

