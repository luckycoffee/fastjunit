package com.lucky.ut.effective;

import com.lucky.ut.effective.base.MockDatabase;
import org.h2.util.IOUtils;
import org.h2.util.StringUtils;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * functions test
 *
 * @author xiuyin.cui@luckincoffee.com
 */
public class FunctionsTest {

    @Test
    public void testExecuteQuery() throws Exception {
        DataSource dataSource = MockDatabase.context.dataSource();
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        Reader reader = IOUtils.getReader(this.getClass().getResourceAsStream("/sql/testing.sql"));
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
}
