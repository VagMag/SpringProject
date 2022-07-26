package com.example.demospring.dao;

import com.example.demospring.entity.Position;
import com.example.demospring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionDao extends JpaRepository<Position, Long> {
}
