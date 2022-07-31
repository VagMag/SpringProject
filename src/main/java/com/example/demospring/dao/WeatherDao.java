package com.example.demospring.dao;

import com.example.demospring.entity.MyWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Repository
public interface WeatherDao extends JpaRepository<MyWeather, Long> {

    LocalDateTime startFrom = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
    LocalDateTime finish = startFrom.plusDays(3);

    @Query("select w from MyWeather w where w.name = :cityName and w.time = :time")
    MyWeather findByCityAndTime(@Param("cityName") String cityName, @Param("time") LocalDateTime time);

    @Query("select w from MyWeather w where w.time >= :startFrom and w.time < :finish")
    MyWeather findForThreeDays(LocalDateTime startFrom, LocalDateTime finish);
}

