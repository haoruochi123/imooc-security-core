package com.imooc.security.core.social.qq.config;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author 郝若池
 * @title: hrcConnectionSignUp
 * @description: qq自动注册注入此类
 * @date 2019/9/8/008 13:28
 */
@Component
public class hrcConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        //根据社交用户信息默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }
}
