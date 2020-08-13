package com.lucky.ut.effective.extend;

import java.lang.reflect.Method;
import java.util.Optional;

import com.lucky.ut.effective.annotation.LuckyTest;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class DiyCondition implements ExecutionCondition {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("测试对象类没有使用注解@IUnitTest");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<Method> method = context.getTestMethod();
        if(method.isPresent()) {
            LuckyTest luckyTest = method.get().getAnnotation(LuckyTest.class);
            if(luckyTest == null) {
                String reason = "忽略测试方法" + method.get() + "，因为该方法没有使用注解@LuckyTest";
                return ConditionEvaluationResult.disabled(reason);
            }
        }
        return ENABLED;
    }
}
