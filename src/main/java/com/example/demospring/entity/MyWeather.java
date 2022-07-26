package com.example.demospring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "weather")
public class MyWeather extends AbstractEntity{

    @Column(name = "city_name")
    private String name;

    @Column(name = "temp")
    private Double temp;

    @Column(name = "time")
    private LocalDateTime time;
}
