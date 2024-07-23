package ru.safronov.servlet;

import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SampleServletEasyMockTest {

  private SampleServlet servlet;
  private HttpServletRequest mockRequest;
  private HttpSession mockSession;

  @BeforeEach
  void setUp() {
    servlet = new SampleServlet();
    mockRequest = createStrictMock(HttpServletRequest.class);
    mockSession = createStrictMock(HttpSession.class);
  }

  @AfterEach
  void tearDown() {
    verify(mockRequest);
    verify(mockSession);
  }

  @Test
  void testIsAuthenticatedAuthenticated() {
    expect(mockRequest.getSession(eq(false))).andReturn(mockSession);
    expect(mockSession.getAttribute(eq("authenticated"))).andReturn(true);

    replay(mockRequest);
    replay(mockSession);

    assertTrue(servlet.isAuthenticated(mockRequest));
  }

  @Test
  void testIsAuthenticatedNoAuthenticated() {
    expect(mockSession.getAttribute(eq("authenticated"))).andReturn(false);
    replay(mockSession);
    expect(mockRequest.getSession(eq(false))).andReturn(mockSession);
    replay(mockRequest);

    assertFalse(servlet.isAuthenticated(mockRequest));
  }

  @Test
  void testIsAuthenticatedNoSession() {
    expect(mockRequest.getSession(eq(false))).andReturn(null);
    replay(mockRequest);
    replay(mockSession);
    assertFalse(servlet.isAuthenticated(mockRequest));
  }
}
