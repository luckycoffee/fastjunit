package com.lucky.ut.effective;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lucky.ut.effective.annotation.JsonSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

/**
 * @author
 * @Description:
 * @date 2020/8/27 18:31
 * @since 1.0
 */
public class JsonSourceTest {

    @ParameterizedTest
    @JsonSource("{\"key\":\"value\"}")
    void singleObject(JsonNode jsonNode) {
        Assertions.assertTrue(jsonNode.get("key").asText().equals("value"));
    }

    /**
     * When passed <code>[{"key":"value1"},{"key","value2"}]</code>, is
     * executed once per element of the array
     *
     * @param arrayNode the parsed JsonObject array element
     */
    @ParameterizedTest
    @JsonSource("[{\"key\":\"value1\"},{\"key\":\"value2\"}]")
    void arrayOfObjects(ArrayNode arrayNode) {
        Assertions.assertTrue(arrayNode.get(0).get("key").asText().startsWith("value"));
    }

}
