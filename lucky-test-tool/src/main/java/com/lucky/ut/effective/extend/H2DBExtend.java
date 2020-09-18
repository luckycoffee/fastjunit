package com.lucky.ut.effective.extend;

import com.lucky.ut.effective.h2.H2DBUtil;
import com.lucky.ut.effective.h2.annotation.H2DB;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionConfigurationException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.io.TempDir;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.ReflectionUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.function.Predicate;

import static org.junit.platform.commons.util.AnnotationUtils.findAnnotatedFields;
import static org.junit.platform.commons.util.ReflectionUtils.isPrivate;
import static org.junit.platform.commons.util.ReflectionUtils.makeAccessible;

/**
 * @Author xiuyin.cui@luckincoffee.com
 * @Date 2020/9/18 11:12
 * @Description 1.0
 */
public class H2DBExtend implements BeforeAllCallback, BeforeEachCallback, ParameterResolver {

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        injectStaticFields(context, context.getRequiredTestClass());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        context.getRequiredTestInstances().getAllInstances() //
                .forEach(instance -> injectInstanceFields(context, instance));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.isAnnotated(H2DB.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Class<?> parameterType = parameterContext.getParameter().getType();
        assertSupportedType("parameter", parameterType);
        boolean present = parameterContext.findAnnotation(H2DB.class).isPresent();
        if (!present) {
            throw new ExtensionConfigurationException("Can resolve @H2DB annotation");
        }
        return resolveH2DBUtil(parameterContext.findAnnotation(H2DB.class).get());
    }

    private void injectStaticFields(ExtensionContext context, Class<?> testClass) {
        injectFields(context, null, testClass, ReflectionUtils::isStatic);
    }

    private void injectInstanceFields(ExtensionContext context, Object instance) {
        injectFields(context, instance, instance.getClass(), ReflectionUtils::isNotStatic);
    }

    private void injectFields(ExtensionContext context, Object testInstance, Class<?> testClass,
                              Predicate<Field> predicate) {
        findAnnotatedFields(testClass, H2DB.class, predicate).forEach(field -> {
            assertValidFieldCandidate(field);
            H2DB h2DB = field.getAnnotation(H2DB.class);
            try {
                makeAccessible(field).set(testInstance, resolveH2DBUtil(h2DB));
            } catch (Throwable t) {
                ExceptionUtils.throwAsUncheckedException(t);
            }
        });
    }

    private void assertValidFieldCandidate(Field field) {
        assertSupportedType("field", field.getType());
        if (isPrivate(field)) {
            throw new ExtensionConfigurationException("@H2DB field [" + field + "] must not be private.");
        }
    }

    private void assertSupportedType(String target, Class<?> type) {
        if (type != H2DBUtil.class) {
            throw new ExtensionConfigurationException("Can only resolve @H2DB " + target + " of type "
                    + H2DBUtil.class.getName() + " but was: " + type.getName());
        }
    }


    private Object resolveH2DBUtil(H2DB h2DB) {
        String value = h2DB.value();
        H2DBUtil h2DBUtil = new H2DBUtil();
        h2DBUtil.setValue(value);
        return h2DBUtil;
    }
}
