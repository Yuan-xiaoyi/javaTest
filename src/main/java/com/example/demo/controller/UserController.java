package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUsers")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @RequestMapping("/validUser") // 获取前端调接口传过来的数据
    public HashMap<String,Object> login(@RequestParam("userName") String userName, @RequestParam("password") String password){
        HashMap<String,Object> result = new HashMap<>();
        User user = userService.validUser(userName,password);
        if(Objects.nonNull(user)){
            result.put("code",200);
            result.put("msg","登录成功！");
            result.put("res", user);
        }else{
            result.put("code",500);
            result.put("msg","登录失败！");
        }
        return result;
    }

    @RequestMapping("/register") // 获取前端调接口传过来的数据
    public HashMap<String,Object> register(@RequestParam(value = "userName",required = true) String userName,
                                           @RequestParam(value = "password",required = true) String password,
                                           @RequestParam(value = "email",required = false) String email){

        HashMap<String,Object> result = new HashMap<>();
        if(Objects.nonNull(userName) && Objects.nonNull(password)){
            if(userService.hasUser(userName)){
                // 已包含用户，不能注册
                result.put("code",500);
                result.put("msg","已包含用户，不能注册！");
            }else{
//                User user = new User();
//                user.setId(System.currentTimeMillis());
//                user.setName(userName);
//                user.setPassword(passWord);
//                user.setEmail("");
//                if(userService.register(user)) {
//                    result.put("code", 200);
//                    result.put("msg", "注册成功！");
//                }
                long id = System.currentTimeMillis();
                if(userService.register2(id,userName,password,email)) {
                    User user = userService.validUser(userName,password);
                    result.put("code", 200);
                    result.put("msg", "注册成功！");
                    result.put("res", user);
                }
            }
        }else {
            result.put("code", 500);
            result.put("msg", "参数缺失！");
        }

        return result;
    }

    @RequestMapping("/updateUser") // 获取前端调接口传过来的数据
    public HashMap<String,Object> updateUser(@RequestParam(value = "id",required = true) String id,
                                             @RequestParam(value = "userName",required = false) String userName,
                                             @RequestParam(value = "password",required = false) String password,
                                             @RequestParam(value = "email",required = false) String email) {
        HashMap<String, Object> result = new HashMap<>();

        if(Objects.nonNull(id)){
            if(userService.hasUser(userName)) {
                // 已包含用户，不能更改
                result.put("code", 500);
                result.put("msg", "此用户名已被占用！");
            }else {
                if(userService.updateUser(Long.valueOf(id),userName,password,email)) {
                    User resUser = userService.validUser(userName,password);
                    result.put("code", 200);
                    result.put("msg", "更改成功！");
                    result.put("res", resUser);
                }
            }
        }else {
            result.put("code", 500);
            result.put("msg", "参数缺失！");
        }
        return result;
    }

    @RequestMapping("/delUser") // 获取前端调接口传过来的数据
    public HashMap<String,Object> delUser(String userName){
        HashMap<String,Object> result = new HashMap<>();
        if(userService.hasUser(userName)) {
            if(userService.delUser(userName)) {
                result.put("code", 200);
                result.put("msg", "删除成功！");
            }
        }else {
            result.put("code", 500);
            result.put("msg", "不含用户或用户已删除！");
        }
        return result;
    }
}
