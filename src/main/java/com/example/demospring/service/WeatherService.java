package com.example.demospring.service;

import com.example.demospring.dao.WeatherDao;
import com.example.demospring.entity.MyWeather;
import com.example.demospring.entity.weatherApiStruct.DtWeather;
import com.example.demospring.entity.weatherApiStruct.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private WeatherDao weatherDao;

    public WeatherService(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }

    private final String key = "733ff65c6c3c136d5671ac505bb549ee";
    private final String mainUrl = "http://api.openweathermap.org/data/2.5/forecast?units=metric&appid=" + key + "&q=";

    //Вывести все данные о погоде
    public List<MyWeather> getAllWeather(){
        return weatherDao.findAll();
    }

    //Запрос данных конкретного города
    public List<MyWeather> getWeather(String city) throws JsonProcessingException {

        String weather = restTemplate.getForObject(mainUrl + city, String.class);
        Weather weather1 = new ObjectMapper().readValue(weather, Weather.class);
        List<MyWeather> myWeathers = new ArrayList<>();
        for (DtWeather dtWeather1 : weather1.getList()) {
            LocalDateTime triggerTime = timeTransfer(dtWeather1.getDt());
            MyWeather existed = weatherDao.findByCityAndTime(city, triggerTime);
            if (Objects.isNull(existed)) {
                MyWeather myWeather = new MyWeather();
                myWeather.setTemp(dtWeather1.getMain().getTemp());
                myWeather.setName(city);
                myWeather.setTime(triggerTime);
                weatherDao.save(myWeather);
            } else {
                existed.setTemp(dtWeather1.getMain().getTemp());
                weatherDao.save(existed);
            }
        }
        return myWeathers;
    }

    //перевод даты
    private LocalDateTime timeTransfer(Long dt) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(dt * 1000),
                TimeZone.getDefault().toZoneId());
    }


    public void checkWeather() throws JsonProcessingException {
        getWeather("moscow");
        getWeather("london");
        getWeather("ekaterinburg");
    }



//    //Печать данных конкретного города
//    public void printWeather(String city){
//        RestTemplate restTemplate = new RestTemplate();
//        String url = (mainUrl + city);
//        ResponseEntity<String> printWeather = restTemplate.getForEntity(url, String.class);
//        String prodJson = printWeather.getBody();
//        System.out.println(printWeather);
//
//    }

}
