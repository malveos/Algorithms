package com.requestsCatcher.service.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/*
 * AbstractRequestLoggingFilter  is abstract class for CommonsRequestLoggingFilter and ServletContextRequestLoggingFilter
 * 
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private CustomRequestInterceptor customRequestInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(customRequestInterceptor).addPathPatterns("/**/interceptor/**");
	}

}
