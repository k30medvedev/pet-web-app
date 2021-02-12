package com.mastery.java.service;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeSearchFindByIdServiceTest {

    private EmployeeRepository employeeRepository;
    private EmployeeSearchService employeeSearchService;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeSearchService = new EmployeeSearchService(employeeRepository);
    }

    @Test
    void shouldFindByIdTest() {
        //GIVEN
        Long id = 101L;
        EmployeeEntity actualEmployeeEntity = mock(EmployeeEntity.class);

        //WHEN
        when(employeeRepository.getOne(id)).thenReturn(actualEmployeeEntity);
        EmployeeEntity expectedEmployeeEntity = employeeSearchService.findById(id);

        //THEN
        verify(employeeRepository, only()).getOne(id);
        assertEquals(expectedEmployeeEntity, actualEmployeeEntity);
    }
}