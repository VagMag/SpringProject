package com.example.demospring.dao;

import com.example.demospring.entity.OrgUnit;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrgUnitDao extends JpaRepository<OrgUnit, Long> {
}


