package ru.safronov;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * Class demonstrate how to create sample Jetty server
 */
public class JettySample {

  public static void main(String[] args) throws Exception {
    Server server = new Server(8082);

    Context root = new Context(server, "/");
    root.setResourceBase("ch07-stubs/src/main/resources/123.html");
    root.setHandler(new ResourceHandler());

    server.setStopAtShutdown(true);
    server.start();
  }
}
