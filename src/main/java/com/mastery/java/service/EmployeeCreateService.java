package com.mastery.java.service;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
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

    public EmployeeEntity createUser(EmployeeEntity employeeEntity) throws DepartmentIdMustBePositiveException, InvalidDigitalException {
        employeeValidationService.validateUser(employeeEntity);
        return employeeRepository.save(employeeEntity);
    }

}
