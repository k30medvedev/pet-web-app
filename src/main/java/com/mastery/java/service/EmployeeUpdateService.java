package com.mastery.java.service;

import com.mastery.java.controller.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUpdateService {
    private final EmployeeSearchService employeeSearchService;
    private final EmployeeValidationService employeeValidationService;
    private final EmployeeRepository employeeRepository;

    public EmployeeUpdateService(
            EmployeeSearchService employeeSearchService,
            EmployeeValidationService employeeValidationService,
            EmployeeRepository employeeRepository) {
        this.employeeSearchService = employeeSearchService;
        this.employeeValidationService = employeeValidationService;
        this.employeeRepository = employeeRepository;
    }

    EmployeeEntity updateUser(EmployeeUpdateReq employeeUpdateReq) throws DepartmentIdMustBePositiveException {
        EmployeeEntity user = employeeSearchService.findById(employeeUpdateReq.getId());
        employeeValidationService.validateUserUpdateReq(user, employeeUpdateReq);
        user.setFirstName(employeeUpdateReq.getFirstName());
        user.setLastName(employeeUpdateReq.getLastName());
        user.setDepartmentId(employeeUpdateReq.getDepartmentId());
        user.setJobTitle(employeeUpdateReq.getJobTitle());
        user.setGender(employeeUpdateReq.getGender());
        user.setBirthday(employeeUpdateReq.getBirthday());
        return employeeRepository.save(user);
    }

}
