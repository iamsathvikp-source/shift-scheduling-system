package com.scheduling.shiftschedulingsystem.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeePayCalculationTest {

    @Test
    void calculatePay_returnsCorrectAmountForEachEmployeeType() {
        FullTimeEmployee fullTime = new FullTimeEmployee(
                "Alex", "alex@example.com", LocalDate.of(2022, 1, 10),
                78000.0, 80.0, true
        );

        PartTimeEmployee partTime = new PartTimeEmployee(
                "Jordan", "jordan@example.com", LocalDate.of(2023, 3, 5),
                25, 20.0, 18.0
        );

        ContractEmployee contractor = new ContractEmployee(
                "Sam", "sam@example.com", LocalDate.of(2024, 6, 1),
                LocalDate.of(2026, 12, 31), 150.0, 4
        );

        List<Employee> employees = List.of(fullTime, partTime, contractor);

        for (Employee e: employees) {
            System.out.println(e.getName() + " : " + e.calculatePay());
        }

        assertEquals(3000.0, fullTime.calculatePay(), 0.01);
        assertEquals(360.0, partTime.calculatePay(), 0.01);
        assertEquals(600.0, contractor.calculatePay(), 0.01);
    }
}
