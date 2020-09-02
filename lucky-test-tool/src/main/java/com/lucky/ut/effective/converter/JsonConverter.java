package com.lucky.ut.effective.converter;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class JsonConverter implements ArgumentConverter {

    /**
     * Convert the supplied {@code source} object according to the supplied
     * {@code context}.
     *
     * @param source  the source object to convert; may be {@code null}
     * @param context the parameter context where the converted object will be
     *                used; never {@code null}
     * @return the converted object; may be {@code null} but only if the target
     * type is a reference type
     * @throws ArgumentConversionException if an error occurs during the
     *                                     conversion
     */
    @Override
    public Object convert(Object source, ParameterContext context) {
        if (!(source instanceof JsonNode)) {
            throw new ArgumentConversionException("Not a JsonObject");
        }
        JsonNode json = (JsonNode) source;
        String name = context.getParameter().getName();
        Class<?> type = context.getParameter().getType();
        if (type == String.class) {
            return json.get(name).asText();
        } else if (type == int.class) {
            return json.get(name).asInt();
        } else if (type == boolean.class) {
            return json.get(name).asBoolean();
        }
        throw new ArgumentConversionException("Can't convert to type: '" + type.getName() + "'");
    }
}
