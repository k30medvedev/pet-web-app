package com.mastery.java.service;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
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
    void departmentIdMustBePositiveExceptionTest() throws DepartmentIdMustBePositiveException, InvalidDigitalException {

        //GIVEN
        EmployeeEntity employeeEntity = mock(EmployeeEntity.class);
        doThrow(DepartmentIdMustBePositiveException.class).when(employeeValidationService).validateUser(employeeEntity);

        //WHEN
        Assertions.assertThrows(
                DepartmentIdMustBePositiveException.class,
                () -> employeeCreateService.createUser(employeeEntity));

        //THEN
        verifyNoInteractions(employeeEntity, employeeRepository);
        verify(employeeValidationService).validateUser(employeeEntity);
        verifyNoMoreInteractions(employeeValidationService);
    }

}