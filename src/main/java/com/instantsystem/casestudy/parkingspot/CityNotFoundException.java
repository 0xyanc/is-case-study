package com.instantsystem.casestudy.parkingspot;

/**
 * Exception thrown when a requested city is not found.
 */
public class CityNotFoundException extends RuntimeException{
    /**
     * CityNotFoundException constructor.
     * @param message
     */
    public CityNotFoundException(String message) {
        super(message);
    }
}
