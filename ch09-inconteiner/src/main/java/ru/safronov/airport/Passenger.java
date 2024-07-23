package ru.safronov.airport;

public class Passenger {

  private final String identifier;
  private final String name;

  public Passenger(String identifier, String name) {
    this.identifier = identifier;
    this.name = name;
  }

  public String getIdentifier() {
    return identifier;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Passenger{" +
        "identifier='" + identifier + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
