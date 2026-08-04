package com.scheduling.shiftschedulingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "full_time_employees")
public class FullTimeEmployee extends Employee {

    private static final int PAY_PERIODS_PER_YEAR = 26;
    private static final double STANDARD_HOURS = 80.0;
    private Double annualSalary;
    private Double hoursWorked;
    private Boolean overtimeEligible;

    public FullTimeEmployee() {}

    public FullTimeEmployee(String name, String email, java.time.LocalDate hireDate, Double annualSalary, Double hoursWorked, Boolean overtimeEligible) {
        super(name, email, hireDate);
        this.annualSalary = annualSalary;
        this.hoursWorked = hoursWorked;
        this.overtimeEligible = overtimeEligible;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Boolean getOvertimeEligible() {
        return overtimeEligible;
    }

    public void setOvertimeEligible(Boolean overtimeEligible) {
        this.overtimeEligible = overtimeEligible;
    }

    @Override
    public double calculatePay() {
        double basePay = annualSalary / PAY_PERIODS_PER_YEAR;

        if (Boolean.TRUE.equals(overtimeEligible) && hoursWorked > STANDARD_HOURS) {
            double overtimeHours = hoursWorked - STANDARD_HOURS;
            double hourlyEquivalent = annualSalary / (52 * 40);
            double overtimePay = overtimeHours * hourlyEquivalent * 1.5;
            return basePay + overtimePay;
        }

        return basePay;
    }
}
