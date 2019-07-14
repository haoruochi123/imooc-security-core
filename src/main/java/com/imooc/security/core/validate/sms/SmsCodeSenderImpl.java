package com.imooc.security.core.validate.sms;

/**
 * @author 郝若池
 * @title: SmsCodeSenderImpl
 * @description: 短信发送
 * @date 2019/7/14/014 14:52
 */
public class SmsCodeSenderImpl implements SmsCodeSender {

    @Override
    public void send(String mobile, String smsCode) {

        System.out.println("向手机："+mobile+"发送验证码"+smsCode);
    }
}
