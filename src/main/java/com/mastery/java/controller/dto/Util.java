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
public class Util {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class.getName());

    private final EmployeeServiceImpl employeeService;
    private final JmsProducer jmsProducer;
    private final EmployeeConverter employeeConverter;
    private final ModelMapper modelMapper;

    public Util(EmployeeServiceImpl employeeService,
                JmsProducer jmsProducer,
                EmployeeConverter employeeConverter,
                ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.jmsProducer = jmsProducer;
        this.employeeConverter = employeeConverter;
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

    public EmployeeDto create(EmployeeCreationDto dto) {
        EmployeeEntity employeeEntity = employeeConverter.convertDtoToEmployee(dto);
        employeeEntity = employeeService.createUser(employeeEntity);
        jmsProducer.send(employeeEntity);
        logger.info("New employee is creating; " +
                " FirstName: " + dto.getFirstName() +
                " LastName:" + dto.getLastName() +
                " Gender:" + dto.getGender() +
                " Birthday:" + dto.getBirthday() +
                " DepartmentId:" + dto.getDepartmentId());
        return employeeConverter.convertEmployeeToDto(employeeEntity);
    }

    public EmployeeDto update(Long id, EmployeeUpdateDto dto) {
        EmployeeUpdateReq req = employeeConverter.convertDtoToEmployee(id, dto);
        EmployeeEntity employeeEntity = employeeService.updateUser(req);
        jmsProducer.send(employeeEntity);
        logger.info("The employee is updating with id: " + req.getId());
        return employeeConverter.convertEmployeeToDto(employeeEntity);
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
        employeeConverter.convertDtoToEmployee(employee, dto);
        logger.info("The employee is requested,id: " + employee.getId());
        return dto;
    }

}
