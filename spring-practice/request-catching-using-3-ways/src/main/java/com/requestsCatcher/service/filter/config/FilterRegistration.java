package com.requestsCatcher.service.filter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;

@Configuration
public class FilterRegistration {

	@Autowired
	private UsersRequestFilter filter;

	@Bean
	public FilterRegistrationBean<UsersRequestFilter> someFilterRegistration() {

		FilterRegistrationBean<UsersRequestFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(filter);
		registration.addUrlPatterns("/user/*");
		registration.addInitParameter("test", "testValue"); // used to override parameter
		registration.setName("User Filter");
		registration.setOrder(3);
		return registration;
	}

	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);

		return loggingFilter;
	}

	@Bean
	public FilterRegistrationBean<ServletContextRequestLoggingFilter> servletContextLoggingFilter() {
		ServletContextRequestLoggingFilter loggingFilter = new ServletContextRequestLoggingFilter();
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setIncludeQueryString(true);
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);

		FilterRegistrationBean<ServletContextRequestLoggingFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(loggingFilter);
		registration.addUrlPatterns("/server/*");
		registration.setName("Server");
		registration.setOrder(1);
		return registration;
		
	}
}
