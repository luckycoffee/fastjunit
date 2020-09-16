package com.lucky.testng;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;
import org.testng.internal.annotations.DisabledRetryAnalyzer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhourj
 * @date 2020/9/15 14:26
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Test
public @interface TestNg {
	String[] groups() default {};

	boolean enabled() default true;

	String[] dependsOnGroups() default {};

	String[] dependsOnMethods() default {};

	long timeOut() default 0L;

	long invocationTimeOut() default 0L;

	int invocationCount() default 1;

	int threadPoolSize() default 0;

	int successPercentage() default 100;

	String dataProvider() default "";

	Class<?> dataProviderClass() default Object.class;

	boolean alwaysRun() default false;

	String description() default "";

	Class[] expectedExceptions() default {};

	String expectedExceptionsMessageRegExp() default ".*";

	String suiteName() default "";

	String testName() default "";

	boolean singleThreaded() default false;

	Class<? extends IRetryAnalyzer> retryAnalyzer() default DisabledRetryAnalyzer.class;

	boolean skipFailedInvocations() default false;

	boolean ignoreMissingDependencies() default false;

	int priority() default 0;

	CustomAttribute[] attributes() default {};
}
