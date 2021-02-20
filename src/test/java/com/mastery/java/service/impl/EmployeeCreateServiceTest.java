package com.mastery.java.service.impl;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import com.mastery.java.service.DepartmentIdMustBePositiveException;
import com.mastery.java.service.EmployeeValidationService;
import com.mastery.java.service.InvalidDigitalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class EmployeeCreateServiceTest {

    private EmployeeRepository employeeRepository;
    private EmployeeValidationService employeeValidationService;
    private EmployeeCreateService employeeCreateService;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeValidationService = mock(EmployeeValidationService.class);
        employeeCreateService = new EmployeeCreateService(employeeRepository, employeeValidationService);
    }

    @Test
    void shouldCreateUserTest() throws DepartmentIdMustBePositiveException, InvalidDigitalException {
        //GIVEN
        EmployeeEntity employeeEntity = mock(EmployeeEntity.class);
        LocalDate birthday = LocalDate.of(1988, 3, 15);
        employeeEntity.setFirstName("Kirill");
        employeeEntity.setLastName("Medvedev");
        employeeEntity.setDepartmentId(1);
        employeeEntity.setJobTitle("Works with DB");
        employeeEntity.setGender("M");
        employeeEntity.setBirthday(birthday);

        //WHEN
        when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);

        //THEN
        assertEquals(employeeCreateService.createUser(employeeEntity), employeeEntity);
        assertNotNull(employeeEntity);
        verify(employeeRepository, times(1)).save(employeeEntity);
        verifyNoMoreInteractions(employeeRepository);

    }

    @Test
    void shouldCheckThatDepartmentIdMustBePositiveExceptionTest() {

        //GIVEN
        EmployeeEntity employeeEntity = mock(EmployeeEntity.class);
        doThrow(DepartmentIdMustBePositiveException.class)
                .when(employeeValidationService).validateUser(employeeEntity);

        //WHEN
        Assertions.assertThrows(
                DepartmentIdMustBePositiveException.class,
                () -> employeeCreateService.createUser(employeeEntity));

        //THEN
        verifyNoInteractions(employeeEntity, employeeRepository);
        verify(employeeValidationService).validateUser(employeeEntity);
        verifyNoMoreInteractions(employeeValidationService);

    }

    @Test
    void shouldCheckExceptionNameMustBeOnlyLiteralsTest() {

        //GIVEN
        EmployeeEntity employeeEntity = mock(EmployeeEntity.class);
        doThrow(InvalidDigitalException.class)
                .when(employeeValidationService).validateUser(employeeEntity);

        //WHEN
        Assertions.assertThrows(
                InvalidDigitalException.class,
                () -> employeeCreateService.createUser(employeeEntity));

        //THEN
        verifyNoInteractions(employeeEntity, employeeRepository);
        verify(employeeValidationService).validateUser(employeeEntity);
        verifyNoMoreInteractions(employeeValidationService);

    }

}