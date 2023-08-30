package com.instantsystem.casestudy.parkingspot;

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
