package com.mastery.java.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class EmployeeDto implements Serializable {

    Long id;

    String firstName;

    String lastName;

    Integer departmentId;

    String jobTitle;

    String gender;

    LocalDate birthday;
}
