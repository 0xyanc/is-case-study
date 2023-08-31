package com.instantsystem.casestudy.parkingspot.cityservice;

import com.instantsystem.casestudy.parkingspot.ParkingSpotController;
import com.instantsystem.casestudy.parkingspot.ParkingSpotService;
import com.instantsystem.casestudy.parkingspot.model.Parking;
import com.instantsystem.casestudy.parkingspot.model.ParkingSpot;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * ParkingSpotService implementation in Poitiers.
 */
@Service("poitiers")
public class PoitiersParkingSpotServiceImpl implements ParkingSpotService {

    private Logger log = LoggerFactory.getLogger(ParkingSpotController.class);
    private PoitiersProperties properties;

    public PoitiersParkingSpotServiceImpl(PoitiersProperties properties) {
        this.properties = properties;
    }
    /**
     * Retrieves the list of ParkingSpot in Poitiers by calling the public endpoint updated in real time.
     * @return the list of ParkingSpot
     */
    public List<ParkingSpot> getParkingSpots() {

        String realTimeParkingUrl = properties.getRealTimeParking();
        log.info("Calling " + realTimeParkingUrl + " for real time parking availabilities.");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =  restTemplate.getForEntity(realTimeParkingUrl, String.class);

        JSONObject obj = new JSONObject(response.getBody());
        JSONArray records = obj.getJSONArray("records");


        Jsonb jsonb = JsonbBuilder.create();
        List<Parking> parking = jsonb.fromJson(records.toString(), new ArrayList<Parking>(){}.getClass().getGenericSuperclass());

        List<ParkingSpot> result = new ArrayList<>();
        parking.forEach(p -> {
                result.add(p.getParkingSpot());
            }
        );

        return result;
    }
}
