package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/abc")
    public Animal getName(){
        return new Animal("Dog",5);
    }

    @RequestMapping("/abcd")
    public List<User> getUser(){
        return userService.findAll();
    }
}
