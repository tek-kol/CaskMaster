package com.example.caskmaster;

import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JsonTest {

    String json = "{\n" +
            "    \"id\": \"b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0\",\n" +
            "    \"name\": \"MadTree Brewing 2.0\",\n" +
            "    \"brewery_type\": \"regional\",\n" +
            "    \"address_1\": \"5164 Kennedy Ave\",\n" +
            "    \"address_2\": null,\n" +
            "    \"address_3\": null,\n" +
            "    \"city\": \"Cincinnati\",\n" +
            "    \"state_province\": \"Ohio\",\n" +
            "    \"postal_code\": \"45213\",\n" +
            "    \"country\": \"United States\",\n" +
            "    \"longitude\": \"-84.4137736\",\n" +
            "    \"latitude\": \"39.1885752\",\n" +
            "    \"phone\": \"5138368733\",\n" +
            "    \"website_url\": \"http://www.madtreebrewing.com\",\n" +
            "    \"state\": \"Ohio\",\n" +
            "    \"street\": \"5164 Kennedy Ave\"\n" +
            "}";

    @Test
    void parse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Brewery b =  mapper.readValue(json, Brewery.class);
        System.out.println("**********************************");
        System.out.println(b.toString());
        System.out.println("**********************************");
    }

    @Test
    void restTemplate_With_List() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.openbrewerydb.org/v1/breweries";

        ResponseEntity<List<Brewery>> response =  restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Brewery>>() {}
        );

        List<Brewery> list = response.getBody();
        Assertions.assertFalse(list.isEmpty());
    }
}
