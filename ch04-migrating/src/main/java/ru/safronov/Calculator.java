package ru.safronov;

public class Calculator {

  public double add(double num1, double num2) {
    return num1 + num2;
  }

  public double sqrt(double num) {
    if (num < 0) {
      throw new IllegalArgumentException("Cannot extract the square root of a negative value");
    }
    return Math.sqrt(num);
  }

  public double divide(double num1, double num2) {
    if (num2 == 0) {
      throw new ArithmeticException("You can't divide by zero");
    }
    return num1 / num2;
  }
}
