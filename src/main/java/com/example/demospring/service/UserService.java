package com.example.demospring.service;

import com.example.demospring.controller.UserController;
import com.example.demospring.dao.UserDao;
import com.example.demospring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserService {
    Random random = new Random();
    @Autowired
    private UserDao userDao;


    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUser(Long id) {

        return userDao.findById(id).orElseThrow();
    }

//    public void createUser(User user) {
//        userDao.save(user);
//    }
//    @Scheduled(fixedRate = 5000)
//    public void createUsers() {
//            User user = new User();
//            user.setUserName("qq" + random.nextInt());
//            user.setPassword("3243546y" + random.nextInt());
//            userDao.save(user);
//        System.out.println("user created");


//    }
}

