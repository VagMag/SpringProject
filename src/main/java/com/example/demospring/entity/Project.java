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
@Table(name = "project")
public class Project extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name = "project_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "employee_id", nullable = false)}
    )
    private List<Employee> employees = new ArrayList<>();
}
