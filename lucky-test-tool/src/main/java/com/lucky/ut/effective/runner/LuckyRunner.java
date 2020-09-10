package com.lucky.ut.effective.runner;

import com.lucky.ut.effective.extend.LuckyExtend;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.*;

/**
 * @author zhourj
 * @date 2020/8/13 15:45
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith({LuckyExtend.class})
public @interface LuckyRunner {
}
