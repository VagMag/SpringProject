package com.example.demospring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @JsonBackReference
    @OneToOne(mappedBy = "user")
    private Employee employee;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;


}
