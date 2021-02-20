package com.mastery.java.service.impl;

import com.mastery.java.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
class EmployeeServiceDeleteByIdTest {

    private EmployeeRepository employeeRepository;
    private EmployeeDeleteService employeeDeleteService;
    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeDeleteService = new EmployeeDeleteService(
                employeeRepository);

    }

    @Test
    void shouldDeleteById() {
        //GIVEN
        Long id = 1L;
        doNothing().when(employeeRepository).deleteById(id);

        //WHEN
        employeeDeleteService.deleteById(id);

        //THEN
        verify(employeeRepository, only()).deleteById(id);

    }
}