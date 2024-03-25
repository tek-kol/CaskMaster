# CaskMaster API
* The documentation for the API used for this sample project is found here:  https://www.openbrewerydb.org/documentation

### Prerequisites

* Spring Boot application is running with the latest code

### Assignment 4
* Implement the Brewery Service Interface
    * Guidelines
        * Rename BreweryService to BreweryServiceImpl
        * Rename IBreweryService to BreweryService
        * Implement the interface methods
        * test each method returns the expected results
      
[Todo]
[+] Make a package for Test.Service
    [ ] Add BreweryServiceTest tests
    [ ] Add the rest of the IBreweryService
    [ ] Test
!! Have the Test directory mirror the codebase + "Test" designator. !!
[ ] Export BreweryServiceTest tests to codebase
[ ] Figure out what this 'MetaData' business is about


[Code]
[ ] BreweryController: What do we want to return? Json right? Or will the frontend prefer our List<Brewery>?
    >
[ ] BreweryServiceTest: getBrewery(), I am assigning Brewery = res, but when I assertTrue that res == Brewery.class; It fails, why?
    >
anxious 

[Cosmetic]           
Redundant code?       
... It just looks better to me. y/n?
    >

'impl' Looks ugly, do I need Impl?
Will there be another class called 'BreweryService'?
    >





[Miscellaneous]
Interface is to classes like Flower is to Rose, Lily, Daisy. 
Cannot instantiate a FLower without a subclass.
!! Is used to decouple code, adding flexibility. !!




