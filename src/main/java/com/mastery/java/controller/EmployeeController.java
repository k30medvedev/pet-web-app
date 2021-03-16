package com.mastery.java.controller;

import com.mastery.java.controller.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@Tag(name = "EmployeeController", description = "Interacting with employees")
@RestController
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());


    private final EmployeeDtoUtil employeeDtoUtil;

    public EmployeeController(
            EmployeeDtoUtil employeeDtoUtil) {
        this.employeeDtoUtil = employeeDtoUtil;

    }

    @Operation(
            summary = "Getting all employees",
            description = "Get/Select operation,it lets you to get list with all employees"
    )
    @GetMapping("/employees")
    EmployeeListDto getAll() {
        return employeeDtoUtil.getEmployeeListDto();
    }

    @Operation(
            summary = "Add new employee",
            description = "Post/Insert operation when you need to add new employee"
    )
    @PostMapping("/employees")
    EmployeeDto createUser(@RequestBody EmployeeCreationDto dto) {
        return employeeDtoUtil.create(dto);
    }

    @Operation(
            summary = "Edit existing an employee",
            description = "Put/Update operation when you need to edit an existing employee"
    )
    @PutMapping("/employees/{id}")
    EmployeeDto updateUserById(@PathVariable Long id, @RequestBody EmployeeUpdateDto dto) {
        return employeeDtoUtil.update(id, dto);
    }


    @Operation(
            summary = "Getting user by id",
            description = "Get/Select operation,it lets you to get list with all employees"
    )
    @GetMapping("/employees/{id}")
    EmployeeDto findUser(@PathVariable Long id) {
        return employeeDtoUtil.findUser(id);
    }

    @Operation(
            summary = "Delete user by id",
            description = "Delete operation,it lets you to delete employee by id"
    )
    @DeleteMapping("/employees/{id}")
    EmployeeDeleteDto deleteUser(@PathVariable("id") Long id) {
        return employeeDtoUtil.delete(id);
    }

    @GetMapping("/swagger")
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }
}
