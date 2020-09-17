package com.lucky.ut.effective.base;

import com.lucky.ut.effective.h2.H2FunctionsLoader;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

/**
 * @author zhourj
 * @date 2020/8/26 15:35
 * TODO 数据层的操作一般是依赖 mybatis ，spring 。tool 工具目前不想引入这些第三方库，具体如何封装还需要斟酌。
 */
public class MockDatabase {
    public final static String USER = "root";
    public final static String PASSWORD = "123456";
    public final static String DB_URL = "jdbc:h2:mem:test;MODE=MySql;DB_CLOSE_DELAY=-1";

    private MockDatabase() {
    }

    public static MockDatabase context = new MockDatabase();

    public DataSource dataSource() {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        //内存模式 MODE=MySql 以mysql的模式运行; DB_CLOSE_DELAY=-1 关闭延时关闭
        jdbcDataSource.setURL(DB_URL);
        jdbcDataSource.setUser(USER);
        jdbcDataSource.setPassword(PASSWORD);

        H2FunctionsLoader.loadMysqlFunctions(jdbcDataSource);
        return jdbcDataSource;
    }

}
