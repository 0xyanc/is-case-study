package com.instantsystem.casestudy.parkingspot;

/**
 * ParkingSpot entity showing the location of the parking lot and the number of available spots.
 * @param name
 * @param capacity
 * @param available
 * @param longitude
 * @param latitude
 */
public record ParkingSpot (String name, int capacity, int available, double longitude, double latitude){
}
