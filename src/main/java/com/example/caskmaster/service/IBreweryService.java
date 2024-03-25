package com.example.caskmaster.service;

import com.example.caskmaster.dto.Brewery;

import java.util.List;

public interface IBreweryService {

    Brewery getBrewery(String id);

    List<Brewery> getBreweries();

    List<Brewery> searchForBreweries(String... criteria);

    Brewery getRandomBrewery();

    // TODO: add getMetaData call
}
