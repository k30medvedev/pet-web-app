package com.mastery.java.controller;

import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Component
@Schema(description = "User entity")
public class EmployeeDto implements Serializable {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @Column(name = "employee_id")
    private Long id;


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

    @Min(0)
    @Schema(description = "Department number, number only", example = "5")
    @NotNull
    @Column(name = "department_id")
    private Integer departmentId;

    @Schema(description = "Describe job title", example = "Sale goods")
    @NotNull
    @Column(name = "job_title")
    private String jobTitle;

    @Schema(description = "Choose gender. M for male. F for female", example = "M")
    @NotNull
    @Column(name = "gender")
    private String gender;

    @Schema(description = "Choose date_of_birth ", example = "1975-01-01")
    @PastOrPresent
    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate birthday;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
