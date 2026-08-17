package com.scheduling.shiftschedulingsystem.employees.service;

import com.scheduling.shiftschedulingsystem.employees.dto.EmployeeResponse;
import com.scheduling.shiftschedulingsystem.employees.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> fetchAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeResponse::from)
                .collect(Collectors.toList());
    }
}
