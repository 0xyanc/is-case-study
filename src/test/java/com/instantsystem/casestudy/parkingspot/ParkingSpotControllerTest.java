package com.instantsystem.casestudy.parkingspot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@SpringBootTest
//@ExtendWith(SpringExtension.class)
@WebMvcTest(ParkingSpotController.class)
public class ParkingSpotControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ParkingSpotController parkingSpotController;
    @Test
    void testGetParkingSpots400() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/spots")
                .param("city", "qwerty123!#")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    void testGetParkingSpots404() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/v1/spots")
                        .param("city", "qwerty")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

//    @Test
//    void testGetParkingSpots() throws Exception {
//        Mock
//
//        mvc.perform(MockMvcRequestBuilders.get("/api/v1/spots")
//                        .param("city", "poitiers")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isNotFound());
//    }

}
