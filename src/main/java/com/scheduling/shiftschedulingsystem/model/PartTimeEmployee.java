package com.scheduling.shiftschedulingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "part_time_employees")
public class PartTimeEmployee extends Employee {

    private Integer maxWeeklyHours;
    private Double hourlyRate;
    private Double hoursWorked;

    public PartTimeEmployee() {}

    public PartTimeEmployee(String name, String email, java.time.LocalDate hireDate, Integer maxWeeklyHours, Double hourlyRate, Double hoursWorked) {
        super(name, email, hireDate);
        this.maxWeeklyHours = maxWeeklyHours;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public Integer getMaxWeeklyHours() {
        return maxWeeklyHours;
    }

    public void setMaxWeeklyHours(Integer maxWeeklyHours) {
        this.maxWeeklyHours = maxWeeklyHours;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean exceedsWeeklyCap(int hoursScheduled) {
        return maxWeeklyHours != null && hoursScheduled > maxWeeklyHours;
    }

    @Override
    public double calculatePay() {
        double payableHours = Math.min(hoursWorked, maxWeeklyHours);
        return hourlyRate * payableHours;
    }
}
