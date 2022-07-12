package com.example.demospring.service;

import com.example.demospring.dao.OrgUnitDao;
import com.example.demospring.entity.OrgUnit;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgUnitService {

    @Autowired
    private OrgUnitDao orgUnitDao;


    public List<OrgUnit> getAllOrgUnits(){
        return orgUnitDao.findAll();
    }

    public OrgUnit getOrgUnit(Long id){

        return orgUnitDao.findById(id).orElseThrow();
    }
}
