package ru.safronov.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Another web client test with custom InputStream
 */
public class WebClientCustomInputStreamTest {

  @Test
  void testGetContentOk() {
    MockConnectionFactory connectionFactory = new MockConnectionFactory();
    MockInputStream customInputStream = new MockInputStream();
    customInputStream.setBuffer("It works!");
    connectionFactory.setData(customInputStream);

    WebClientRefactor webClient = new WebClientRefactor();
    String result = webClient.getContent(connectionFactory);

    Assertions.assertEquals("It works!", result);
    customInputStream.verify();
  }
}
