package com.example.demospring.controller;

import com.example.demospring.entity.User;
import com.example.demospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers() {return userService.getAllUsers();}

    @GetMapping("/{id}")
    public User findUser(@PathVariable("id") Long id) {return userService.getUser(id);}

//    @PostMapping
//    public void createUser(@RequestBody User user){
//        userService.createUser(user);
//    }
}
