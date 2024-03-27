package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;
import com.example.caskmaster.dto.MetaData;

import java.util.List;

public interface BreweryService {

    Brewery getBrewery(String id);

    List<Brewery> getBreweries();

    List<Brewery> searchForBreweries(String... criteria);

    List<Brewery> getRandomBrewery();

    MetaData getMetaData(String... criteria);

}

