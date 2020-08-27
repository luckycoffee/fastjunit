package com.lucky.ut.effective;

import com.lucky.ut.effective.annotation.JsonSource;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * @author
 * @Description:
 * @date 2020/8/27 18:31
 * @since 1.0
 */
public class JsonSourceTest {

    @ParameterizedTest
    @JsonSource(value = "[{\"this is json str\"}]")
    public void test(String json){
        System.out.println(json);
    }

}
