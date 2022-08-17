package com.mastery.java.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mastery.java.dto.EmployeeCreationDto;
import com.mastery.java.dto.EmployeeDto;
import com.mastery.java.model.Employee;

@Component
public class EmployeeMapper {

    private ModelMapper mapper;

    public EmployeeMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Employee map(final EmployeeCreationDto dto) {
        return mapper.map(dto, Employee.class);
    }

    public EmployeeDto map(final Employee employee) {
        return mapper.map(employee, EmployeeDto.class);
    }



}
