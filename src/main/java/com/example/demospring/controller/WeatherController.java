package com.example.demospring.controller;

import com.example.demospring.entity.MyWeather;
import com.example.demospring.entity.weatherApiStruct.Weather;
import com.example.demospring.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    public WeatherService weatherService;


    @GetMapping("/weather")
    public List<MyWeather> getWeather(@RequestParam String city) throws JsonProcessingException {
        return weatherService.getWeather(city);
    }

//    @GetMapping("/print/{city}")
//    public void print(@PathVariable("city") String city){
//        weatherService.printWeather(city);
//    }



}
