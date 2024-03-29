package com.mastery.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mastery.java.dto.EmployeeCreationDto;
import com.mastery.java.dto.EmployeeDto;
import com.mastery.java.dto.EmployeeUpdateReq;
import com.mastery.java.mapper.EmployeeMapper;
import com.mastery.java.model.Employee;
import com.mastery.java.repository.EmployeeRepository;
import com.mastery.java.validation.EmployeeValidationServiceImpl;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeValidationServiceImpl employeeValidationServiceImpl;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
            EmployeeValidationServiceImpl employeeValidationServiceImpl, EmployeeMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.employeeValidationServiceImpl = employeeValidationServiceImpl;
        this.mapper = mapper;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeDto findById(Long id) {
        return mapper.map(employeeRepository.getOne(id));
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto createUser(final EmployeeCreationDto dto) {
        final Employee employee = mapper.map(dto);
        employeeValidationServiceImpl.validateUser(employee);
        return mapper.map(employeeRepository.save(employee));
    }

    @Override
    public Employee updateUser(final EmployeeUpdateReq updateReq) {
        // todo
        return new Employee();
    }
}
