package com.lucky.ut.effective.annotation;

import java.lang.annotation.*;

/**
 * @author zhourj
 * @date 2020/9/18 12:48
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MockIgnore {
}
