package com.mastery.java.service;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeSearchFindAllServiceTest {

    private EmployeeRepository employeeRepository;
    private EmployeeSearchService employeeSearchService;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeSearchService = new EmployeeSearchService(employeeRepository);
    }

    @Test
    void shouldFindAllTest() {
        //GIVEN
        List<EmployeeEntity> listExpected = mock(List.class);

        //WHEN
        when(employeeRepository.findAll()).thenReturn(listExpected);
        List<EmployeeEntity> listActual = employeeSearchService.findAll();

        //THEN
        verify(employeeRepository, only()).findAll();
        assertEquals(listExpected,listActual);

        verifyNoMoreInteractions(listExpected);

    }
}