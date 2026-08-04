package com.scheduling.shiftschedulingsystem.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ManagerAssignShiftTest {

    LocalDateTime start = LocalDateTime.of(2026, 8, 10, 9, 0);
    LocalDateTime end = LocalDateTime.of(2026, 8, 10, 17, 0);

    @Test
    void assignShift_twoArgOverload_setsNoLocation() {
        Manager manager = new Manager("Priya", "priya@example.com", LocalDate.of(2020, 4, 1), 95000.0);
        PartTimeEmployee worker = new PartTimeEmployee(
                "Jordan", "jordan@example.com", LocalDate.of(2023, 3, 5),
                25, 20.0, 18.0
        );

        Shift shift = manager.assignShift(worker, start, end);

        assertEquals(start, shift.getStartTime());
        assertEquals(end, shift.getEndTime());
        assertNull(shift.getLocation());
        assertEquals(worker, shift.getAssignedEmployee());
    }

    @Test
    void assignShift_threeArgOverload_setsLocation() {
        Manager manager = new Manager("Priya", "priya@example.com", LocalDate.of(2020, 4, 1), 95000.0);
        PartTimeEmployee worker = new PartTimeEmployee(
                "Jordan", "jordan@example.com", LocalDate.of(2023, 3, 5),
                25, 20.0, 18.0
        );

        Shift shift = manager.assignShift(worker, start, end, "Downtown Branch");

        assertEquals(start, shift.getStartTime());
        assertEquals(end, shift.getEndTime());
        assertEquals("Downtown Branch", shift.getLocation());
        assertEquals(worker, shift.getAssignedEmployee());
    }
}