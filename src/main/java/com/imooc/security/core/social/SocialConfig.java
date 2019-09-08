package com.imooc.security.core.social;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.social.qq.config.HrcSpringSocialConfigure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @author 郝若池
 * @title: SocialConfig
 * @description: TODO
 * @date 2019/9/5/005 21:29
 */
@Configuration
@EnableSocial
@Order(10)
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository jdbcUsersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        //给userconnection表加个前缀变成hrc_userconnection
        jdbcUsersConnectionRepository.setTablePrefix("hrc_");
        if (connectionSignUp !=null){
            jdbcUsersConnectionRepository.setConnectionSignUp(connectionSignUp);
        }
        return jdbcUsersConnectionRepository;
    }

    @Bean
    public SpringSocialConfigurer  springSocialConfigurer(){

        //设置认证前缀 默认为/auth 例/oauth2.0
        HrcSpringSocialConfigure hrcSpringSocialConfigure = new HrcSpringSocialConfigure(securityProperties.getSocial().getQq().getProcessesUrl());
        //自定义注册页面
        hrcSpringSocialConfigure.signupUrl(securityProperties.getBrowser().getSignUpUrl());

        return hrcSpringSocialConfigure;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator,
                getUsersConnectionRepository(connectionFactoryLocator)) {
        };
    }
}
