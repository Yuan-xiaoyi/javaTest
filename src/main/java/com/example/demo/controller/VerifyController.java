package com.example.demo.controller;

import com.example.demo.utils.VerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class VerifyController {
    private final static Logger logger = LoggerFactory.getLogger(VerifyController.class);

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {

        try {
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);

            VerifyUtil randomValidateCode = new VerifyUtil();

            randomValidateCode.getRandomCode(request, response);//输出验证码图片方法

        } catch (Exception e) {

            logger.error("获取验证码失败>>>> ", e);

        }

    }

    /**
     * 校验验证码
     */
    @RequestMapping(value = "/checkVerify", method = RequestMethod.POST, headers = "Accept=application/json")
    public boolean checkVerify(@RequestParam String verifyInput, HttpSession session) {
        try {
            //从session中获取随机数
            String inputStr = verifyInput;

            String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");

            if (random == null || "".equals(random) || !random.equalsIgnoreCase(inputStr)) {
                return false;
            } else {
                return true;
            }

        } catch (Exception e) {
            logger.error("验证码校验失败", e);
            return false;
        }
    }

}