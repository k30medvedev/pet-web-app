package com.mastery.java.service;

import com.mastery.java.controller.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeUpdateServiceTest {

    private EmployeeSearchService employeeSearchService;
    private EmployeeValidationService employeeValidationService;
    private EmployeeRepository employeeRepository;
    private EmployeeUpdateService employeeUpdateService;

    @BeforeEach
    void setUp() {
        employeeSearchService = mock(EmployeeSearchService.class);
        employeeValidationService = mock(EmployeeValidationService.class);
        employeeRepository = mock(EmployeeRepository.class);
        employeeUpdateService = new EmployeeUpdateService(
                employeeSearchService,
                employeeValidationService,
                employeeRepository);
    }

    @Test
    void shouldUpdateUserTest() throws DepartmentIdMustBePositiveException {
        //GIVEN
        LocalDate birthday = LocalDate.of(1988, 3, 15);
        EmployeeUpdateReq employeeUpdateReq = mock(EmployeeUpdateReq.class);
        EmployeeEntity expectedSearchResult = mock(EmployeeEntity.class);
        EmployeeEntity expectedUpdateResult = mock(EmployeeEntity.class);

        Long id = 227L;
        //WHEN
        when(employeeUpdateReq.getId()).thenReturn(id);
        when(employeeUpdateReq.getFirstName()).thenReturn("Kirill");
        when(employeeUpdateReq.getLastName()).thenReturn("Medvedev");
        when(employeeUpdateReq.getDepartmentId()).thenReturn(1);
        when(employeeUpdateReq.getJobTitle()).thenReturn("Job title");
        when(employeeUpdateReq.getGender()).thenReturn("M");
        when(employeeUpdateReq.getBirthday()).thenReturn(birthday);

        when(employeeSearchService.findById(id)).thenReturn(expectedSearchResult);

        when(employeeRepository.save(expectedSearchResult)).thenReturn(expectedUpdateResult);

        EmployeeEntity actualResult = employeeUpdateService.updateUser(employeeUpdateReq);

        //THEN
        assertEquals(expectedUpdateResult, actualResult);
        verify(employeeUpdateReq, times(1)).getId();
        verify(employeeUpdateReq, times(1)).getFirstName();
        verify(employeeUpdateReq, times(1)).getLastName();
        verify(employeeUpdateReq, times(1)).getDepartmentId();
        verify(employeeUpdateReq, times(1)).getJobTitle();
        verify(employeeUpdateReq, times(1)).getGender();
        verify(employeeUpdateReq, times(1)).getBirthday();
        verifyNoMoreInteractions(employeeUpdateReq);

        verify(employeeValidationService, only()).validateUserUpdateReq(expectedSearchResult, employeeUpdateReq);

        verify(employeeSearchService, only()).findById(id);

        verify(employeeRepository, only()).save(expectedSearchResult);

        verifyNoInteractions(expectedUpdateResult);

        verify(expectedSearchResult, times(1)).setFirstName("Kirill");
        verify(expectedSearchResult, times(1)).setLastName("Medvedev");
        verify(expectedSearchResult, times(1)).setDepartmentId(1);
        verify(expectedSearchResult, times(1)).setJobTitle("Job title");
        verify(expectedSearchResult, times(1)).setGender("M");
        verify(expectedSearchResult, times(1)).setBirthday(LocalDate.of(1988, 3, 15));
        verifyNoMoreInteractions(expectedSearchResult);

    }
}