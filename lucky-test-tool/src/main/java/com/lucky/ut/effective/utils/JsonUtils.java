package com.lucky.ut.effective.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020-08-18 19:58
 * @Description Json工具类（采用 jackson 解析）
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> T readValue(String jsonStr, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonStr, clazz);
    }

    public static <T> T readValue(Reader reader, Class<T> clazz) throws IOException {
        return objectMapper.readValue(reader, clazz);
    }

    public static String writeJsonStr(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public static String writePrettyJsonStr(Object obj) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    public static void writeJsonStream(OutputStream out, Object obj) throws IOException {
        objectMapper.writeValue(out, obj);
    }

    public static <T> List<T> readListValue(String jsonStr, Class<T> clazz) throws IOException {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);
        return objectMapper.readValue(jsonStr, javaType);
    }

    public static ArrayNode readArray(String jsonStr) throws IOException {
        JsonNode node = objectMapper.readTree(jsonStr);
        if (node.isArray())
            return (ArrayNode) node;
        return null;
    }

    public static JsonNode readNode(String jsonStr) throws IOException {
        return objectMapper.readTree(jsonStr);
    }

    public static JsonNode readNode(Reader reader) throws IOException {
        return objectMapper.readTree(reader);
    }

    public static JsonNode readNode(InputStream in) throws IOException {
        return objectMapper.readTree(in);
    }

}
