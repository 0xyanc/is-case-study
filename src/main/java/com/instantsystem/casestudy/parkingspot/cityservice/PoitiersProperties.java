package com.instantsystem.casestudy.parkingspot.cityservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Retrieve configuration from application.yml for poitiers.
 */
@Configuration
@ConfigurationProperties(prefix = "poitiers")
public class PoitiersProperties {
    private String parkingList;
    private String realTimeParking;

    public String getParkingList() {
        return parkingList;
    }

    public void setParkingList(String parkingList) {
        this.parkingList = parkingList;
    }

    public String getRealTimeParking() {
        return realTimeParking;
    }

    public void setRealTimeParking(String realTimeParking) {
        this.realTimeParking = realTimeParking;
    }

}
