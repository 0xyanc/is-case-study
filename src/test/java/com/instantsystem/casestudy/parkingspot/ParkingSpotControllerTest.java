package com.instantsystem.casestudy.parkingspot;

import com.instantsystem.casestudy.parkingspot.cityservice.ParkingSpotService;
import com.instantsystem.casestudy.parkingspot.model.ParkingSpot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.BDDMockito.given;

@WebMvcTest(ParkingSpotController.class)
public class ParkingSpotControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ParkingSpotController parkingSpotController;

    @MockBean
    private ParkingSpotService parkingSpotService;

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

    @Test
    void testGetParkingSpots() throws Exception {

        given(parkingSpotService.getParkingSpots()).willReturn(List.of(new ParkingSpot()));

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/spots")
                        .param("city", "poitiers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
