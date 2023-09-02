package com.instantsystem.casestudy.parkingspot.cityservice;

import com.instantsystem.casestudy.parkingspot.ParkingSpotController;
import com.instantsystem.casestudy.parkingspot.model.Parking;
import com.instantsystem.casestudy.parkingspot.model.ParkingSpot;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    /**
     * PoitiersParkingSpotServiceImpl constructor.
     * @param properties
     */
    public PoitiersParkingSpotServiceImpl(PoitiersProperties properties) {
        this.properties = properties;
    }
    @Override
    /**
     * Retrieves the list of ParkingSpot in Poitiers by calling the public endpoint updated in real time.
     * @return the list of ParkingSpot
     */
    public List<ParkingSpot> getParkingSpots() {

        String response = callParkingApi();

        List<Parking> parkings = parseResponse(response);

        List<ParkingSpot> result = new ArrayList<>();
        parkings.forEach(p -> {
                result.add(p.getParkingSpot());
            }
        );

        return result;
    }

    /**
     * Calls the real time parking spot endpoint.
     * @return the response body of the real time API
     */
    private String callParkingApi() {
        String realTimeParkingUrl = properties.getRealTimeParking();
        log.info("Calling " + realTimeParkingUrl + " for real time parking availabilities.");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(realTimeParkingUrl, String.class).getBody();
    }

    /**
     * Parse the response into a list of Parking
     * @param response
     * @return a list of Parking containing the number of available parking spots
     */
    private List<Parking> parseResponse(String response) {
        JSONObject obj = new JSONObject(response);
        JSONArray records = obj.getJSONArray("records");

        Jsonb jsonb = JsonbBuilder.create();
        return jsonb.fromJson(records.toString(), new ArrayList<Parking>(){}.getClass().getGenericSuperclass());
    }
}
