package com.imooc.security.core.validate.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 郝若池
 * @title: SmsCodeController
 * @description: 短信验证码
 * @date 2019/7/14/014 15:06
 */
@RestController
public class SmsCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_SMS_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws ServletRequestBindingException {

        SmsCode smsCode = new SmsCode(RandomStringUtils.randomNumeric(4),60);
        sessionStrategy.setAttribute(new ServletWebRequest(request),SESSION_KEY,smsCode);
        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");
        SmsCodeSender smsCodeSender = new SmsCodeSenderImpl();
        smsCodeSender.send(mobile,smsCode.getSmsCode());

    }
}
