package com.lucky.testng;

import javassist.*;
import javassist.bytecode.*;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.LongMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.junit.platform.commons.util.ClassFilter;
import org.junit.platform.engine.*;
import org.junit.platform.engine.support.descriptor.EngineDescriptor;
import org.testng.TestNG;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.platform.engine.support.filter.ClasspathScanningSupport.buildClassNamePredicate;


public class TestNGine implements TestEngine {

  static String ENGINE_ID = "lucky-testng-engine";

  static String ENGINE_DISPLAY_NAME = "TestNG TestEngine SPIKE";

  @Override
  public String getId() {
    return ENGINE_ID;
  }

  @Override
  public Optional<String> getGroupId() {
    return Optional.of("com.lucky");
  }

  @Override
  public Optional<String> getArtifactId() {
    return Optional.of("lucky-testng-engine");
  }

  @Override
  public Optional<String> getVersion() {
    return Optional.of("DEVELOPMENT");
  }

  @Override
  public TestDescriptor discover(EngineDiscoveryRequest request, UniqueId uniqueId) {
    EngineDescriptor engine = new EngineDescriptor(uniqueId, ENGINE_DISPLAY_NAME);
    // inspect "request" selectors and filters passed by the user
    // find TestNG-based test containers (classes) and tests (methods)
    //   wrap each in a new TestDescriptor
    //   add the created descriptor in a tree, below the "engine" descriptor
    ClassFilter filter =
        ClassFilter.of(buildClassNamePredicate(request), ClassDescriptor::isCandidate);
    DiscoveryHelper helper = new DiscoveryHelper(request, filter);
    helper.discover(engine, this::handle);
    return engine;
  }

  private void handle(EngineDescriptor engine, Class<?> candidate) {
    ClassDescriptor container =
        ClassDescriptor.newContainerDescriptor(engine.getUniqueId(), candidate);
    /*Arrays.stream(candidate.getMethods())
        .filter(method -> method.isAnnotationPresent(Test.class) || method.isAnnotationPresent(TestNg.class))
        //.map(method -> MethodDescriptor.newMethodDescriptor(container.getUniqueId(), method))
        .forEach(method ->{
          Test test = method.getAnnotation(Test.class);
          TestNg luckyNg  = method.getAnnotation(TestNg.class);
          if(luckyNg != null && test ==null){
            try {
              //generateTestAnnotation(method);
            } catch (Exception e) {
              e.printStackTrace();
            }
            test = method.getAnnotation(Test.class);
          }
          //container.addChild(method);
        });*/

    Arrays.stream(candidate.getMethods())
      .filter(method -> method.isAnnotationPresent(Test.class))
      .map(method -> MethodDescriptor.newMethodDescriptor(container.getUniqueId(), method))
      .forEach(method -> container.addChild(method));

    if (container.getChildren().isEmpty()) {
      return;
    }
    engine.addChild(container);
  }

  /**
   * 给方法动态织入 NG 的 test 注解
   * @param method
   */
  private void generateTestAnnotation(Method method) throws Exception{
    TestNg testNg = method.getAnnotation(TestNg.class);
    if(testNg == null){
        return;
    }

    ClassPool pool = ClassPool.getDefault();

    //获取需要修改的类
    CtClass cc = pool.get(method.getDeclaringClass().getName());
    ClassFile ccFile = cc.getClassFile();
    ConstPool constpool = ccFile.getConstPool();

    // 获取对应方法
    CtMethod ctMethod = cc.getDeclaredMethod(method.getName());

    //获取注解
    Annotation annotation = new Annotation("org.testng.annotations.Test",constpool);
    //annotation.addMemberValue("group",new ArrayMemberValue(testNg.groups()));

    AnnotationsAttribute attribute = new AnnotationsAttribute(constpool, AnnotationsAttribute.visibleTag);
    List<AttributeInfo>  attributeInfoList = ctMethod.getMethodInfo().getAttributes();
    attribute.setAnnotation(annotation);
    attributeInfoList.add(attribute);
    /*
    ctMethod.getMethodInfo().addAttribute(attribute);*/
    cc.toClass();
    Test test = method.getAnnotation(Test.class);


    //Method method1 = Method.class.getConstructor().setAccessible(true);

    Class<Method> methodClass = (Class<Method>)Class.forName("java.lang.reflect.Method");
    methodClass.getConstructor(
            Class.class,
            String.class,
            Class[].class,
            Class.class,
            Class[].class,
            int.class,
            int.class,
            String.class,
            byte[].class,
            byte[].class,
            byte[].class,
            Object.class
    );

    java.lang.annotation.Annotation[] annotations = method.getDeclaredAnnotations();
  }

  @Override
  public void execute(ExecutionRequest request) {
    TestDescriptor engine = request.getRootTestDescriptor();
    EngineExecutionListener engineListener = request.getEngineExecutionListener();
    engineListener.executionStarted(engine);

    for (TestDescriptor classDescriptor : engine.getChildren()) {
      engineListener.executionStarted(classDescriptor);

      UniqueId classId = classDescriptor.getUniqueId();
      Class<?>[] testClasses = {((ClassDescriptor) classDescriptor).getTestClass()};

      TestNG testNG = new TestNG(false);
      testNG.addListener(new TestListener(engineListener, classId));
      testNG.setTestClasses(testClasses);
      testNG.run();

      engineListener.executionFinished(classDescriptor, TestExecutionResult.successful());
    }
    engineListener.executionFinished(engine, TestExecutionResult.successful());
  }
}
