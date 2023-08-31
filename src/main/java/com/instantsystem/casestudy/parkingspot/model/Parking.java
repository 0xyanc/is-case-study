package com.instantsystem.casestudy.parkingspot.model;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 * ParkingSpot entity showing the location of the parking lot and the number of available spots.
 */
public class Parking {
    @JsonbProperty("fields")
    private ParkingSpot parkingSpot;

    @JsonbCreator
    public Parking(
            @JsonbProperty("fields") ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
