package com.scheduling.shiftschedulingsystem.shifts.repository;

import com.scheduling.shiftschedulingsystem.shifts.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
