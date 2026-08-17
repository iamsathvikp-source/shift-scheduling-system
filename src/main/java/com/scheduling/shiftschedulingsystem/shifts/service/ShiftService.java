package com.scheduling.shiftschedulingsystem.shifts.service;

import com.scheduling.shiftschedulingsystem.shifts.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.shifts.dto.ShiftResponse;
import com.scheduling.shiftschedulingsystem.shifts.repository.ShiftRepository;
import com.scheduling.shiftschedulingsystem.shifts.task.CreateShiftTask;
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
        CreateShiftTask task = new CreateShiftTask(request, shiftRepository);
        return task.execute();
    }

    public List<ShiftResponse> getAllShifts() {
        return shiftRepository.findAll().stream()
                .map(ShiftResponse::from)
                .collect(Collectors.toList());
    }
}
