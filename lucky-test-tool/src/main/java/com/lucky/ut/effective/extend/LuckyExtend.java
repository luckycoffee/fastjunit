package com.lucky.ut.effective.extend;

import org.junit.jupiter.api.extension.*;

/**
 * @author zhourj
 * @date 2020/9/10 11:06
 *
 */
public class LuckyExtend implements ExecutionCondition, BeforeAllCallback, AfterAllCallback {
    private static final ConditionEvaluationResult ENABLED = ConditionEvaluationResult.enabled("测试对象类没有使用注解@IUnitTest");

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        // 瑞幸单测扩展入口
    }

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        // 瑞幸单测扩展入口
        return ENABLED;
    }


    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        // 瑞幸单测扩展入口
    }
}
