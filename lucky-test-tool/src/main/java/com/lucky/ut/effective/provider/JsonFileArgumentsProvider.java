package com.lucky.ut.effective.provider;

import com.fasterxml.jackson.databind.JsonNode;
import com.lucky.ut.effective.annotation.JsonFileSource;
import com.lucky.ut.effective.utils.JsonUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.util.Preconditions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class JsonFileArgumentsProvider implements AnnotationConsumer<JsonFileSource>, ArgumentsProvider {

    private final BiFunction<Class<?>, String, InputStream> inputStreamProvider;

    private String[] resources;

    JsonFileArgumentsProvider() {
        this(Class::getResourceAsStream);
    }

    JsonFileArgumentsProvider(BiFunction<Class<?>, String, InputStream> inputStreamProvider) {
        this.inputStreamProvider = inputStreamProvider;
    }

    private static Stream<JsonNode> values(InputStream inputStream) {
        try {
            return Stream.of(JsonUtils.readNode(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Stream.of();
    }

    @Override
    public void accept(JsonFileSource jsonFileSource) {
        resources = jsonFileSource.resources();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        Stream<Arguments> argumentsStream = Arrays.stream(resources)
                .map(resource -> openInputStream(context, resource))
                .flatMap(JsonFileArgumentsProvider::values)
                .map(Arguments::arguments);
        return argumentsStream;
    }

    private InputStream openInputStream(ExtensionContext context, String resource) {
        Class<?> testClass = context.getRequiredTestClass();
        InputStream inputStream = inputStreamProvider.apply(testClass, resource);
        return Preconditions.notNull(inputStream,
                () -> "Classpath resource does not exist: " + resource);
    }
}
