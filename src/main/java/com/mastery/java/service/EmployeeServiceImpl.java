package com.mastery.java.service;

import com.mastery.java.controller.dto.EmployeeUpdateReq;
import com.mastery.java.model.EmployeeEntity;

import java.util.List;


public interface EmployeeServiceImpl {

    List<EmployeeEntity> findAll();

    EmployeeEntity findById(Long id);

    void deleteById(Long id);

    EmployeeEntity createUser(EmployeeEntity employeeEntity);

    EmployeeEntity updateUser(EmployeeUpdateReq updateReq);

}
