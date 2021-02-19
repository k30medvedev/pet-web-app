package com.mastery.java.service.impl;

import com.mastery.java.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
class EmployeeServiceDeleteByIdTest {

    private EmployeeRepository employeeRepository;
    private EmployeeUpdateService employeeUpdateService;
    private EmployeeSearchService employeeSearchService;
    private EmployeeCreateService employeeCreateService;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeUpdateService = mock(EmployeeUpdateService.class);
        employeeSearchService = mock(EmployeeSearchService.class);
        employeeCreateService = mock(EmployeeCreateService.class);

        employeeService = new EmployeeService(
                employeeRepository,
                employeeUpdateService,
                employeeSearchService,
                employeeCreateService);

    }

    @Test
    void shouldDeleteById() {
        //GIVEN
        Long id = 101L;
        doNothing().when(employeeRepository).deleteById(id);

        //WHEN
        employeeService.deleteById(id);

        //THEN
        verify(employeeRepository, only()).deleteById(id);

    }
}