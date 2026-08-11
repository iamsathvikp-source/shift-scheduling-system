package com.scheduling.shiftschedulingsystem.repository;

import com.scheduling.shiftschedulingsystem.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
