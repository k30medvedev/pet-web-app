package com.mastery.java.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class EmployeeUpdateDto {

    @Schema(description = "First name, text only", example = "Anna")
    @NotNull
    @Column(name = "first_name")
    String firstName;

    @Schema(description = "Last name, text only", example = "Chiz")
    @NotNull
    @Column(name = "last_name")
    String lastName;

    @Schema(description = "Department number, number only", example = "5")
    @NotNull
    @Column(name = "department_id")
    Integer departmentId;

    @Schema(description = "Describe job title", example = "Sale goods")
    @NotNull
    @Column(name = "job_title")
    String jobTitle;

    @Schema(description = "Choose gender. M for male. F for female", example = "M")
    @NotNull
    @Column(name = "gender")
    String gender;

    @Schema(description = "Choose date_of_birth ", example = "1975-01-01")
    @NotNull
    @Column(name = "date_of_birth")
    LocalDate birthday;

}
