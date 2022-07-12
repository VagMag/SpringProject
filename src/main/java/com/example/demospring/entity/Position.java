package com.example.demospring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "position")
public class Position extends AbstractEntity{

    @OneToMany(mappedBy = "position")
    private List<EmployeePosition> employeePositions = new ArrayList<>();


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "org_unit_id")
    private OrgUnit orgUnit;
}
