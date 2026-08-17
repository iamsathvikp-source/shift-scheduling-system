package com.scheduling.shiftschedulingsystem.shifts.task;

import com.scheduling.shiftschedulingsystem.shifts.dto.ShiftRequest;
import com.scheduling.shiftschedulingsystem.shifts.exception.ShiftExceptionFactory;
import com.scheduling.shiftschedulingsystem.shifts.repository.ShiftRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

/**
 * Validates a ShiftRequest before it's turned into a Shift and saved:
 * basic field sanity checks, a max-duration cap, and overlap detection
 * against existing shifts at the same location.
 */
public class CreateShiftTaskHandler {

    private static final long MAX_SHIFT_DURATION_HOURS = 16;
    private static final Pattern LOCATION_PATTERN = Pattern.compile("^[A-Z]{2,4}$");

    private CreateShiftTaskHandler() {
    }

    public static void validate(ShiftRequest request, ShiftRepository shiftRepository) {
        LocalDateTime start = request.getStartTime();
        LocalDateTime end = request.getEndTime();
        String location = request.getLocation();

        if (!LOCATION_PATTERN.matcher(location).matches()) {
            throw ShiftExceptionFactory.shiftWithInvalidLocation(location);
        }

        long durationHours = Duration.between(start, end).toHours();
        if (durationHours > MAX_SHIFT_DURATION_HOURS) {
            throw new IllegalArgumentException(
                    "Shift duration cannot exceed " + MAX_SHIFT_DURATION_HOURS + " hours");
        }
    }
}