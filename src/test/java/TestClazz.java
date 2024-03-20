import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestClazz {

    @Test
    void simpleExampleTest() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://api.openbrewerydb.org/v1/breweries";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);



    }
}
