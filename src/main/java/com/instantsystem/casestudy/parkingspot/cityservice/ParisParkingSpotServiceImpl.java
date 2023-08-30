package com.instantsystem.casestudy.parkingspot.cityservice;

import com.instantsystem.casestudy.parkingspot.ParkingSpot;
import com.instantsystem.casestudy.parkingspot.ParkingSpotService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ParkingSpotService implementation in Paris, to show how to add a new city with different public data format.
 */
@Service("paris")
public class ParisParkingSpotServiceImpl implements ParkingSpotService {

    /**
     * Retrieves a mocked list of ParkingSpot in Paris.
     * @return the list of ParkingSpot in Paris.
     */
    public List<ParkingSpot> getParkingSpots() {
        return List.of(
                new ParkingSpot(
                        "VINCI",
                        120,
                        2,
                        2.400794,
                        48.839569
                )
        );
    }
}
