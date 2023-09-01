package com.instantsystem.casestudy.parkingspot;

import com.instantsystem.casestudy.parkingspot.cityservice.ParkingSpotService;
import com.instantsystem.casestudy.parkingspot.exceptions.CityBadFormatException;
import com.instantsystem.casestudy.parkingspot.exceptions.CityNotFoundException;
import com.instantsystem.casestudy.parkingspot.model.CityEnum;
import com.instantsystem.casestudy.parkingspot.model.ParkingSpot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controller exposing endpoints to retrieve parking lots in the requested area and the associated number of available spots.
 */
@RestController
@RequestMapping(path="api/v1/spots")
public class ParkingSpotController {

    private Logger log = LoggerFactory.getLogger(ParkingSpotController.class);

    /**
     * Map of all the parking spot services where the key is the bean name. Allows for flexibility when adding a new city where the data format is different
     */
    private final Map<String, ParkingSpotService> parkingSpotServiceMap;

    /**
     * ParkingSpotController constructor.
     * @param parkingSpotServices
     */
    public ParkingSpotController(Map<String, ParkingSpotService> parkingSpotServices) {
        this.parkingSpotServiceMap = parkingSpotServices;
    }

    /**
     * Entry point for retrieving the parking lots with the number of available spots in the requested city.
     * @throws CityNotFoundException If the requested city does not exist
     * @param city default value "poitiers"
     * @return the list of parking lots with information about available spots.
     */
    @GetMapping
    public List<ParkingSpot> getParkingSpots(@RequestParam(defaultValue = "poitiers") String city) {
        if (!city.matches("[a-zA-Z]+")) {
            log.debug("Unexpected character in city " + city);
            throw new CityBadFormatException("Unexpected character - only letters are allowed");
        }
        CityEnum cityEnum = CityEnum.findByName(city);
        if (cityEnum == null) {
            log.debug("City not found " + city);
            throw new CityNotFoundException("City not found");
        } else {
            log.info("Getting parking spots for " + city);
            return parkingSpotServiceMap.get(cityEnum.name().toLowerCase()).getParkingSpots();
        }
    }

    /**
     * Handle CityNotFoundException thrown when the city passed in the request is not found.
     * @param ex
     * @return HTTP 404 with the error message
     */
    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCityNotFoundException(CityNotFoundException ex) {
        return ex.getMessage();
    }

    /**
     * Handle CityBadFormatException thrown when the city contains unexpected characters.
     * @param ex
     * @return HTTP 400 with the error message
     */
    @ExceptionHandler(CityBadFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleCityBadFormatException(CityBadFormatException ex) {
        return ex.getMessage();
    }
}
