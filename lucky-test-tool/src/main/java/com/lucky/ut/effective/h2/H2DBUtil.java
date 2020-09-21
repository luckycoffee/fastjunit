package com.lucky.ut.effective.h2;

import com.lucky.ut.effective.base.MockDatabase;
import org.h2.util.IOUtils;
import org.h2.util.StringUtils;
import org.junit.Assert;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020/9/18 11:25
 * @Description tool class for h2 database execute query
 */
public class H2DBUtil {

    private String value;

    public void executeQuery() throws SQLException, IOException {
        DataSource dataSource = MockDatabase.context.dataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        Assert.assertTrue("execute parameter is empty，see annotation @H2DB", !StringUtils.isNullOrEmpty(value));
        Reader reader = IOUtils.getReader(this.getClass().getResourceAsStream(value));
        String content = IOUtils.readStringAndClose(reader, -1);
        String[] sentences = StringUtils.arraySplit(content, ';', true);
        for (String sentence : sentences) {
            if (sentence != null && !sentence.isEmpty() && !sentence.startsWith("--")) {
                ResultSet resultSet = statement.executeQuery(sentence);
                resultSet.next();
                System.out.println("Succeeded: " + sentence + " = " + resultSet.getString(1));
                resultSet.close();
            }
        }
        statement.close();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
