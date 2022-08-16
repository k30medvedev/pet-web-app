package com.mastery.java.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class EmployeeListDto {

    List<EmployeeDto> employees = new ArrayList<>();

}
