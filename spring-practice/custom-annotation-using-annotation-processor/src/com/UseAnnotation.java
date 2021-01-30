package com;

import java.lang.reflect.Proxy;
import java.time.LocalTime;

public class UseAnnotation {	
	
	@getTimings
	public void say() {
		System.out.println("Hello");
		for(int i=1;i<1//09090098
				;i++) { 
			//LocalTime lt = 
			LocalTime.now();
			//System.out.println(lt);
		}
	}
	
	public static void main(String [] args) throws Exception {
		UseAnnotation ua = new UseAnnotation();
		ua.say();
		
		UseAnnotation proxyInstance = (UseAnnotation) Proxy.newProxyInstance(
				UseAnnotation.class.getClassLoader(), 
				  new Class[] { UseAnnotation.class }, 
				  new MethodHandler());
		
		proxyInstance.say();
	}	
}
