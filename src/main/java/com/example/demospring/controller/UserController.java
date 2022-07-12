package com.example.demospring.controller;

import com.example.demospring.entity.User;
import com.example.demospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private List<User> findAllUsers() {return userService.getAllUsers();}

    @GetMapping("/{id}")
    private User findUser(@PathVariable("id") Long id) {return userService.getUser(id);}
}
