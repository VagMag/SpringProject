package com.example.demospring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employee_position")
public class EmployeePosition extends AbstractEntity {

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Position position;

    private LocalDate startDate;
    private LocalDate endDate;
}
