package com.mastery.java.rest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.mastery.java.dto.EmployeeCreationDto;
import com.mastery.java.dto.EmployeeDto;
import com.mastery.java.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Operation(summary = "Getting user by id", description = "Get/Select operation,it lets you to get list with all employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/employees/{id}")
    EmployeeDto findUser(@PathVariable Long id) {
        return service.findById(id);
    }

    // @Operation(summary = "Getting all employees", description = "Get/Select operation,it lets you to
    // get list with all employees")
    // @ResponseStatus(HttpStatus.OK)
    // @GetMapping("/employees")
    // List<EmployeeResponse> findAllEmployee() {
    // return service.findAll();
    // }

    @Operation(summary = "Add new employee", description = "Post/Insert operation when you need to add new employee")
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeDto createUser(@RequestBody EmployeeCreationDto dto) {
        return service.createUser(dto);
    }

    // @Operation(summary = "Edit existing an employee", description = "Put/Update operation when you
    // need to edit an existing employee")
    // @PutMapping("/employees/{id}")
    // EmployeeDto updateUserById(@PathVariable Long id, @RequestBody EmployeeUpdateDto dto) {
    // return service.update(id, dto);
    // }

    @Operation(summary = "Delete user by id", description = "Delete operation,it lets you to delete employee by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/employees/{id}")
    void deleteUser(@Valid @Min(1) @PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
