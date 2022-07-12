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
@Table(name = "orgunit")
public class OrgUnit extends AbstractEntity{

    @OneToMany(mappedBy = "orgUnit")
    private List<Position> position = new ArrayList<>();

    @Column
    private String name;

}
