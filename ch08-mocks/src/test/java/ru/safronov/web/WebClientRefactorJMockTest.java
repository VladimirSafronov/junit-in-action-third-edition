package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class WebClientRefactorJMockTest {


  @SuppressWarnings("JUnitMalformedDeclaration")
  @RegisterExtension
  Mockery context = new JUnit5Mockery() {
    {
      //Tell JMock to create mock objects not only for interfaces but also for classes
      setImposteriser(ClassImposteriser.INSTANCE);
    }
  };
  private ConnectionFactory mockFactory;
  private InputStream mockStream;

  @BeforeEach
  void setUp() {
    mockFactory = context.mock(ConnectionFactory.class);
    mockStream = context.mock(InputStream.class);
  }

  @Disabled
  @Test
  void testGetContentOk() throws IOException {

    context.checking(new Expectations() {
      {
        oneOf(mockFactory).getData();
        will(returnValue(mockStream));

        atLeast(1).of(mockStream).read();
        will(onConsecutiveCalls(
            returnValue((int) 'W'),
            returnValue((int) 'o'),
            returnValue((int) 'r'),
            returnValue((int) 'k'),
            returnValue((int) 's'),
            returnValue((int) '!'),
            returnValue(-1)
        ));
        oneOf(mockStream).close();
      }
    });

    WebClientRefactor webClient = new WebClientRefactor();
    String result = webClient.getContent(mockFactory);

    Assertions.assertEquals("Works!", result);
  }

  @Disabled
  @Test
  void testGetContentCannotCloseInputStream() throws IOException {

    context.checking(new Expectations() {
      {
        oneOf(mockFactory).getData();
        will(returnValue(mockStream));
        oneOf(mockStream).read();
        will(returnValue(-1));
        oneOf(mockStream).close();
        will(throwException(new IOException("cannot close")));
      }
    });

    WebClientRefactor webclient = new WebClientRefactor();
    String result = webclient.getContent(mockFactory);
    Assertions.assertNull(result);
  }
}
