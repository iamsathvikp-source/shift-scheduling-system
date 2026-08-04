package com.scheduling.shiftschedulingsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "contract_employees")
public class ContractEmployee extends Employee {

    private LocalDate contractEndDate;
    private Double perShiftRate;
    private Integer shiftsWorked;

    public ContractEmployee() {}

    public ContractEmployee(String name, String email, LocalDate hireDate, LocalDate contractEndDate, Double perShiftRate, Integer shiftsWorked) {
        super(name, email, hireDate);
        this.contractEndDate = contractEndDate;
        this.perShiftRate = perShiftRate;
        this.shiftsWorked = shiftsWorked;
    }

    public LocalDate getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getPerShiftRate() {
        return perShiftRate;
    }

    public void setPerShiftRate(Double perShiftRate) {
        this.perShiftRate = perShiftRate;
    }

    public Integer getShiftsWorked() {
        return shiftsWorked;
    }

    public void setShiftsWorked(Integer shiftsWorked) {
        this.shiftsWorked = shiftsWorked;
    }

    public boolean isContractExpired(LocalDate today) {
        return contractEndDate != null && today.isAfter(contractEndDate);
    }

    @Override
    public double calculatePay() {
        return perShiftRate * shiftsWorked;
    }
}
