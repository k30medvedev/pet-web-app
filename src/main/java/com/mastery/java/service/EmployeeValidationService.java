package com.mastery.java.service;

import com.mastery.java.controller.dto.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.repository.EmployeeRepository;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;


@Service
public class EmployeeValidationService {

    private static final Logger logger = LogManager.getLogger(EmployeeValidationService.class.getName());


    private final EmployeeRepository employeeRepository;

    public EmployeeValidationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void validateUser(@NotNull @Valid EmployeeEntity employeeEntity) throws DepartmentIdMustBePositiveException, InvalidDigitalException {
        Integer departmentId = employeeEntity.getDepartmentId();
        String firstName = employeeEntity.getFirstName();
        String lastName = employeeEntity.getLastName();
        LocalDate birthDay = employeeEntity.getBirthday();
        String expression = "[A-Z][a-z]*";

        if (departmentId <= 0) {
            logger.error("Id department must be more then 0.Your chose is : ");
            throw new DepartmentIdMustBePositiveException(departmentId);
        }

        String checkGender = employeeEntity.getGender();
        if (!(checkGender.equals("M") | checkGender.equals("F"))) {
            logger.error("Invalid gender");
            throw new InvalidGenderException(checkGender);
        }


        boolean suchPersonAlreadyExists = employeeRepository.
                existsByFirstNameAndLastNameAndBirthdayAllIgnoreCase
                        (firstName, lastName, birthDay);
        if (suchPersonAlreadyExists) {
            throw new PersonAlreadyInUseException(firstName,lastName,birthDay);
        }


        if (!firstName.matches(expression) | !lastName.matches(expression)) {
            throw new InvalidDigitalException(firstName);
        }

    }

    public void validateUserUpdateReq(@NotNull EmployeeEntity employeeEntity, @Valid EmployeeUpdateReq updateReq) throws DepartmentIdMustBePositiveException {
        Integer departmentId = updateReq.getDepartmentId();
        if (departmentId <= 0) {
            logger.error("Id department must be more then 0.Your chose is : ");
            throw new DepartmentIdMustBePositiveException(departmentId);
        }
    }
}
