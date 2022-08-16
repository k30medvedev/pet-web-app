package com.mastery.java.validation;

import com.mastery.java.dto.EmployeeCreationDto;

public interface EmployeeValidationService {

    void validateUser(final EmployeeCreationDto employee);

}
