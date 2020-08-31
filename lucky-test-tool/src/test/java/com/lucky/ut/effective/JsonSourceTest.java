package com.lucky.ut.effective;

import com.lucky.ut.effective.annotation.JsonSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.json.JsonObject;

/**
 * @author
 * @Description:
 * @date 2020/8/27 18:31
 * @since 1.0
 */
public class JsonSourceTest {

    @ParameterizedTest
    @JsonSource("{\"key\":\"value\"}")
    void singleObject(JsonObject object) {
        Assertions.assertTrue(object.getString("key").equals("value"));
    }

    /**
     * When passed <code>[{"key":"value1"},{"key","value2"}]</code>, is
     * executed once per element of the array
     * @param object the parsed JsonObject array element
     */
    @ParameterizedTest
    @JsonSource("[{\"key\":\"value1\"},{\"key\":\"value2\"}]")
    void arrayOfObjects(JsonObject object) {
        Assertions.assertTrue(object.getString("key").startsWith("value"));
    }

}
