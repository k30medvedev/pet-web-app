package com.mastery.java.controller;

import com.mastery.java.jms.producer.JmsProducer;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.service.DepartmentIdMustBePositiveException;
import com.mastery.java.service.EmployeeService;
import com.mastery.java.service.InvalidDigitalException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;

@Tag(name = "EmployeeController", description = "Interacting with employees")
@RestController
class EmployeeController {

    private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

    private final EmployeeDtoConverter employeeDtoConverter;
    private final EmployeeService employeeService;
    private final JmsProducer jmsProducer;

    public EmployeeController(
            EmployeeDtoConverter employeeDtoConverter,
            EmployeeService employeeService,
            JmsProducer jmsProducer) {
        this.employeeDtoConverter = employeeDtoConverter;
        this.employeeService = employeeService;
        this.jmsProducer = jmsProducer;
    }

    @Operation(
            summary = "Getting all employees",
            description = "Get/Select operation,it lets you to get list with all employees"
    )
    @GetMapping("/employees")
    EmployeeListDto getAll() {
        logger.info("List with all employees are requested");
        return employeeDtoConverter.getEmployeeListDto();
    }

    @Operation(
            summary = "Add new employee",
            description = "Post/Insert operation when you need to add new employee"
    )
    @PostMapping("/employees")
    EmployeeDto createUser(@RequestBody EmployeeCreationDto dto) throws DepartmentIdMustBePositiveException, InvalidDigitalException {
        EmployeeEntity employeeEntity = employeeDtoConverter.convertDtoToEmployee(dto);
        employeeEntity = employeeService.createUser(employeeEntity);
        jmsProducer.send(employeeEntity);
        logger.info("New employee is creating");
        return employeeDtoConverter.convertEmployeeToDto(employeeEntity);

    }

    @Operation(
            summary = "Edit existing an employee",
            description = "Put/Update operation when you need to edit an existing employee"
    )
    @PutMapping("/employees/{id}")
    EmployeeDto updateUserById(@PathVariable Long id, @RequestBody EmployeeUpdateDto dto)
            throws DepartmentIdMustBePositiveException {
        EmployeeUpdateReq req = employeeDtoConverter.convertDtoToEmployee(id, dto);
        EmployeeEntity employeeEntity = employeeService.updateUser(req);
        jmsProducer.send(employeeEntity);
        logger.info("The employee is updating");
        return employeeDtoConverter.convertEmployeeToDto(employeeEntity);
    }


    @Operation(
            summary = "Getting user by id",
            description = "Get/Select operation,it lets you to get list with all employees"
    )
    @GetMapping("/employees/{id}")
    @ResponseBody
    EmployeeDto findUser(@PathVariable Long id) {
        EmployeeEntity employee = employeeService.findById(id);
        EmployeeDto dto = new EmployeeDto();
        employeeDtoConverter.convertDtoToEmployee(employee, dto);
        logger.info("The employee is requested,id: " + employee.getId());
        return dto;
    }

    @Operation(
            summary = "Delete user by id",
            description = "Delete operation,it lets you to delete employee by id"
    )
    @DeleteMapping("/employees/{id}")
    EmployeeDeleteDto deleteUser(@PathVariable("id") Long id) {
        EmployeeDeleteDto dto = new EmployeeDeleteDto();
        employeeService.deleteById(id);
        EmployeeEntity employeeEntity = employeeService.findById(id);
        jmsProducer.send(employeeEntity);
        dto.setId(employeeEntity.getId());
        logger.info("The employee is requested to delete,id: " + id);
        return dto;
    }
}
