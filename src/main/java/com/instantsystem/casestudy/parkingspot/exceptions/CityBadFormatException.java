package com.instantsystem.casestudy.parkingspot.exceptions;

/**
 * Exception thrown when an unexpected character is requested.
 */
public class CityBadFormatException extends RuntimeException{
    /**
     * CityBadFormatException constructor.
     * @param message
     */
    public CityBadFormatException(String message) {
        super(message);
    }
}
