package com.mastery.java.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sun.istack.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class EmployeeCreationDto implements Serializable {

    @Schema(description = "First name, text only", example = "Anna")
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Schema(description = "Last name, text only", example = "Chiz")
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Schema(description = "Department number, number only", example = "5")
    @NotNull
    @Column(name = "department_id")
    private Integer departmentId;

    @NotNull
    @Column(name = "job_title")
    private String jobTitle;

    @NotNull
    @Column(name = "gender")
    private String gender;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate birthday;

}
