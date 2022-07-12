package com.example.demospring.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
}
