package com.scheduling.shiftschedulingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    private static final int PAY_PERIODS_PER_YEAR = 26;

    private Double annualSalary;

    public Manager() {}

    public Manager(String name, String email, LocalDate hireDate, Double annualSalary) {
        super(name, email, hireDate);
        this.annualSalary = annualSalary;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculatePay() {
        return annualSalary / PAY_PERIODS_PER_YEAR;
    }

    public Shift assignShift(Employee assignee, LocalDateTime startTime, LocalDateTime endTime) {
        Shift shift = new Shift(startTime, endTime, null);
        shift.setAssignedEmployee(assignee);
        return shift;
    }

    public Shift assignShift(Employee assignee, LocalDateTime startTime, LocalDateTime endTime, String location) {
        Shift shift = new Shift(startTime, endTime, location);
        shift.setAssignedEmployee(assignee);
        return shift;
    }
}
