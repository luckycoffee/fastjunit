package com.lucky.testng;

import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.AbstractTestDescriptor;
import org.junit.platform.engine.support.descriptor.MethodSource;

import java.lang.reflect.Method;

public class MethodDescriptor extends AbstractTestDescriptor {

  static MethodDescriptor  newMethodDescriptor(UniqueId container, Method method) {
    UniqueId id = container.append("testng-method", method.getName());
    return new MethodDescriptor(id, method);
  }

  private final Method method;

  private MethodDescriptor(UniqueId uniqueId, Method method) {
    super(uniqueId, method.getName(), MethodSource.from(method));
    this.method = method;
  }

  @Override
  public Type getType() {
    return Type.TEST;
  }

  public Method getMethod() {
    return method;
  }
}
