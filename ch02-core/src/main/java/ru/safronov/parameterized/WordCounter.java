package ru.safronov.parameterized;

public class WordCounter {

  public int countWords(String str) {
    return str.split(" ").length;
  }
}
