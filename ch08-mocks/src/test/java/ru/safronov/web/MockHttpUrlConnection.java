package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MockHttpUrlConnection extends HttpURLConnection {

  private InputStream inputStream;

  public MockHttpUrlConnection() {
    super(null);
  }

  public MockHttpUrlConnection(URL url) {
    super(url);
  }

  public void setExpectedInputStream(InputStream is) {
    this.inputStream = is;
  }

  @Override
  public InputStream getInputStream() {
    return inputStream;
  }

  @Override
  public void disconnect() {

  }

  @Override
  public boolean usingProxy() {
    return false;
  }

  @Override
  public void connect() throws IOException {

  }
}
