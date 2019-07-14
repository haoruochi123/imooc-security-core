package com.imooc.security.core.validate.code;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateCodeFilter extends OncePerRequestFilter{
	
	private AuthenticationFailureHandler authenticationFailureHandler;

	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (StringUtils.equals("/authentication/form", request.getRequestURI()) && 
				StringUtils.equals("POST", request.getMethod())) {
			
			try {
				Validate(new ServletWebRequest(request));
			} catch (ValidateCodeException e) {
				authenticationFailureHandler.onAuthenticationFailure(request, response, e);
				return;
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

	/**
	 * @Title: Validate   
	 * @Description: 图形验证码验证
	 * @author: 郝若池
	 * @date: 2019年6月2日 下午8:58:49
	 * @param: @param servletWebRequest      
	 * @return: void      
	 * @throws
	 */
	private void Validate(ServletWebRequest servletWebRequest) {
		
		ImageCode imageCodeInfo = (ImageCode)sessionStrategy.getAttribute(servletWebRequest, ValidateCodeConntroller.IMAGE_CODE);
		
		String imageCode = servletWebRequest.getRequest().getParameter("imageCode");
		
		if (imageCode==null) {
			throw new ValidateCodeException("验证码为空！");
		}
		if (!StringUtils.equalsIgnoreCase(imageCode, imageCodeInfo.getCode())) {
			throw new ValidateCodeException("验证码不正确！");
		}
		
		sessionStrategy.removeAttribute(servletWebRequest, ValidateCodeConntroller.IMAGE_CODE);
	}

	public AuthenticationFailureHandler getAuthenticationFailureHandler() {
		return authenticationFailureHandler;
	}

	public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
		this.authenticationFailureHandler = authenticationFailureHandler;
	}

}
