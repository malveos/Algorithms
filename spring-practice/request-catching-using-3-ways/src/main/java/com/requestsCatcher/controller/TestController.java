package com.requestsCatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.requestsCatcher.service.Student;
import com.requestsCatcher.service.TestService;

@RestController
public class TestController {

	/**
	 * CommonsRequestLoggingFilter and ServletContextRequestLoggingFilter is also used to get log values
	 */

	@Autowired
	private TestService testService;

	// Test for aspects configuration
	@GetMapping(value = "/test/aop/{num}")
	public String getSum(@PathVariable Long num) {
		return "Sum is " + testService.getSum(num);
	}

	// Test for filter mapped for url '/user/*'. This is registered using FilterRegistration. 
	@GetMapping(value = "/user/filter/{num}")
	public String getFactorial(@PathVariable Long num) {
		return testService.getFactorial(num) +"";
	}

	/**
	 * 
	 * CustomInterceptor check uris containing 'interceptor' keyword
	 * 
	 * @param num
	 * @return
	 */
	@GetMapping("/test/interceptor/{num}")
	public String testInterceptor(@PathVariable Long num) {
		return "Interceptor tested." + testService.getFactorial(num) +"";
	}

	@PostMapping("/tests/interceptor/post/{num}")
	public String testPost(@RequestBody Student stu, @PathVariable Long num, @RequestParam("requestParam") String requestParam ) {
		return stu.toString() +" Factorial: " +testService.getFactorial(num)+ " ReqParam:" + requestParam;
	}

	@GetMapping("/coms/filter/{num}")
	public String testComs(@PathVariable Long num) {
		return "Interceptor tested." + testService.getFactorial(num) +"";
	}

	@GetMapping("/server/filter/{num}")
	public String testServerLevel(@PathVariable Long num) {
		return "Interceptor tested." + testService.getFactorial(num) +"";
	}
}
