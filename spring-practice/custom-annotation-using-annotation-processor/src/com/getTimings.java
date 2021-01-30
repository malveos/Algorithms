package com;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented    						//It must be documented
@Target(ElementType.METHOD) 		//It should be provided to method (Ex: TYPE-class. FIELD- attribute)
@Inherited							//It will automatically get inherited
@Retention(RetentionPolicy.RUNTIME) //It is availability

public @interface getTimings {
	String name() default "nothing";
	int dt() default 8;
}
