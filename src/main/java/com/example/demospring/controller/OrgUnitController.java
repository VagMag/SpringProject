package com.example.demospring.controller;

import com.example.demospring.entity.OrgUnit;
import com.example.demospring.service.OrgUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orgunit")
public class OrgUnitController {
    @Autowired
    private OrgUnitService orgUnitService;

    @GetMapping
    public List<OrgUnit> findAll() {
        return orgUnitService.getAllOrgUnits();
    }

    @GetMapping("/{id}")
    public OrgUnit findById(@PathVariable("id") Long id) {

        return orgUnitService.getOrgUnit(id);
    }

}
