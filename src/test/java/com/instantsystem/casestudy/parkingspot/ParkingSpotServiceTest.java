package com.instantsystem.casestudy.parkingspot;

import com.instantsystem.casestudy.parkingspot.cityservice.PoitiersParkingSpotServiceImpl;
import com.instantsystem.casestudy.parkingspot.cityservice.PoitiersProperties;
import com.instantsystem.casestudy.parkingspot.model.ParkingSpot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = PoitiersProperties.class)
@TestPropertySource(properties = {"poitiers.realtimeparking=https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilites-stationnement-des-parkings-en-temps-reel&facet=nom"}) // Define your test properties here
public class ParkingSpotServiceTest {
    private PoitiersParkingSpotServiceImpl parkingSpotService;

    @Autowired
    private PoitiersProperties poitiersProperties;

    @BeforeEach
    public void setup() {
        parkingSpotService = new PoitiersParkingSpotServiceImpl(poitiersProperties);
    }
    @Test
    void testGetParkingSpots() {
        List<ParkingSpot> result = parkingSpotService.getParkingSpots();
        assert(result.size() > 0);
    }
}
