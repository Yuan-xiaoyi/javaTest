package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
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

    public User validUser(String userName,String password){
        User user = userMapper.validUser(userName, password);
        return user;
    }

    public boolean hasUser(String userName){
        User user = userMapper.hasUser(userName);
        return Objects.nonNull(user);
    }
    public boolean register2(long id,String userName,String password, String email){
        Integer res = userMapper.register2(id, userName, password, email);
        return res > 0;
    }

    public boolean register(User user){
        Integer result = userMapper.register(user);
        return result > 0;
    }

    public boolean updateUser(long id, String userName, String password, String email){
        Integer result = userMapper.updateUser(id, userName, password, email);
        return result > 0;
    }
    public boolean delUser(String userName){
        Integer result = userMapper.delUser(userName);
        return result > 0;
    }
}
