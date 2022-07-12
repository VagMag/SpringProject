package com.example.demospring.service;

import com.example.demospring.dao.EmployeeDao;
import com.example.demospring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }
}
