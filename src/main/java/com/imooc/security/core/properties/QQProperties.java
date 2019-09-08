package com.imooc.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author 郝若池
 * @title: QQProperties
 * @description: TODO
 * @date 2019/9/7/007 16:32
 */
public class QQProperties extends SocialProperties {

    private String processesUrl = "oauth2.0";

    private String providerId = "qq";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProcessesUrl() {
        return processesUrl;
    }

    public void setProcessesUrl(String processesUrl) {
        this.processesUrl = processesUrl;
    }
}
