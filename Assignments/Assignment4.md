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
!! [Δ] EoD Git Push !!
[+] Make a package for Test.Service
    [+] Add BreweryServiceTest tests
    [+] Add the rest of the IBreweryService
!! Have the Test directory mirror the codebase + "Test" designator. !!
[+] Export BreweryServiceTest tests to codebase
[+] Figure out what this 'MetaData' business is about


[Code]

[+] BreweryController: What do we want to return? Json right? Or will the frontend prefer our List<Brewery>?
    > ResponseEntity agnostic to dataType, +  returnCode(xxx)
[+] BreweryServiceTest: getBrewery(), I am assigning Brewery = res, but when I assertTrue that res == Brewery.class; It fails, why?
    > Assertions.assertTrue(response.getBody() instanceof Brewery);
[+] I want a central place to organize my URLs, where should that live? What extension?
    > Lives in a future assignment
[+] Test.searchForBreweries is being garbage: In browser returns Array, in test, empty.
    ! SSL Error: Self signed certificate in certificate chain !
    > Make sure you are not trying to hit API endpoints from CaskMaster endpoints. Two different systems, dur.
[!] Search ById, when returning a null, what do we do with that? Why not return an empty?
    // Optionals?
    > Save it for error handling assignment

[Cosmetic]           
Redundant code?       
[+] It just looks better to me. y/n?
    > Don't chain functions

[+]'impl' Looks ugly, do I need Impl?
Will there be another class called 'BreweryService'?
    > It's Uggo, but is proper conventions, get over it.


reduce copy paste
set default value



[Miscellaneous]
Interface is to classes like Flower is to Rose, Lily, Daisy. 
Cannot instantiate a FLower without a subclass.
!! Is used to decouple code, adding flexibility. !!

change return type to the proper type response entity.

Gracefully separate error handling

[ ] Search 
    [ ] Invert



!!!!

How to handle a collection
