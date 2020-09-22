package com.lucky.ut.effective;

import com.lucky.ut.effective.h2.H2DBUtil;
import com.lucky.ut.effective.h2.annotation.H2DB;
import org.junit.jupiter.api.Test;

/**
 * functions test
 *
 * @author xiuyin.cui@luckincoffee.com
 */
public class FunctionsTest {

    @H2DB(value = "/sql/testing.sql")
    private H2DBUtil h2DBUtil;

    @Test
    public void testExecuteQuery() throws Exception {
        h2DBUtil.executeQuery();
    }
}