package ru.safronov.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * A test-case to test the WebClient class by means of the custom mock object
 */
public class WebClientMockTest {

  @Test
  void testGetContentOk() throws MalformedURLException {
    MockHttpUrlConnection mockConnection = new MockHttpUrlConnection();
    mockConnection.setExpectedInputStream(new ByteArrayInputStream("It works!".getBytes()));

    TestableWebClient webClient = new TestableWebClient();
    webClient.setConnection(mockConnection);

    String result = webClient.getConnect(new URL("http://localhost/justmock"));

    Assertions.assertEquals("It works!", result);
  }

  /**
   * An inner, private class that extends WebClient and allows us to override the
   * createHttpURLConnection method.
   */
  private static class TestableWebClient extends WebClient {

    private HttpURLConnection connection;

    public void setConnection(HttpURLConnection connection) {
      this.connection = connection;
    }

    @Override
    protected HttpURLConnection createHttpUrlConnection(URL url) throws IOException {
      return this.connection;
    }
  }
}
