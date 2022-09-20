package com.example.demo.controller;

import com.example.demo.utils.wx.WechatUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.utils.wx.PostData;
import com.example.demo.utils.wx.globalData;


import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@RestController
@ApiOperation( value = "微信")
public class wxApi {
    com.example.demo.utils.wx.globalData globalData = new globalData();

    //解析电话号码
    @GetMapping("/wx/getsessionkey")
    @ApiOperation( value = "获取用户授权的信息和电话号码")
    public Object getsessionkey(String js_code,String encryptedData, String iv) throws JsonProcessingException {
        PostData PostData = new PostData();
        String responseData =  PostData.PostData(globalData.url, globalData.appid, globalData.secret,js_code,globalData.grant_type);
        //获取SessionKey 和openid
        ObjectMapper mapper = new ObjectMapper();
        JsonNode resData = mapper.readTree(responseData);
        try{
            if(resData.get("session_key").asText()!=null)
            {
                String SessionKey = resData.get("session_key").asText();
                String openid = resData.get("openid").asText();
//                System.out.println("SessionKey="+SessionKey);
                System.out.println("openid="+openid);
//                System.out.println("encryptedData="+encryptedData);
//                System.out.println("iv="+iv);
                String wxDecrypt = WechatUtils.wxDecrypt(encryptedData,SessionKey,iv);
//                System.out.println(wxDecrypt);
                return wxDecrypt;
            }else {
                System.out.println("请求微信服务器异常");
            }

        }catch (Exception e)
        {
            System.out.println("请求微信服务器异常");
        }
        return 0;
    }
}