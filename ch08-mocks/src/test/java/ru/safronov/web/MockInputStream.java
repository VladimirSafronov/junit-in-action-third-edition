package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;

/**
 * A custom mock InputStream
 */
public class MockInputStream extends InputStream {

  /**
   * Buffer to read in
   */
  private String buffer;

  /**
   * Current position in the stream
   */
  private int position = 0;

  /**
   * How many times the close method was called
   */
  private int closeCount = 0;

  public void setBuffer(String buffer) {
    this.buffer = buffer;
  }

  /**
   * Read from the stream
   */
  @Override
  public int read() throws IOException {
    if (position == buffer.length()) {
      return -1;
    }
    return this.buffer.charAt(position++);
  }

  /**
   * Close the stream
   */
  public void close() throws IOException {
    closeCount++;
    super.close();
  }

  /**
   * Verify how many times the close() method was called
   */
  public void verify() {
    if (closeCount != 1) {
      throw new AssertionError("close() should have been called once only");
    }
  }
}
