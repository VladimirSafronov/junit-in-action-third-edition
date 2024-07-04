package ru.safronov.lifecycle;

public class ResourceForTests {

  private final String resourceName;

  public ResourceForTests(String resourceName) {
    this.resourceName = resourceName;
    System.out.println(
        resourceName + " from class " + getClass().getSimpleName() + " is initializing");
  }

  public void close() {
    System.out.println(resourceName + " from class " + getClass().getSimpleName() + " is closing");
  }
}
