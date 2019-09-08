package com.imooc.security.core.social.qq.config;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author 郝若池
 * @title: HrcSpringSocialConfigure
 * @description: 自定义qq认证前半部分url
 * @date 2019/9/7/007 21:12
 */
public class HrcSpringSocialConfigure extends SpringSocialConfigurer {

    private String processesUrl;

    public HrcSpringSocialConfigure(String processesUrl) {
        this.processesUrl = processesUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(this.processesUrl);
        return (T) filter;
    }
}
