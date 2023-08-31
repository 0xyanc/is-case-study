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

### Alternative Design
* Another way to design the API would be pass coordinates and maxDistance parameters
* The server would be in charge of searching the parking lots in range and return the results along with the distance
* The benefit is to have less work/faster load on the mobile app and smaller payload for short distances but would require more network calls when the user zooms out

## Code Design
* Strategy Pattern to allow adding new city with different data format easily. This is implemented through the map of ParkingSpotService in ParkingSpotController

### Tests
* Postman collection is used for a scripted set of API requests


## Improvements
* Deployment - Ideally an image would be created in the CI/CD pipeline and then deployed in a Kubernetes cluster 
* Caching when calling the public APIs with a low TTL for the real time endpoint
* Authentication / Authorisation 
* Traffic management handling bots / surge of requests
* Add Logback for file rolling and patterned logs
* Configuration files for different environments
* Improve the logic of JSON parsing from the response from "real time parking" endpoint and add checks on presence/absence of required fields (e.g. geo_point_2d). Otherwise find the coordinates another way.

## TODO
* Unit tests