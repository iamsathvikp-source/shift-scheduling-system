package com.scheduling.shiftschedulingsystem.shifts.dto;

import com.scheduling.shiftschedulingsystem.shifts.model.Shift;

import java.time.LocalDateTime;

public class ShiftResponse {

    private final Long id;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final String location;

    public ShiftResponse(Long id, LocalDateTime startTime, LocalDateTime endTime, String location) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public static ShiftResponse from(Shift shift) {
        return new ShiftResponse(shift.getId(), shift.getStartTime(), shift.getEndTime(), shift.getLocation());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getLocation() {
        return location;
    }
}
