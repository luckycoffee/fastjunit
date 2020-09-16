package com.lucky.testng;

import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

import static org.junit.platform.engine.TestExecutionResult.failed;
import static org.junit.platform.engine.TestExecutionResult.successful;

class TestListener implements ITestListener {

  private final EngineExecutionListener platform;
  private final UniqueId classDescriptorId;

  TestListener(EngineExecutionListener platform, UniqueId classDescriptorId) {
    this.platform = platform;
    this.classDescriptorId = classDescriptorId;
  }

  private TestDescriptor convert(ITestResult result) {
    Method method = result.getMethod().getConstructorOrMethod().getMethod();
    return MethodDescriptor.newMethodDescriptor(classDescriptorId, method);
  }

  @Override
  public void onTestStart(ITestResult result) {
    platform.executionStarted(convert(result));
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    platform.executionFinished(convert(result), successful());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    platform.executionFinished(convert(result), failed(result.getThrowable()));
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    platform.executionSkipped(convert(result), "because");
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    platform.executionFinished(convert(result), successful());
  }

  @Override
  public void onStart(ITestContext context) {}

  @Override
  public void onFinish(ITestContext context) {}
}
