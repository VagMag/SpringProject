package com.example.demospring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(mappedBy = "employee")
    private EmployeePosition employeePosition;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "patronymic_name")
    private String patronymicName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name = "employee_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "project_id", nullable = false)}
    )
    private List<Project> projects = new ArrayList<>();


}
