package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 郝若池
 * @ClassName: SecurityProperties
 * @Description: TODO
 * @date 2019年6月2日 下午5:27:04
 */
@ConfigurationProperties(prefix = "security")
@Component
public class SecurityProperties {

    private SecurityBrowserProperties browser = new SecurityBrowserProperties();

    private SocialProperties social = new SocialProperties();

    public SecurityBrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(SecurityBrowserProperties browser) {
        this.browser = browser;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }
}
