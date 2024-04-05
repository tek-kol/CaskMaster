package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.BreweryApiMetaData;
import com.example.caskmaster.dto.SearchCriteria;

import java.util.List;
import java.util.Map;

public interface BreweryService {

    Brewery getBrewery(String id);

    List<Brewery> getBreweries();

    List<Brewery> searchForBreweries(SearchCriteria searchCriteria);

    List<Brewery> getRandomBrewery();

    BreweryApiMetaData getMetaData();

}

