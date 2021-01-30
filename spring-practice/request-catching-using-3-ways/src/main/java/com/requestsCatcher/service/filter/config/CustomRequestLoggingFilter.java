package com.requestsCatcher.service.filter.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class CustomRequestLoggingFilter extends CommonsRequestLoggingFilter {

	private static final Logger logger = LoggerFactory.getLogger(CustomRequestLoggingFilter.class);
	private Long startTime = 0L;

	@Override
	protected void beforeRequest(HttpServletRequest httpRequest, String msg) {
		StringBuilder message = new StringBuilder("Before CustomRequestLoggingFilter:\n ");
		message.append("	Method: "+ httpRequest.getMethod());
		message.append("	URI: "+httpRequest.getRequestURI());
		message.append("	Address: "+ httpRequest.getRemoteAddr());
		message.append("	User: " + httpRequest.getUserPrincipal().getName());
		logger.info(message + msg);
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		logger.info("After CustomRequestLoggingFilter: " + request.getContextPath() + " :"+message);
		logger.info("CustomFilter : Time for request precessing - {} ms.", System.currentTimeMillis() - startTime);
	}
}
