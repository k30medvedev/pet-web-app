package com.mastery.java.dto;

import java.time.LocalDate;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class EmployeeUpdateReq {
    Long id;

    @NotNull
    String firstName;

    @NotNull
    String lastName;

    @NotNull
    Integer departmentId;

    @NotNull
    String jobTitle;

    @NotNull
    String gender;

    @NotNull
    LocalDate birthday;
}
