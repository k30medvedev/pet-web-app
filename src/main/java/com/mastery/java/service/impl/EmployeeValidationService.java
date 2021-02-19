package com.mastery.java.service.impl;

import com.mastery.java.controller.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.service.DepartmentIdMustBePositiveException;
import com.mastery.java.service.InvalidDigitalException;
import com.mastery.java.service.InvalidGenderException;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.validation.Valid;


@Service
public class EmployeeValidationService {
    private static final Logger logger = LogManager.getLogger(EmployeeValidationService.class.getName());

    public void validateUser(@NotNull @Valid EmployeeEntity employeeEntity) throws DepartmentIdMustBePositiveException, InvalidDigitalException {
        Integer departmentId = employeeEntity.getDepartmentId();
        if (departmentId <= 0) {
            logger.error("Id department must be more then 0.Your chose is : ");
            throw new DepartmentIdMustBePositiveException(departmentId);
        }

        String checkGender = employeeEntity.getGender();
        if (!(checkGender.equals("M") | checkGender.equals("F"))) {
            logger.error("Invalid gender");
            throw new InvalidGenderException(checkGender);
        }

        String firstName = employeeEntity.getFirstName();
        String lastName = employeeEntity.getLastName();
        String expression = "[A-Z][a-z]*";
        if (!firstName.matches(expression) | !lastName.matches(expression)){
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
