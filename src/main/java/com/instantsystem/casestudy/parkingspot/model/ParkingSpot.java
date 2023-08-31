package com.instantsystem.casestudy.parkingspot.model;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class ParkingSpot {
    @JsonbProperty("nom")
    private String name;
    @JsonbProperty("capacite")
    private int capacity;
    @JsonbProperty("places")
    private int available;
    private double longitude;
    private double latitude;

    @JsonbCreator
    public ParkingSpot(
            @JsonbProperty("nom") String name,
            @JsonbProperty("capacite") int capacity,
            @JsonbProperty("places") int available/*,
            @JsonbProperty(value = "geo_point_2d", nillable = true) List<BigDecimal> coordinates*/) {
        this.name = name;
        this.capacity = capacity;
        this.available = available;
//        if (coordinates != null) {
//            this.latitude = coordinates.get(0).doubleValue();
//            this.longitude = coordinates.get(1).doubleValue();
//        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
