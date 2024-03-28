package service;

import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        String searchURL = "https://api.openbrewerydb.org/v1/breweries/search?query=san%20diego&per_page=3";
        Map<String, String> queries = new HashMap<>();
        queries.put("query", "san diego");

        // Builds URI
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(API_URL);
        String uri = uriBuilderFactory.uriString("/search")
                // Todo: How will I handle multiple queries DRY?
                .queryParam("query", "{query}")
                .queryParam("per_page", "{per_page}")
                .build("san diego", "3")
                .toString();
        System.out.println(uri);

        //  Todo: Note: SSL verification is still going to trash the return; but the URL matches what the API demands.
        ResponseEntity<List<Brewery>> response = execute(uri);

        List<Brewery> list = response.getBody();
        System.out.println(list.size());

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

    @Test
    void uriTest() {
        String randomUrlFrag = "/random";

        // return the same as randomURL
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(API_URL);
        String uri = uriBuilderFactory.uriString(randomUrlFrag).toUriString();

        ResponseEntity<List<Brewery>> response= execute(uri);
        List<Brewery> list = response.getBody();

        Assertions.assertFalse(list.isEmpty());
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

}

