package com.mastery.java.controller.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.Column;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Schema(description = "Employee Creation Dto")
public class EmployeeCreationDto implements Serializable {


    @Schema(description = "First name, text only", example = "Anna")
    @NotNull
    @Size(min = 2, max = 30, message = "min 2 characters max 30 ")
    @Column(name = "first_name")
    private String firstName;

    @Schema(description = "Last name, text only", example = "Chiz")
    @NotNull
    @Size(min = 2, max = 30, message = "min 2 characters max 30 ")
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
    @PastOrPresent
    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate birthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
