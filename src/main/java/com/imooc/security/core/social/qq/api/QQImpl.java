package com.imooc.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import java.io.IOException;

/**
 * @author 郝若池
 * @title: QQImpl
 * @description: qq api
 * @date 2019/9/2/002 19:52
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 获取openId地址，openId是用户在qq的唯一id
     */
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 获取用户信息地址
     */
    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    public QQImpl(String accessToken, String appId) {
        //token策略，默认是把accessToken放入请求头，qq的获取用户信息是把accessToken放在url参数上
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        //获取openId
        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);
        //返回的是json格式 例：{"client_id":"YOUR_APPID","openid":"YOUR_OPENID"}
        this.openId = StringUtils.substringBetween(result,"\"openid\":\"","\"}");
        logger.info("qq获取的用户openid：" + this.openId);
        SecurityContextHolder.getContext().getAuthentication();

    }

    @Override
    public QQUserInfo getQQUserInfo() {

        String url = String.format(URL_GET_USERINFO, appId, openId);
        String res = getRestTemplate().getForObject(url, String.class);
        logger.info("qq获取的用户信息：" + res);
        //获取qq用户信息
        QQUserInfo qqUserInfo = null;
        try {
            qqUserInfo = objectMapper.readValue(res, QQUserInfo.class);
            qqUserInfo.setOpenId(openId);
        } catch (IOException e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
        return qqUserInfo;
    }
}
