package com.scheduling.shiftschedulingsystem.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private LocalDate hireDate;

    public Employee() {
    }

    public Employee(String name, String email, LocalDate hireDate) {
        this.name = name;
        this.email = email;
        this.hireDate = hireDate;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public abstract double calculatePay();

}
