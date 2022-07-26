package com.example.demospring.dao;

import com.example.demospring.entity.MyWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDao extends JpaRepository<MyWeather, Long> {

}
