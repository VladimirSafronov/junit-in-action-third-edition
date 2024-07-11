package ru.safronov;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A test case that tests the WebClient class by stubbing the HTTP connection
 */
public class SecondWebClientTest {

  @BeforeAll
  static void setUp() {
    URL.setURLStreamHandlerFactory(new StubStreamHandlerFactory());
  }

  private static class StubStreamHandlerFactory implements URLStreamHandlerFactory {

    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
      return new StubHttpURLStreamHandler();
    }
  }

  private static class StubHttpURLStreamHandler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL u) throws IOException {
      return new StubHttpURLConnection(u);
    }
  }

  @Test
  void testGetContentOk() throws MalformedURLException {
    WebClient client = new WebClient();
    String content = client.getConnect(new URL("http://localhost"));
    Assertions.assertEquals("It works", content);
  }
}
