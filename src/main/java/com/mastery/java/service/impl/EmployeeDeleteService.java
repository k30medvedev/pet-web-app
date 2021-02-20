package com.mastery.java.service.impl;

import com.mastery.java.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDeleteService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDeleteService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}


