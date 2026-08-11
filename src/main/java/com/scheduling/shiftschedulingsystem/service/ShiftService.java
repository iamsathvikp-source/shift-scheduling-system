package com.scheduling.shiftschedulingsystem.service;

import com.scheduling.shiftschedulingsystem.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.dto.ShiftResponse;
import com.scheduling.shiftschedulingsystem.model.Shift;
import com.scheduling.shiftschedulingsystem.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public ShiftResponse createShift(ShiftRequest request) {
        Shift shift = new Shift(request.getStartTime(), request.getEndTime(), request.getLocation());
        Shift saved = shiftRepository.save(shift);
        return ShiftResponse.from(saved);
    }

    public List<ShiftResponse> getAllShifts() {
        return shiftRepository.findAll().stream()
                .map(ShiftResponse::from)
                .collect(Collectors.toList());
    }
}
