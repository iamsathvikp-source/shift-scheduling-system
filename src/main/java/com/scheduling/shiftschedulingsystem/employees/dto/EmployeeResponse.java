package com.scheduling.shiftschedulingsystem.employees.dto;

import com.scheduling.shiftschedulingsystem.employees.model.Employee;

public class EmployeeResponse {
    private final Long id;
    private final String name;
    private final int age;

    public EmployeeResponse(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static EmployeeResponse from(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getName(), employee.getAge());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
