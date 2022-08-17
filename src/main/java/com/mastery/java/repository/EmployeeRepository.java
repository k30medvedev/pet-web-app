package com.mastery.java.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastery.java.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByFirstNameAndLastNameAndBirthdayAllIgnoreCase(String firstName, String lastName, LocalDate birthday);
}
