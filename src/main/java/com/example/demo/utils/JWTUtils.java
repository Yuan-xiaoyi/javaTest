package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    private static final String SIGN = "wdnmd";//自定义的 很重要不能让别人知道

    /**
     * 根据id ， 名称生成token
     * @param map
     * @return
     */
    public static String createToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 7);//默认七天过期
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });

        return builder.withExpiresAt(instance.getTime())//设置过期时间
                .sign(Algorithm.HMAC256(SIGN));

    }

    /**
     * 验证token合法性
     *
     * @param token
     */
    public static void checkToken(String token) {
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }


}

