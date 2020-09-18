package com.lucky.ut.effective;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.lucky.ut.effective.annotation.JsonFileSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.IOException;
import java.nio.file.Path;

/**
 * @author
 * @Description:
 * @date 2020/8/31 10:39
 * @since 1.0
 */
public class JsonFileSourceTest {
    @TempDir
    static Path sharedTempDir;

    @Test
    void writeItemsToFile() throws IOException {
        Path file = sharedTempDir.resolve("test.txt");
    }

    @ParameterizedTest
    @JsonFileSource(resources = "/data/single-object.json")
    void singleObject(JsonNode jsonNode) {
        Assertions.assertTrue(jsonNode.get("key").asText().equals("value"));
    }

    @ParameterizedTest
    @JsonFileSource(resources = "/data/array-object.json")
    @Execution(ExecutionMode.CONCURRENT)
    void arrayObject(ArrayNode arrayNode) {
        Assertions.assertTrue(arrayNode.get(0).get("key").asText().startsWith("value"));
    }

}
