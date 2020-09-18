package com.lucky.ut.effective.h2.annotation;

import com.lucky.ut.effective.extend.LuckyExtend;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.apiguardian.api.API.Status.STABLE;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020/9/18 9:45
 * @Description provide file parameters for H2 DataSource to execute query
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@API(status = STABLE, since = "5.0")
public @interface H2DB {

    /**
     * SQL file parameters to be executed，etc："/sql/testing.sql"
     */
    String value();
}
