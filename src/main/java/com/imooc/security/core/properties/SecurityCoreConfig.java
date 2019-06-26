package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: SecurityCoreConfig  
 * @Description: TODO
 * @author 郝若池
 * @date 2019年6月2日 下午5:37:34
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
