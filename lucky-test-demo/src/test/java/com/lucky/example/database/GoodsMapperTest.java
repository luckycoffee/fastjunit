package com.lucky.example.database;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author zhourj
 * @date 2020/8/26 17:12
 */
@Profile("junit-test")
@Component
@Sql({"classpath:sql/pipeline.sql"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoodsMapperTest {

}
