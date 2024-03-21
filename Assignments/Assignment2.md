# CaskMaster API
* The documentation for the API used for this sample project is found here:  https://www.openbrewerydb.org/documentation

### Prerequisites

* Spring Boot application is running with the latest code

### Assignment 2
* Write controller class and GET request endpoint to retrieve list of all breweries
    * Guidelines
        * write a new controller class in the controller package
          * the method in the controller you write should return a  ResponseEntity object
          * the ResponseEntity will contain the raw data retrieved along with an HttpStatus code
        * write a new class in the service package to request the brewery data
            * RestTemplate should be used to retrieve brewery data
              