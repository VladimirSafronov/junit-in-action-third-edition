package ru.safronov.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomStatement extends Statement {

  private final Statement base;
  private final Description description;

  public CustomStatement(Statement base, Description description) {
    this.base = base;
    this.description = description;
  }

  @Override
  public void evaluate() throws Throwable {
    try {
      System.out.println(
          this.getClass().getSimpleName() + " " + description.getMethodName() + " has started");
      base.evaluate();
    } finally {
      System.out.println(
          this.getClass().getSimpleName() + " " + description.getMethodName() + " has finished");
    }
  }
}
