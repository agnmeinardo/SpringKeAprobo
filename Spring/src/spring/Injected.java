package spring;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
public @interface Injected
{
	int count() default 1;
	String implementation() default "";
	boolean singleton() default false; // Dudoso
}