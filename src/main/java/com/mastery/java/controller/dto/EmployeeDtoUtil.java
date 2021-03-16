package com.mastery.java.controller.dto;

import com.mastery.java.controller.EmployeeController;
import com.mastery.java.jms.producer.JmsProducer;
import com.mastery.java.model.EmployeeEntity;
import com.mastery.java.service.EmployeeServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class EmployeeDtoUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

    private final JmsProducer jmsProducer;
    private final EmployeeServiceImpl employeeService;
    private final ModelMapper modelMapper;

    EmployeeDtoUtil(
            JmsProducer jmsProducer, EmployeeServiceImpl employeeService,
            ModelMapper modelMapper) {
        this.jmsProducer = jmsProducer;
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
        logger.info("List with all employees are requested");
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

    public EmployeeDto create(EmployeeCreationDto dto) {
        EmployeeEntity employeeEntity = convertDtoToEmployee(dto);
        employeeEntity = employeeService.createUser(employeeEntity);
        jmsProducer.send(employeeEntity);
        logger.info("New employee is creating");
        return convertEmployeeToDto(employeeEntity);
    }

    public EmployeeDto update(Long id, EmployeeUpdateDto dto) {
        EmployeeUpdateReq req = convertDtoToEmployee(id, dto);
        EmployeeEntity employeeEntity = employeeService.updateUser(req);
        jmsProducer.send(employeeEntity);
        logger.info("The employee is updating");
        return convertEmployeeToDto(employeeEntity);
    }

    public EmployeeDeleteDto delete(Long id) {
        EmployeeEntity employeeEntity = employeeService.findById(id);
        EmployeeDeleteDto dto = new EmployeeDeleteDto();
        dto.setId(employeeEntity.getId());
        employeeService.deleteById(id);
        logger.info("The employee is requested to delete,id: " + id);
        return dto;
    }

    public EmployeeDto findUser(Long id) {
        EmployeeEntity employee = employeeService.findById(id);
        EmployeeDto dto = new EmployeeDto();
        convertDtoToEmployee(employee, dto);
        logger.info("The employee is requested,id: " + employee.getId());
        return dto;
    }


}
