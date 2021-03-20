package com.mastery.java.controller.dto;

import com.mastery.java.controller.EmployeeController;
import com.mastery.java.model.EmployeeEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());


    public EmployeeUpdateReq convertDtoToEmployee(Long id, EmployeeUpdateDto dto) {
        EmployeeUpdateReq model = new EmployeeUpdateReq();
        model.setId(id);
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setDepartmentId(dto.getDepartmentId());
        model.setJobTitle(dto.getJobTitle());
        model.setGender(dto.getGender());
        model.setBirthday(dto.getBirthday());
        logger.info("Dto was converted to employeeEntity with id:" + model.getId());
        return model;
    }

    public void convertDtoToEmployee(EmployeeEntity employee, EmployeeDto dto) {
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setDepartmentId(employee.getDepartmentId());
        dto.setJobTitle(employee.getJobTitle());
        dto.setGender(employee.getGender());
        dto.setBirthday(employee.getBirthday());
        logger.info("Dto was converted to employeeEntity with id:" + employee.getId());
    }

    public EmployeeEntity convertDtoToEmployee(EmployeeCreationDto dto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(dto.getFirstName());
        employeeEntity.setLastName(dto.getLastName());
        employeeEntity.setDepartmentId(dto.getDepartmentId());
        employeeEntity.setJobTitle(dto.getJobTitle());
        employeeEntity.setGender(dto.getGender());
        employeeEntity.setBirthday(dto.getBirthday());
        logger.info("Dto was converted to employeeEntity");
        return employeeEntity;

    }


    public EmployeeDto convertEmployeeToDto(EmployeeEntity employeeEntity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employeeEntity.getId());
        dto.setFirstName(employeeEntity.getFirstName());
        dto.setLastName(employeeEntity.getLastName());
        dto.setDepartmentId(employeeEntity.getDepartmentId());
        dto.setJobTitle(employeeEntity.getJobTitle());
        dto.setGender(employeeEntity.getGender());
        dto.setBirthday(employeeEntity.getBirthday());
        logger.info("EmployeeEntity was converted to dto with id:" + employeeEntity.getId());
        return dto;
    }

}
