package com.mastery.java.validation;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.mastery.java.exception.DepartmentIdMustBePositiveException;
import com.mastery.java.exception.InvalidGenderException;
import com.mastery.java.exception.PersonAlreadyInUseException;
import com.mastery.java.model.Employee;
import com.mastery.java.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {

    private final EmployeeRepository employeeRepository;

    public EmployeeValidationServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void validateUser(final Employee employee) {
        Integer departmentId = employee.getDepartmentId();
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        LocalDate birthDay = employee.getBirthday();

        if (departmentId <= 0) {
            log.info("Id department must be more then 0.Your chose is : ");
            throw new DepartmentIdMustBePositiveException(departmentId);
        }

        String checkGender = employee.getGender();
        if (!(checkGender.equals("M") | checkGender.equals("F"))) {
            log.info("Invalid gender");
            throw new InvalidGenderException(checkGender);
        }

        boolean suchPersonAlreadyExists =
                employeeRepository.existsByFirstNameAndLastNameAndBirthdayAllIgnoreCase(firstName, lastName, birthDay);
        if (suchPersonAlreadyExists) {
            throw new PersonAlreadyInUseException(firstName, lastName, birthDay);
        }

    }

}
