package com.mastery.java.service;

import com.mastery.java.controller.EmployeeController;
import com.mastery.java.controller.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;
import com.sun.istack.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.validation.Valid;


@Service
public class EmployeeValidationService {
    private static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

    public void validateUser(@NotNull @Valid EmployeeEntity employeeEntity) throws DepartmentIdMustBePositiveException {
        Integer departmentId = employeeEntity.getDepartmentId();
        if (departmentId <= 0) {
            logger.error("Id department must be more then 0.Your chose is : ");
            throw new DepartmentIdMustBePositiveException(departmentId);
        }

        String checkGender = employeeEntity.getGender();
        if (!(checkGender.equals("M") | checkGender.equals("F"))) {
            logger.error("Invalid gender, Please choose M for man or W for woman : ");
            throw new InvalidGenderException(checkGender);
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
