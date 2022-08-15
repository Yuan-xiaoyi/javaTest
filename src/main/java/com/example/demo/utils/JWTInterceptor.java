package com.example.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        HashMap<Object, Object> map = new HashMap<>();
        try {
            JWTUtils.checkToken(token);
            return true;
        } catch (Exception e) {
            map.put("state", "token失效");
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(map);
            response.setContentType("application/json; charset=UTF-8");
            response.getWriter().write(s);
        }
        return false;

    }
}


