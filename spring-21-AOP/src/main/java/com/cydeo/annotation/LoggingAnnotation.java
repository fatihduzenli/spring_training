package com.cydeo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})  // this means I can put my annotation on top of my methods (I put limitations)
@Retention(RetentionPolicy.RUNTIME)  // the application will read this annotation during runtime
public @interface LoggingAnnotation {
}
