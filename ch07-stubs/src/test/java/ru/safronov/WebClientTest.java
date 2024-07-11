package ru.safronov;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

/**
 * A sample test case that using Jetty to demonstrates how to stub an HTTP server
 */
public class WebClientTest {

  private final WebClient webClient = new WebClient();

  @BeforeAll
  static void setUp() throws Exception {
    Server server = new Server(8082);

    Context contentOkContext = new Context(server, "/testGetContentOk");
    contentOkContext.setHandler(new TestGetContentOkHandler());

    server.setStopAtShutdown(true);
    server.start();
  }

  @Test
  void testGetContentOk() throws MalformedURLException {
    String content = webClient.getConnect(new URL("http://localhost:8082/testGetContentOk"));
    Assertions.assertEquals("It works", content);
  }

  /**
   * Handler to handle good request to the server
   */
  private static class TestGetContentOkHandler extends AbstractHandler {

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response,
        int dispatch) throws IOException, ServletException {

      OutputStream out = response.getOutputStream();
      try (ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer()) {
        writer.write("It works");
        writer.flush();
        response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
        writer.writeTo(out);
        out.flush();
      }
    }
  }
}
