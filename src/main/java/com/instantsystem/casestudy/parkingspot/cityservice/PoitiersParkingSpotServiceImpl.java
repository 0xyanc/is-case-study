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
//        for (Object rec : records) {
//            System.out.println(rec);
//        }


        Jsonb jsonb = JsonbBuilder.create();
        List<Parking> parking = jsonb.fromJson(records.toString(), new ArrayList<Parking>(){}.getClass().getGenericSuperclass());
//        ParkingList parkingList = jsonb.fromJson(response.getBody(), ParkingList.class);

//        var result = new ArrayList<ParkingSpot>();
//        parkingList.getParkingSpots().forEach(parking -> {
//            result.add(new ParkingSpot(
//                    parking.get
//            ))
//        });
//        return parking;
//        return List.of(new ParkingSpot("name"));
        List<ParkingSpot> result = new ArrayList<>();
        parking.forEach(p -> {
            result.add(p.getParkingSpot());
        });
        return result;
//        return List.of(
////                new ParkingSpot("123"
//                new ParkingSpot(
//                        "PALAIS DE JUSTICE",
//                        70,
//                        36
////                            List.of(BigDecimal.ONE, BigDecimal.TEN)
////                        List.of(46.58595804860371, 0.3512954265806957)
//                )
//        );
    }
}
