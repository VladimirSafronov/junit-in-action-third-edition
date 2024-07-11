package ru.safronov;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A sample web-client class that opens HTTP connection and reads the response from it
 */
public class WebClient {

  public String getConnect(URL url) {
    StringBuilder content = new StringBuilder();
    try {
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoInput(true);
      InputStream is = connection.getInputStream();
      byte[] buffer = new byte[2048];
      int count = is.read(buffer);
      while (count != -1) {
        content.append(new String(buffer, 0, count));
        count = is.read(buffer);
      }
    } catch (IOException exception) {
      throw new RuntimeException(exception.getMessage());
    }
    return content.toString();
  }
}
