package com.scheduling.shiftschedulingsystem.controller;

import com.scheduling.shiftschedulingsystem.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.dto.ShiftResponse;
import com.scheduling.shiftschedulingsystem.service.ShiftService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    private final ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @PostMapping
    public ResponseEntity<ShiftResponse> createShift(@Valid @RequestBody ShiftRequest request) {
        ShiftResponse created = shiftService.createShift(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<ShiftResponse> getAllShifts() {
        return shiftService.getAllShifts();
    }
}
