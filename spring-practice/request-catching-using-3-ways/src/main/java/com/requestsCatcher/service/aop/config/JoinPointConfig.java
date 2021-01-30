package com.requestsCatcher.service.aop.config;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JoinPointConfig {

	//@Pointcut("execution(* com.requestsCatcher.service.aop.*.*(..))")
	@Pointcut("execution(* com.requestsCatcher.service.TestService.getSum(Long))")
	public void getJoinPoint() {

	}

	
	/**
	 * within : all methods are considered within mentioned package
	 * target : 
	 * 		class A implemets B
	 * 		proxy object is created for A.
	 * this : 
	 *		class A implemets B
	 *		proxy object is created for B
	 * @annotation : Matches anonotation mentioned
	 * @args : matches if args is of mentioned type. 
	 *
	 */
}
