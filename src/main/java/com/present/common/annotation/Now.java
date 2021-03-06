package com.present.common.annotation;

import java.lang.annotation.*;

@Documented  
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.FIELD)  
public @interface Now
{
	String type() default "C";
}
