package com.instantsystem.casestudy.parkingspot.cityservice;

import com.instantsystem.casestudy.parkingspot.model.ParkingSpot;

import java.util.List;

/**
 * Interface for ParkingSpotService.
 */
public interface ParkingSpotService {
    /**
     * Retrieves the list of ParkingSpot by calling public endpoints.
     * @return the list of ParkingSpot after retrieving data from public endpoints.
     */
    public List<ParkingSpot> getParkingSpots();
}
