package com.imooc.security.core.validate.sms;

import java.time.LocalDateTime;

/**
 * @author 郝若池
 * @title: SmsCode
 * @description: 短信验证码code
 * @date 2019/7/14/014 13:24
 */
public class SmsCode {

    /**
     * 短信验证码
     */
    private String smsCode;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * @Author: 郝若池
     * @2019/7/14/014016:5414/014 13:39
[smsCode, expireTime]ode, expireTime]  [短信验证码,过期时间 单位秒]
     * @return:
     * @Description: 构造器
     */
    public SmsCode(String smsCode, int expireTime) {
        this.smsCode = smsCode;
        this.expireTime = LocalDateTime.now().plusSeconds(expireTime);
    }

    /**
     * @Author: 郝若池
     * @CreateTime: 2019/7/14/014 13:38
     * @params: []
     * @return: boolean
     * @Description: 是否过期，true-是，false-不是
     */
    public boolean isExpire() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
