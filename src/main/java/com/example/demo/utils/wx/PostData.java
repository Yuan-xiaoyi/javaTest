package com.example.demo.utils.wx;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class PostData {
    public String PostData(String url ,String appid,String appSecret,String code,String authorization_code) {
        try {
            //post请求
            HttpMethod method = HttpMethod.GET;
            // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
            MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
            params.add("appid",appid);
            params.add("secret",appSecret);
            params.add("js_code",code);
            params.add("grant_type",authorization_code);
            System.out.print("发送数据：" + params.toString()+"\n");
            //发送http请求并返回结果
            String result = HttpRestUtils.get(url, params);
            System.out.print("接收反馈：" + result+"\n");
            return result;
        } catch (Exception e) {
            System.out.println("------------- " + this.getClass().toString() + ".PostData() : 出现异常 Exception -------------");
            System.out.println(e.getMessage());
            return "";
        }
    }
}
