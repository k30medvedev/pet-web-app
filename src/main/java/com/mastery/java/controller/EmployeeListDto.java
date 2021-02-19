package com.mastery.java.controller;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Schema(description = "List all employees")
public class EmployeeListDto {

    List<EmployeeDto> employees = new ArrayList<>();

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
