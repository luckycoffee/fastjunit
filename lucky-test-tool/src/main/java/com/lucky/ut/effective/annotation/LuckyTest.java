package com.lucky.ut.effective.annotation;

import java.lang.annotation.*;
import org.junit.jupiter.api.Test;

/**
 * @author zhourj
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Test
public @interface LuckyTest {

    /**
     * description of the test-method
     * @return
     */
    String description() default "";

    /**
     * 回滚
     * @return
     */
    boolean rollback() default true;
}
