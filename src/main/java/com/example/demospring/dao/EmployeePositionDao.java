package com.example.demospring.dao;

import com.example.demospring.entity.Employee;
import com.example.demospring.entity.EmployeePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePositionDao extends JpaRepository<EmployeePosition, Long> {

}
