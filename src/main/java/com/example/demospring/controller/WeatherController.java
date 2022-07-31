package com.example.demospring.controller;

import com.example.demospring.service.ExcelGenerator;
import com.example.demospring.entity.MyWeather;
import com.example.demospring.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    public WeatherService weatherService;


    @GetMapping("/weather")
    public List<MyWeather> getWeather(@RequestParam String city) throws JsonProcessingException {
        return weatherService.getWeather(city);
    }

    @GetMapping("/weather/export-to-excel")
    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=weather" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List < MyWeather > listOfWeathers = weatherService.getAllWeather();

        ExcelGenerator generator = new ExcelGenerator(listOfWeathers);

        generator.generateExcelFile(response);
    }

    //автоматическая проверка погоды
    //@Scheduled(fixedRate = 30000)
    public void checkWeather() throws JsonProcessingException {
        weatherService.checkWeather();
    }
}
