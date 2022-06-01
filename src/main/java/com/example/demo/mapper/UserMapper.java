package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();

    User validUser(String userName,String password);

    User hasUser(String userName);

    Integer register(User user);

    Integer register2(long id, @Param("userName") String userName, @Param("password") String password, @Param("email") String email);

    Integer updateUser(long id, @Param("userName") String userName, @Param("password") String password, @Param("email") String email);

    Integer delUser(String userName);
}
