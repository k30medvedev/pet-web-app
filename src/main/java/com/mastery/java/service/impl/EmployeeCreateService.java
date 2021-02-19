package com.mastery.java.service.impl;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import com.mastery.java.service.EmployeeValidationService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCreateService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeValidationService employeeValidationService;


    public EmployeeCreateService(
            EmployeeRepository employeeRepository,
            EmployeeValidationService employeeValidationService) {
        this.employeeRepository = employeeRepository;
        this.employeeValidationService = employeeValidationService;
    }

    public EmployeeEntity createUser(EmployeeEntity employeeEntity) {
        employeeValidationService.validateUser(employeeEntity);
        return employeeRepository.save(employeeEntity);
    }

}
