package service;

import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BreweryServiceTest {
    RestTemplate restTemplate = new RestTemplate();
    ObjectMapper mapper = new ObjectMapper();

    private static final String API_URL = "https://api.openbrewerydb.org/v1/breweries";

    @Test
    void getBrewery() throws Exception {
        String id = "/b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0";

        Brewery response = restTemplate.exchange(
                        API_URL + id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<Brewery>() {}
                )
                .getBody();
        System.out.println("**********************************");
        System.out.println(response);
        System.out.println("**********************************");
        Assertions.assertTrue(response.equals(Brewery.class));
    }

    @Test
    void getAllBreweries() {
        List<Brewery> response =  restTemplate.exchange(
            API_URL,
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Brewery>>() {})
            .getBody();

//        for (Brewery e : response) {
//            System.out.println(e.getName());
//        }

        Assertions.assertFalse(response.isEmpty());
    }

    @Test
    void searchForBreweries(){

    }

    @Test
    void getRandomBrewery() {

    }

}
