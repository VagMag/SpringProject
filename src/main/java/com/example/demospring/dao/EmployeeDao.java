package com.example.demospring.dao;

import com.example.demospring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
