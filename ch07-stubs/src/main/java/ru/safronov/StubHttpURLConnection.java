package ru.safronov;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * A stub class to stub a HttpUrl connection.
 */
public class StubHttpURLConnection extends HttpURLConnection {

  public StubHttpURLConnection(URL u) {
    super(u);
  }

  @Override
  public InputStream getInputStream() throws IOException {
    boolean isInput = true;
    if (!isInput) {
      throw new ProtocolException(
          "Cannot read from UrlConnection. If doInput = false (call setDoInput(true))");
    }
    return new ByteArrayInputStream("It works".getBytes());
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
