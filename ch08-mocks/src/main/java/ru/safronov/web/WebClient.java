package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A web client implementation that retrieves a content from a URL
 */
public class WebClient {

  /**
   * Method that retrieve content from a URL
   */
  public String getConnect(URL url) {
    StringBuilder content = new StringBuilder();
    try {
      HttpURLConnection connection = createHttpUrlConnection(url);
      InputStream is = connection.getInputStream();

      int count = is.read();
      while (count != -1) {
        content.append(new String(Character.toChars(count)));
        count = is.read();
      }
    } catch (IOException exception) {
      return null;
    }
    return content.toString();
  }

  /**
   * Creates a http connection
   */
  protected HttpURLConnection createHttpUrlConnection(URL url) throws IOException {
    return (HttpURLConnection) url.openConnection();
  }
}
