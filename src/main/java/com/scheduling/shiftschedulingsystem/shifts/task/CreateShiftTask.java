package com.scheduling.shiftschedulingsystem.shifts.task;

import com.scheduling.shiftschedulingsystem.shifts.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.shifts.dto.ShiftResponse;
import com.scheduling.shiftschedulingsystem.shifts.model.Shift;
import com.scheduling.shiftschedulingsystem.shifts.repository.ShiftRepository;

/**
 * Encapsulates everything involved in creating a shift: building the entity
 * from the incoming request, running any validation, and persisting it.
 * ShiftService just constructs one of these and calls execute().
 */


public class CreateShiftTask {
    private final ShiftRequest request;
    private final ShiftRepository shiftRepository;

    public CreateShiftTask(ShiftRequest request, ShiftRepository shiftRepository) {
        this.request = request;
        this.shiftRepository = shiftRepository;
    }

    public ShiftResponse execute() {
        CreateShiftTaskHandler.validate(request, shiftRepository);
        Shift shift = new Shift(request.getStartTime(), request.getEndTime(), request.getLocation());
        Shift saved = shiftRepository.save(shift);
        return ShiftResponse.from(saved);
    }
}
