package com.imooc.security.core.properties;

/**
 * @ClassName: SecurityBrowserProperties  
 * @Description: TODO
 * @author 郝若池
 * @date 2019年6月2日 下午5:28:31
 */
public class SecurityBrowserProperties {

	private String loginPage = "/login/login.html";
	
	//记住我过期时间
	private int tokenValiditySeconds = 60*60*24*7;

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}

	public int getTokenValiditySeconds() {
		return tokenValiditySeconds;
	}

	public void setTokenValiditySeconds(int tokenValiditySeconds) {
		this.tokenValiditySeconds = tokenValiditySeconds;
	}
	
}
