package ru.safronov.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * A SampleServlet to demonstrate the differences of unit-testing J2EE components.
 */
public class SampleServlet extends HttpServlet {

  public boolean isAuthenticated(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return false;
    }
    String authenticationAttribute = String.valueOf(session.getAttribute("authenticated"));
    return Boolean.parseBoolean(authenticationAttribute);
  }
}
