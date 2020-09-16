package com.lucky.ut.effective.extend;

import com.lucky.testng.TestNg;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.Annotation;
import org.junit.jupiter.api.extension.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

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
        /*Optional<Class<?>>  testClassOptional = extensionContext.getTestClass();
        testClassOptional.ifPresent(testClass -> {
            try {
                findNgClass(testClass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
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

    public void findNgClass(Class<?> testClass) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(testClass.getName());
        CtMethod[] ctMethodList = cc.getDeclaredMethods();
        for (CtMethod method:ctMethodList) {
            Object testNg = method.getAnnotation(TestNg.class);
            if(testNg != null){
                generateTestAnnotation(method,cc);
            }
        }
    }

    private void generateTestAnnotation(CtMethod method,CtClass cc) throws NotFoundException, CannotCompileException {
        ClassFile ccFile = cc.getClassFile();
        ConstPool constpool = ccFile.getConstPool();

        //获取注解
        Annotation annotation = new Annotation("org.testng.annotations.Test",constpool);

        AnnotationsAttribute attribute = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
        List<AttributeInfo> attributeInfoList = method.getMethodInfo().getAttributes();
        attribute.setAnnotation(annotation);
        attributeInfoList.add(attribute);
    }

}
