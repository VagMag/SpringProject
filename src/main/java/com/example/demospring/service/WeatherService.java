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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private WeatherDao weatherDao;

    public WeatherService(WeatherDao weatherDao) {
        this.weatherDao = weatherDao;
    }
    //Вывод всех данных таблицы
//    public List<MyWeather> getAllWeather() {
//        return weatherDao.findAll();
//    }
    public List<MyWeather> getAllWeather() {
        return weatherDao.findAll();
    }

    private String key = "733ff65c6c3c136d5671ac505bb549ee";
    private String mainUrl = "http://api.openweathermap.org/data/2.5/forecast?units=metric&appid=" + key + "&q=";


    //Запрос данных конкретного города
    public List<MyWeather> getWeather(String city) throws JsonProcessingException {
        String weather = restTemplate.getForObject(mainUrl + city, String.class);
        Weather weather1 = new ObjectMapper().readValue(weather, Weather.class);
        List<MyWeather> myWeathers = new ArrayList<>();
        for (DtWeather dtWeather1 : weather1.getList()) {
            MyWeather myWeather = new MyWeather();
            myWeather.setTemp(dtWeather1.getMain().getTemp());
            myWeather.setName(city);
            LocalDateTime triggerTime =
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(dtWeather1.getDt() * 1000),
                            TimeZone.getDefault().toZoneId());
            myWeather.setTime(triggerTime);
            myWeathers.add(myWeather);
        }
        return myWeathers;
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
