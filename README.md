# Instant System Case Study

The goal of this case study is to develop a "server" exposing a REST API that will be called by mobile applications or websites allowing them to display the list of nearby parking lots with the number of available spots etc.
This case study is focused on Poitiers with public APIs to fetch data:
* [parking lots](https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilite-parkings-grand-poitiers-donnees-metiers&rows=1000&facet=nom_du_parking&facet=zone_tarifaire&facet=statut2&facet=statut3)
* [real time available spots](https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilites-stationnement-des-parkings-en-temps-reel&facet=nom)

## Constraints
* The application must also function in other cities: URL and data format could be different but the exposed API must not change
* Only the server side should be implemented, not the mobile application

## Technology
* Spring Boot
* Maven
* OpenAPI Specification

## API Design
Minimise the amount of data returned to cater to mobile users with limited bandwidth

## Deployment
Ideally an image would be created in the CI/CD pipeline and then deployed in a Kubernetes cluster

## Improvements
Caching
Authorisation
Traffic management (handling bots/surge of requests)