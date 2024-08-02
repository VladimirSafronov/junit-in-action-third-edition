package com.safronov;

public class Passenger {

  private String id;
  private String name;

  public Passenger(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "com.safronov.Passenger{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }

  public static void main(String[] args) {
    System.out.println(new Passenger("123-456", "John Smith"));
  }
}
