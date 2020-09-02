package com.lucky.ut.effective.annotation;

import com.lucky.ut.effective.provider.JsonArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

/**
 * @author luckycoffee
 */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ArgumentsSource(JsonArgumentsProvider.class)
public @interface JsonSource {
    String value();
}
