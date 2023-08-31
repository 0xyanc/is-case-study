package com.instantsystem.casestudy.parkingspot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class ParkingList {
    @JsonbProperty("nhits")
    private int nhits;

    @JsonbProperty("records")
    private List<ParkingSpot> parkingSpots;

    @JsonbCreator
    public ParkingList(
            @JsonProperty("nhits") int nhits,
            @JsonbProperty("records") List<ParkingSpot> parkingSpots) {
        this.nhits = nhits;
        this.parkingSpots = parkingSpots;

    }

    public int getNhits() {
        return nhits;
    }

    public void setNhits(int nhits) {
        this.nhits = nhits;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
