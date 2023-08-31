package com.instantsystem.casestudy.parkingspot.exceptions;

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
