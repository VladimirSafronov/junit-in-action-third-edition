package ru.safronov.assumptions.environment;

public class TestEnvironment {

  private final JavaSpecification javaSpecification;
  private final OperationSystem operationSystem;

  public TestEnvironment(JavaSpecification javaSpecification, OperationSystem operationSystem) {
    this.javaSpecification = javaSpecification;
    this.operationSystem = operationSystem;
  }

  public boolean isMac() {
    return operationSystem.getName().contains("Mac OS X");
  }

  public boolean is86_64Architecture() {
    return operationSystem.getArchitecture().equals("x86_64");
  }

  public String getJavaVersion() {
    return javaSpecification.getVersion();
  }
}
