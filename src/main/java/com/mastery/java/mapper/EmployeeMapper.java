package com.mastery.java.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.mastery.java.dto.EmployeeCreationDto;
import com.mastery.java.dto.EmployeeDto;
import com.mastery.java.model.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final ModelMapper mapper;

    public Employee map(final EmployeeCreationDto dto) {
        return mapper.map(dto, Employee.class);
    }

    public EmployeeDto map(final Employee employee) {
        return mapper.map(employee, EmployeeDto.class);
    }



}
