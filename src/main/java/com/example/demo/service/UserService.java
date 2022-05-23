package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public boolean validUser(String userName,String password){
        User user = userMapper.validUser(userName, password);
        return Objects.nonNull(user);
    }
}
