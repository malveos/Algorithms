package com.requestsCatcher.service.filter.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AllRequestsFilterConfig implements Filter {

	/**
	 * WE are using cors filter to support request for different types of browser, versions.
	 * It only intercept requests.
	 */
	private static final Logger logger = LoggerFactory.getLogger(AllRequestsFilterConfig.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse myResponse = (HttpServletResponse) response;

		Long startTime = System.currentTimeMillis();
		if (httpRequest.getRequestURL().toString().contains("/filter")) {
			StringBuilder message = new StringBuilder("Filter containing 'filter' in uri:\n ");
			message.append("	Method: "+ httpRequest.getMethod());
			message.append("	URI: "+httpRequest.getRequestURI());
			message.append("	Address: "+ httpRequest.getRemoteAddr());
			if(null != httpRequest.getUserPrincipal()) {
				message.append("	User: " + httpRequest.getUserPrincipal().getName());
			}
			//message.append("	Payload: "+ httpRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
			logger.info(message.toString());
		}
		chain.doFilter(httpRequest, myResponse);
		logger.info("Filter: Time taken is {} ms.", (System.currentTimeMillis()- startTime));
		System.out.println("---------------------------------------------------------------------------------------------");
		return;
	}

}
