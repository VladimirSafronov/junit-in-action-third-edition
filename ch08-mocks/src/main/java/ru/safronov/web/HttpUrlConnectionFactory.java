package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * HTTP implementation of the connection factory
 */
public class HttpUrlConnectionFactory implements ConnectionFactory {

  private final URL url;

  public HttpUrlConnectionFactory(URL url) {
    this.url = url;
  }

  @Override
  public InputStream getData() throws IOException {
    HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
    return connection.getInputStream();
  }
}
