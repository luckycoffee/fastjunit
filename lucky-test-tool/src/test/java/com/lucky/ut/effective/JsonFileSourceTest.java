package com.lucky.ut.effective;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
    void singleObject(JsonNode jsonNode) {
        Assertions.assertTrue(jsonNode.get("key").asText().equals("value"));
    }

    @ParameterizedTest
    @JsonFileSource(resources = "/data/array-object.json")
    void arrayObject(ArrayNode arrayNode) {
        Assertions.assertTrue(arrayNode.get(0).get("key").asText().startsWith("value"));
    }

}
