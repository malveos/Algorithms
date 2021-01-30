package com.requestsCatcher.service.aop.config;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Configuration
public class AspectConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(AspectConfiguration.class);

	@After("com.requestsCatcher.service.aop.config.JoinPointConfig.getJoinPoint()")
	public void doAfter(JoinPoint joinPoint) {
		logger.debug("After execution of {} with arguments as : {}", joinPoint, joinPoint.getArgs());

	}

	@Around("com.requestsCatcher.service.aop.config.JoinPointConfig.getJoinPoint()")
	public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();

		logger.info("\nMethod:{}, URI:{} from Address:{}",
			    request.getMethod(),
			    request.getRequestURI(),
			    request.getRemoteAddr());
		Object[] signatureArgs = joinPoint.getArgs();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		StringBuilder message = new StringBuilder();
		try {
			for (int i = 0; i < signatureArgs.length; i++) {
				if (signatureArgs[i] != null) {
					String argsValue = mapper.writeValueAsString(signatureArgs[i]);
					message.append("\nArgument->").append(i + 1).append(":").append(argsValue);
				}
			}
			logger.info(message.toString());
		} catch (JsonProcessingException e) {
			logger.error("Error occured while parsing json");
		}

		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("{} AfterReturning with value {}", joinPoint.toShortString(), result);
		logger.info("Aspect:Time taken by {} is {} ms.", joinPoint, timeTaken);

		return result;
	}

	@AfterThrowing(value = "com.requestsCatcher.service.aop.config.JoinPointConfig.getJoinPoint()", throwing = "error")
	public void afterThrowingAdvice(JoinPoint joinPoint, Throwable error) {
		logger.error("Method Signature: {}", joinPoint.getSignature());
		logger.error("Exception: {}", error);
	}
}
