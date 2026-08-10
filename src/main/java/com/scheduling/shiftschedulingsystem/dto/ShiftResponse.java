package com.scheduling.shiftschedulingsystem.dto;

import com.scheduling.shiftschedulingsystem.model.Shift;

import java.time.LocalDateTime;

public record ShiftResponse(
        Long id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String location
) {
    public static ShiftResponse from(Shift shift) {
        return new ShiftResponse(shift.getId(), shift.getStartTime(), shift.getEndTime(), shift.getLocation());
    }
}
