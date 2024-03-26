package service;

import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class BreweryServiceTest {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    private static final String API_URL = "https://api.openbrewerydb.org/v1/breweries";
    @Test
    void getBrewery() {
        String id = "/b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0";
        Brewery brewery;

        ResponseEntity<Brewery> response = restTemplate.exchange(
                        API_URL + id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {}
                );
        brewery = response.getBody();

        Assertions.assertInstanceOf(Brewery.class, brewery);
    }

    @Test
    void getBreweries() {
        List<Brewery> list;
        ResponseEntity<List<Brewery>> response= restTemplate.exchange(
            API_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<>() {});

        list = response.getBody();

        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void searchForBreweries(){
        String searchURL = "/search?query=san%20diego&per_page=3";

        ResponseEntity<List<Brewery>> response = restTemplate.exchange(
                API_URL + searchURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});

        List<Brewery> list = response.getBody();

        System.out.println(response.getStatusCode());
        System.out.println(list);

        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void getRandomBrewery() {
        String randomURL = "/random";

        List<Brewery> list;
        ResponseEntity<List<Brewery>> response= restTemplate.exchange(
                API_URL + randomURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});

        list = response.getBody();
        Assertions.assertFalse(list.isEmpty());
    }

}
