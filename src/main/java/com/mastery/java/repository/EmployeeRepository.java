package com.mastery.java.repository;

import com.mastery.java.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    boolean existsByFirstNameAndLastNameAndBirthdayAllIgnoreCase
            (String firstName, String lastName, LocalDate birthday);
}
