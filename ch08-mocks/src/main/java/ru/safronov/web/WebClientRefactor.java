package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;

/**
 * That web client works with connection factory - more flexible
 */
public class WebClientRefactor {

  /**
   * In case of an exception we return null.
   */
  public String getContent(ConnectionFactory connectionFactory) {
    String content;
    StringBuilder buffer = new StringBuilder();

    try (InputStream stream = connectionFactory.getData()) {
      int count = stream.read();
      while (count != -1) {
        buffer.append(new String(Character.toChars(count)));
        count = stream.read();
      }
      content = buffer.toString();
    } catch (IOException e) {
      content = null;
    }
    return content;
  }
}
