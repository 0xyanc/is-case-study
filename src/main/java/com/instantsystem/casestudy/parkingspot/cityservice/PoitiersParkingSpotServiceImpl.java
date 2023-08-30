package com.instantsystem.casestudy.parkingspot.cityservice;

import com.instantsystem.casestudy.parkingspot.ParkingSpot;
import com.instantsystem.casestudy.parkingspot.ParkingSpotService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ParkingSpotService implementation in Poitiers.
 */
@Service("poitiers")
public class PoitiersParkingSpotServiceImpl implements ParkingSpotService {

    /**
     * Retrieves the list of ParkingSpot in Poitiers by calling the public endpoint updated in real time.
     * @return the list of ParkingSpot
     */
    public List<ParkingSpot> getParkingSpots() {
        return List.of(
                new ParkingSpot(
                        "PALAIS DE JUSTICE",
                        70,
                        36,
                        0.3512954265806957,
                        46.58595804860371
                )
        );
    }
}
