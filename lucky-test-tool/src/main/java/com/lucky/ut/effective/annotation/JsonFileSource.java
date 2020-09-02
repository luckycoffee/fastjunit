package com.lucky.ut.effective.annotation;

import com.lucky.ut.effective.provider.JsonFileArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

/**
 * @author luckycoffee
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ArgumentsSource(JsonFileArgumentsProvider.class)
public @interface JsonFileSource {

    String[] resources();
}
