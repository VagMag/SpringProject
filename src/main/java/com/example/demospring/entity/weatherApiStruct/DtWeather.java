package com.example.demospring.entity.weatherApiStruct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DtWeather {
    private Long dt;
    private Parameters main;
}