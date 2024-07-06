package ru.safronov.extension;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CustomExtension implements BeforeEachCallback, AfterEachCallback {

  @Override
  public void afterEach(ExtensionContext context) throws Exception {
    System.out.println(
        this.getClass().getSimpleName() + " " + context.getDisplayName() + " has finished");
  }

  @Override
  public void beforeEach(ExtensionContext context) throws Exception {
    System.out.println(
        this.getClass().getSimpleName() + " " + context.getDisplayName() + " has started");
  }
}
