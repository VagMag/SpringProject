package com.example.demospring.service;

import com.example.demospring.dao.EmployeeDao;
import com.example.demospring.dao.EmployeePositionDao;
import com.example.demospring.dao.OrgUnitDao;
import com.example.demospring.dao.PositionDao;
import com.example.demospring.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired

    private EmployeeDao employeeDao;

    @Autowired
    private EmployeePositionDao employeePositionDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private OrgUnitDao orgUnitDao;
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }
    @Transactional
    public void createEmployee(Employee employee) {

        employeeDao.save(employee);
        EmployeePosition position = employee.getEmployeePosition();
        position.setEmployee(employee);

        Position p = position.getPosition();
        p.setEmployeePositions(Arrays.asList(position));
        position.setPosition(p);


        OrgUnit orgU = p.getOrgUnit();
        orgU.setPosition(Arrays.asList(p));
        orgUnitDao.save(orgU);
        positionDao.save(p);
        employeePositionDao.save(position);
    }
}
