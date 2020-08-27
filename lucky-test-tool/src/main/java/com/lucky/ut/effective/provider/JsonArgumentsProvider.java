package com.lucky.ut.effective.provider;

import com.lucky.ut.effective.annotation.JsonSource;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.Preconditions;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

/**
 * @author
 * @Description:
 * @date 2020/8/27 17:28
 * @since 1.0
 */
public class JsonArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<JsonSource> {

    private JsonSource annotation;

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        AtomicLong index = new AtomicLong(0);
        // @formatter:off
        return Arrays.stream(this.annotation.value())
                .map(line -> parseLine(index.getAndIncrement(), line))
                .map(Arguments::of);
        // @formatter:on
    }

    @Override
    public void accept(JsonSource annotation) {
        this.annotation = annotation;
    }

    /***
     * 待补充开发
     * @param index
     * @param line
     * @return
     */
    private String[] parseLine(long index, String line) {
        //瞎写的
        String[] parsedLine = {line, line};
        try {
            //
        }
        catch (Throwable throwable) {
            throw new PreconditionViolationException("");
//            handleCsvException(throwable, this.annotation);
        }
        Preconditions.notNull(parsedLine, () -> "Line at index " + index + " contains invalid CSV: \"" + line + "\"");
        return parsedLine;
    }
}
