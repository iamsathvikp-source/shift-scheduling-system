package com.scheduling.shiftschedulingsystem.shifts.exception;

public final class ShiftExceptionFactory {

    private static final String PREFIX = "WFS";
    private static final int SHIFT_BASE = 1000;

    private static final int SHIFT_WITH_INVALID_LOCATION = SHIFT_BASE + 1;

    private static final String SHIFT_WITH_INVALID_LOCATION_MESSAGE = "Shift location is invalid : {error_message}";

    private ShiftExceptionFactory() {
    }

    public static ShiftException shiftWithInvalidLocation(String errorMessage) {
        String message = SHIFT_WITH_INVALID_LOCATION_MESSAGE.replace("{error_message}", errorMessage);
        return new ShiftException(PREFIX + "-" + SHIFT_WITH_INVALID_LOCATION + " " + message);
    }

}