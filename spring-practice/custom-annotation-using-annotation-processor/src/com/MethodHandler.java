package com;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodHandler implements InvocationHandler{

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Annotation an= method.getAnnotation(getTimings.class);
		Object result = null;
		if(an!=null) {
			System.out.println("Mthods invoked");
			long timeS = System.currentTimeMillis();
			result = method.invoke(proxy, args);
			System.out.println("Mthods ended");
			System.out.println("Time Required : "+ (System.currentTimeMillis()- timeS) + " ms.");
		}
		
		return result;
	}

}
