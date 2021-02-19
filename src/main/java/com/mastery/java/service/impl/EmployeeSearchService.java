package com.mastery.java.service.impl;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSearchService  {

    private final EmployeeRepository employeeRepository;

    public EmployeeSearchService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity findById(Long id) {
        return employeeRepository.getOne(id);
    }

}
