package com.lucky.example.database;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @Author: cheng.zhang@luckincoffee.com
 * @Date: 2020/2/22 16:27
 * @Description:
 */
@ActiveProfiles("junit-test")
@Import({MockDatabaseConfig.class})
@ExtendWith(SpringExtension.class) //导入spring测试框架
@ComponentScan("com.lucky.example.infrastructure.*.mapper")
public abstract class BaseMockDatabase {

}
