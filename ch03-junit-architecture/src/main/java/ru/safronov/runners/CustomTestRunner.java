package ru.safronov.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

public class CustomTestRunner extends Runner {

  private final Class<?> testedClass;

  public CustomTestRunner(Class<?> testedClass) {
    this.testedClass = testedClass;
  }

  @Override
  public Description getDescription() {
    return Description.createTestDescription(testedClass,
        this.getClass().getSimpleName() + " description");
  }

  @Override
  public void run(RunNotifier notifier) {
    System.out.println(
        "Running tests with " + this.getClass().getSimpleName() + ": " + testedClass);

    try {
      Object testObject = testedClass.newInstance();
      for (Method method : testedClass.getMethods()) {
        if (method.isAnnotationPresent(Test.class)) {
          notifier.fireTestStarted(
              Description.createTestDescription(testedClass, method.getName()));

          method.invoke(testObject);

          notifier.fireTestFinished(
              Description.createTestDescription(testedClass, method.getName()));
        }
      }
    } catch (InstantiationException | InvocationTargetException | IllegalAccessException ex) {
      throw new RuntimeException(ex);
    }
  }
}
