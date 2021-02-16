package com.mastery.java.controller;

import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
import java.util.List;

@Component
public class EmployeeDtoConverter {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    public EmployeeDtoConverter(
            EmployeeService employeeService,
            ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }


    public EmployeeListDto getEmployeeListDto() {
        EmployeeListDto employeeDto = new EmployeeListDto();
        List<EmployeeEntity> listEmployees = employeeService.findAll();
        Type listType = new TypeToken<List<EmployeeDto>>() {
        }.getType();
        List<EmployeeDto> listEmployeesDto = modelMapper.map(listEmployees, listType);
        employeeDto.setEmployees(listEmployeesDto);
        return employeeDto;

    }

    public EmployeeUpdateReq convertDtoToEmployee(Long id, EmployeeUpdateDto dto) {
        EmployeeUpdateReq model = new EmployeeUpdateReq();
        model.setId(id);
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setDepartmentId(dto.getDepartmentId());
        model.setJobTitle(dto.getJobTitle());
        model.setGender(dto.getGender());
        model.setBirthday(dto.getBirthday());
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

    }

    public EmployeeEntity convertDtoToEmployee(EmployeeCreationDto dto) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(dto.getFirstName());
        employeeEntity.setLastName(dto.getLastName());
        employeeEntity.setDepartmentId(dto.getDepartmentId());
        employeeEntity.setJobTitle(dto.getJobTitle());
        employeeEntity.setGender(dto.getGender());
        employeeEntity.setBirthday(dto.getBirthday());
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
        return dto;
    }
}
