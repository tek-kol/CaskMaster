import com.example.caskmaster.dto.Brewery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class TestClazz {
    private static final String URL = "https://api.openbrewerydb.org/v1/breweries";

    @Test
    void simpleExampleTest() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(URL, String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

    @Test
    void getOneBrewery() {
        RestTemplate restTemplate = new RestTemplate();
        String dataSource = "https://api.openbrewerydb.org/v1/breweries/b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0";
        ResponseEntity<String> response
                = restTemplate.getForEntity(dataSource, String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

    @Test
    void getBreweries() {
        RestTemplate restTemplate = new RestTemplate();
        String dataSource = "https://api.openbrewerydb.org/v1/breweries/b54b16e1-ac3b-4bff-a11f-f7ae9ddc27e0";
        ResponseEntity<String> response
                = restTemplate.getForEntity(dataSource, String.class);
        System.out.println(response.getBody());
        List<Brewery> breweryList = new ArrayList<>();

    }




    // Where should this List live in the App?
    // -
    // Will I need to modify data here?
    // - Not really, just reading and display: Stream > Collectors?
    // 201

    // Need the data
    // Need it in a List<dto>
    // return crap from the list
    // REST template map to Collection

    // application properties
    //


}
