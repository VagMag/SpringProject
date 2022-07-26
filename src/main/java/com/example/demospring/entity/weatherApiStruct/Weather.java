package com.example.demospring.entity.weatherApiStruct;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private Integer message;
    private String cod;
    private List<DtWeather> list;

}

