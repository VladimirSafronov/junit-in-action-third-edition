package ru.safronov.web;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WebClientRefactorMockTest {

  @Test
  void testGetContentOk() {
    MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
    mockConnectionFactory.setData(new ByteArrayInputStream("It works!".getBytes()));

    WebClientRefactor webClient = new WebClientRefactor();
    String result = webClient.getContent(mockConnectionFactory);
    Assertions.assertEquals("It works!", result);
  }
}
