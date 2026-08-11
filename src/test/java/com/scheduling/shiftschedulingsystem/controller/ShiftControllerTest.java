package com.scheduling.shiftschedulingsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scheduling.shiftschedulingsystem.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.dto.ShiftResponse;
import com.scheduling.shiftschedulingsystem.service.ShiftService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShiftController.class)
class ShiftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ShiftService shiftService;

    @Test
    void createShift_returnsCreatedShift() throws Exception {
        LocalDateTime start = LocalDateTime.of(2026, 8, 10, 9, 0);
        LocalDateTime end = LocalDateTime.of(2026, 8, 10, 17, 0);
        ShiftRequest request = new ShiftRequest(start, end, "Downtown Store");
        ShiftResponse response = new ShiftResponse(1L, start, end, "Downtown Store");

        when(shiftService.createShift(any(ShiftRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/shifts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.location").value("Downtown Store"));
    }

    @Test
    void createShift_rejectsBlankLocation() throws Exception {
        LocalDateTime start = LocalDateTime.of(2026, 8, 10, 9, 0);
        LocalDateTime end = LocalDateTime.of(2026, 8, 10, 17, 0);
        ShiftRequest request = new ShiftRequest(start, end, "");

        mockMvc.perform(post("/api/shifts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllShifts_returnsList() throws Exception {
        LocalDateTime start = LocalDateTime.of(2026, 8, 10, 9, 0);
        LocalDateTime end = LocalDateTime.of(2026, 8, 10, 17, 0);
        ShiftResponse response = new ShiftResponse(1L, start, end, "Downtown Store");

        when(shiftService.getAllShifts()).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/api/shifts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1));
    }
}
