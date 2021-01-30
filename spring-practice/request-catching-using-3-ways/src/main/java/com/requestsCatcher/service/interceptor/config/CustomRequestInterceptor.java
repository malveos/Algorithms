package com.requestsCatcher.service.interceptor.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * HandlerInterceptorAdapter is abstract adapter class 
 * HandlerInterceptor is interface 
 * 
 * Above are ways to write customInterceptor 
 * @author omalve
 *
 */
@Component
public class CustomRequestInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(CustomRequestInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse response, Object handler) throws IOException {
		logger.info("Custom Interceptor - in prehandle.");
		StringBuilder message = new StringBuilder("Interceptor Request:\n ");
		message.append("	Method: "+ httpRequest.getMethod());
		message.append("	URI: "+httpRequest.getRequestURI());
		message.append("	Address: "+ httpRequest.getRemoteAddr());
		if(null != httpRequest.getUserPrincipal()) {
			message.append("	User: " + httpRequest.getUserPrincipal().getName());
		}
//		message.append("	Payload: "+ httpRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
		httpRequest.setAttribute("startTime", System.currentTimeMillis());
		return true;
		// If returned false, request will not be processed
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("Custom Interceptor - after completion");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {
		logger.info("Custom Interceptor - Posthandle but view is not rendered.");
		Long startTime = (Long) request.getAttribute("startTime");
		logger.info("Interceptor: Time for request precessing - {} ms.", System.currentTimeMillis() - startTime);
	}
}
