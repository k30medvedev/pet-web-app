package com.mastery.java.service.impl;

import com.mastery.java.controller.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import com.mastery.java.service.EmployeeServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    class EmployeeService implements EmployeeServiceImpl {
    private final EmployeeRepository employeeRepository;
    private final EmployeeUpdateService employeeUpdateService;
    private final EmployeeSearchService employeeSearchService;
    private final EmployeeCreateService employeeCreateService;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            EmployeeUpdateService employeeUpdateService,
            EmployeeSearchService employeeSearchService,
            EmployeeCreateService employeeCreateService) {
        this.employeeRepository = employeeRepository;
        this.employeeUpdateService = employeeUpdateService;
        this.employeeSearchService = employeeSearchService;
        this.employeeCreateService = employeeCreateService;
    }

    public List<EmployeeEntity> findAll() {
        return employeeSearchService.findAll();
    }

    public EmployeeEntity findById(Long id) {
        return employeeSearchService.findById(id);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeEntity createUser(EmployeeEntity employeeEntity) {
        return employeeCreateService.createUser(employeeEntity);
    }

    public EmployeeEntity updateUser(EmployeeUpdateReq updateReq) {
        return employeeUpdateService.updateUser(updateReq);
    }
}
