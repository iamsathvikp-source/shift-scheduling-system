package com.scheduling.shiftschedulingsystem.service;

import com.scheduling.shiftschedulingsystem.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.dto.ShiftResponse;
import com.scheduling.shiftschedulingsystem.model.Shift;
import com.scheduling.shiftschedulingsystem.repository.ShiftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;

    public ShiftService(ShiftRepository shiftRepository) {
        this.shiftRepository = shiftRepository;
    }

    public ShiftResponse createShift(ShiftRequest request) {
        Shift shift = new Shift(request.startTime(), request.endTime(), request.location());
        Shift saved = shiftRepository.save(shift);
        return ShiftResponse.from(saved);
    }

    public List<ShiftResponse> getAllShifts() {
        return shiftRepository.findAll().stream()
                .map(ShiftResponse::from)
                .toList();
    }
}
