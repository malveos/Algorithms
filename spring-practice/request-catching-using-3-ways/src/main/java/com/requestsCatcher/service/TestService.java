package com.requestsCatcher.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	//com.requestsCatcher.service.TestService.getSum(Long)
	public Long getSum(Long num) {
		Long sum = 0L;
		for (Long i = 0L; i < num; i++) {
			sum += i;
		}
		return sum;
	}

	Long factorial(Long n) {
		if (n == 0)
			return 1L;
		else
			return (n * factorial(n - 1));
	}

	public Long getFactorial(Long n) {
		return factorial(n);
	}
}
