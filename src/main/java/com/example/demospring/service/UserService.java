package com.example.demospring.service;

import com.example.demospring.dao.UserDao;
import com.example.demospring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;


    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    public User getUser(Long id){

        return userDao.findById(id).orElseThrow();
    }
}
