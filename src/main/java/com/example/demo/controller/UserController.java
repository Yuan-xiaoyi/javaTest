package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public List<User> getUser(){
        return userService.findAll();
    }

    @RequestMapping("/validUser") // 获取前端调接口传过来的数据 ，这类接口怎么写
    public HashMap<String,Object> getUser(@RequestParam("userName") String userName, @RequestParam("password") String passWord){
        HashMap<String,Object> result = new HashMap<>();
        if(userService.validUser(userName,passWord)){
            result.put("code",200);
            result.put("msg","登录成功！");
        }else{
            result.put("code",500);
            result.put("msg","登录失败！");
        }
        return result;
    }
}
