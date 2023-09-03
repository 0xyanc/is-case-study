# Instant System Case Study

The goal of this case study is to develop a "server" exposing a REST API that will be called by mobile applications or websites allowing them to display the list of nearby parking lots with the number of available spots etc.
This case study is focused on Poitiers with public APIs to fetch data:
* [parking lots](https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilite-parkings-grand-poitiers-donnees-metiers&rows=1000&facet=nom_du_parking&facet=zone_tarifaire&facet=statut2&facet=statut3)
* [real time available spots](https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilites-stationnement-des-parkings-en-temps-reel&facet=nom)

## Constraints
* The application must also function in other cities: URL and data format could be different but the exposed API must not change
* Only the server side should be implemented, not the mobile application

## Technology
* Java 17
* Spring Boot
* Maven
* OpenAPI Specification
* Postman
* JSON-B

## API Design
### Implemented Design
* The goal is to minimise the amount of data returned to cater to mobile users with limited bandwidth
* The choice was made to allow a query parameter for the city. We could imagine there would be a city selector in the app for the user to choose where he is currently located
* I imagine the mobile app calling the API for available parking spots which will return all parking spots. The app stores the data locally, displays on the map depending on the zoom and calculates the distance.
* The benefit is to have fewer network calls but the tradeoff is more work on the mobile app 
* /parkings and /parkings/{parkingId} can be used to get more details for a specific parking lot. For example when a user clicks on the interface to check the max height. (not implemented)

### Alternative Design
* Another way to design the API would be pass coordinates and maxDistance parameters
* The server would be in charge of searching the parking lots in range and return the results along with the distance
* The benefit is to have less work/faster load on the mobile app and smaller payload for short distances but would require more network calls when the user zooms out

## Code Design
* Strategy Pattern can be used to allow adding new city with different data format easily. This would be implemented through a map of ParkingSpotService in ParkingSpotController
* I ran in some trouble injecting the dependencies for the unit tests of the controller so I removed this part for now
* All available cities are stored in CityEnum, a 404 Not Found will be returned a requested city does not exist in the enum

### Tests
* Minimal unit tests are written to test the functionalities but it is not near enough for an actual project
* A Postman collection is used for a scripted set of API requests

## Improvements
* Deployment - Ideally an image would be created in the CI/CD pipeline and then deployed in a Kubernetes cluster 
* Redundancy and High availability by deploying several instances in different locations
* Caching when calling the public APIs with a low TTL for the real time endpoint
* Authentication / Authorisation 
* Traffic management handling bots / surge of requests
* Add Logback for file rolling and patterned logs
* Configuration files for different environments
* Improve the logic of JSON parsing from the response from "real time parking" endpoint and add checks on presence/absence of required fields (e.g. geo_point_2d). Otherwise find the coordinates another way.
* Implement the Strategy Pattern and update unit tests to inject services for each city.
* Mock the API call to real time parking API / Add mock JSON files to test different response bodies
* Add exhaustive test cases for all branches of the code (e.g. in ParkingSpotService: different return calls from the external API, more tests on the returned JSON)
* Integration tests that requests all the layers
* The part of code that call external endpoint can be extracted out in a common helper class so that it can be reused by other services
