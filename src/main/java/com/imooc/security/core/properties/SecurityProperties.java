package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SecurityProperties  
 * @Description: TODO
 * @author 郝若池
 * @date 2019年6月2日 下午5:27:04
 */
@ConfigurationProperties(prefix="security")
@Component
public class SecurityProperties {

	private SecurityBrowserProperties browser= new SecurityBrowserProperties();

	public SecurityBrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(SecurityBrowserProperties browser) {
		this.browser = browser;
	}
	
}
