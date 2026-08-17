package com.scheduling.shiftschedulingsystem.employees.repository;

import com.scheduling.shiftschedulingsystem.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
