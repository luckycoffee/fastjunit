package com.lucky.ut.effective.annotation;

import com.lucky.ut.effective.provider.JsonArgumentsProvider;
import org.apiguardian.api.API;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

import static org.apiguardian.api.API.Status.EXPERIMENTAL;

/**
 * @author
 * @Description:
 * @date 2020/8/26 19:55
 * @since 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = EXPERIMENTAL, since = "5.0")
@ArgumentsSource(JsonArgumentsProvider.class)
public @interface JsonResource {
    String[] value();
}
