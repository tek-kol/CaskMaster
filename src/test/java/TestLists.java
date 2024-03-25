import com.example.caskmaster.dto.Brewery;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class TestLists {
    private static final String URL = "https://api.openbrewerydb.org/v1/breweries";
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
    void mapToObject() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Brewery newBrew = mapper.readValue(json, Brewery.class);
        Assertions.assertNotNull(newBrew);

    }

    @Test
    void mapToList() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        
//        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
////X
//        List<Brewery> list = mapper.readValue(response.getBody(), List.class);

//        Brewery[] brewArray = mapper.readValue(response.getBody(), Brewery[].class);
//        List<Brewery> list = Arrays.asList(brewArray);
//
//        System.out.println(list.get(0));
//        System.out.println("");
//        System.out.println(list.get(1));
//        System.out.println("");
//        System.out.println(list.get(2));

    }

}
