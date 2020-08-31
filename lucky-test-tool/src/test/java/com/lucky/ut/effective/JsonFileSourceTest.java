package com.lucky.ut.effective;

import com.lucky.ut.effective.annotation.JsonFileSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

import javax.json.JsonObject;

/**
 * @author
 * @Description:
 * @date 2020/8/31 10:39
 * @since 1.0
 */
public class JsonFileSourceTest {

    @ParameterizedTest
    @JsonFileSource(resources = "/data/single-object.json")
    void singleObject(JsonObject object) {
        Assertions.assertTrue(object.getString("key").equals("value"));
    }

}
