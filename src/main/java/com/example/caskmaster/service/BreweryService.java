package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.BreweryApiMetaData;

import java.util.List;

public interface BreweryService {

    Brewery getBrewery(String id);

    List<Brewery> getBreweries();

    List<Brewery> searchForBreweries(String... criteria);

    List<Brewery> getRandomBrewery();

    BreweryApiMetaData getMetaData();

}

