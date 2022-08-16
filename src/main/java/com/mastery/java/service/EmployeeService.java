package com.mastery.java.service;

import java.util.List;

import com.mastery.java.dto.EmployeeCreationDto;
import com.mastery.java.dto.EmployeeDto;
import com.mastery.java.dto.EmployeeUpdateReq;
import com.mastery.java.model.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    EmployeeDto findById(final Long id);

    void deleteById(final Long id);

    EmployeeDto createUser(final EmployeeCreationDto dto);

    Employee updateUser(final EmployeeUpdateReq updateReq);

}
