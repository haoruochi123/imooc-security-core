package com.imooc.security.core.validate.sms;

/**
 * @author 郝若池
 * @title: SmsCodeSender
 * @description: 短信发送
 * @date 2019/7/14/014 14:51
 */
public interface SmsCodeSender {

    /**
     * @Author: 郝若池
     * @CreateTime: 2019/7/14/014 14:54
     * @params: [mobile, smsCode]
     * @return: void
     * @Description: 发送验证
     */
    void send(String mobile, String smsCode);
}
