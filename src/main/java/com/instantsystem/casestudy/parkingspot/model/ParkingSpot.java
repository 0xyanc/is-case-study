package com.instantsystem.casestudy.parkingspot.model;

import javax.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.util.List;

public class ParkingSpot {
    @JsonbProperty("nom")
    private String name;
    @JsonbProperty("capacite")
    private int capacity;
    @JsonbProperty("places")
    private int available;
    @JsonbProperty("geo_point_2d")
    private List<BigDecimal> coordinates;

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

    public List<BigDecimal> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<BigDecimal> coordinates) {
        this.coordinates = coordinates;
    }
}
