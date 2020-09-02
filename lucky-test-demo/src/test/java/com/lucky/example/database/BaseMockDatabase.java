package com.lucky.example.database;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: cheng.zhang@luckincoffee.com
 * @Date: 2020/2/22 16:27
 * @Description:
 */
@ActiveProfiles("junit-test")
@Import({MockDatabaseConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("com.lucky.example.infrastructure.*.mapper")
public abstract class BaseMockDatabase {

}
