package ru.safronov.web;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WebClientRefactorEasyMockTest {

  private ConnectionFactory connectionFactory;
  private InputStream inputStream;

  @BeforeEach
  void setUp() {
    connectionFactory = createMock("connectionFactory", ConnectionFactory.class);
    inputStream = createMock("inputStream", InputStream.class);
  }

  @AfterEach
  void tearDown() {
    verify(connectionFactory);
    verify(inputStream);
  }

  @Test
  void testGetContentOk() throws IOException {
    expect(connectionFactory.getData()).andReturn(inputStream);
    String works = "Works!";

    for (int i = 0; i < works.length(); i++) {
      expect(inputStream.read()).andReturn((int) works.charAt(i));
    }
    expect(inputStream.read()).andReturn(-1);
    inputStream.close();

    //To denote that we are done declaring our expectations
    replay(connectionFactory);
    replay(inputStream);

    WebClientRefactor webClient = new WebClientRefactor();
    String result = webClient.getContent(connectionFactory);

    Assertions.assertEquals(works, result);
  }

  @Test
  void testGetContentCannotCloseInputStream() throws IOException {
    expect(connectionFactory.getData()).andReturn(inputStream);
    expect(inputStream.read()).andReturn(-1);
    inputStream.close();
    expectLastCall().andThrow(new IOException("cannot close"));

    replay(connectionFactory);
    replay(inputStream);

    WebClientRefactor webClient = new WebClientRefactor();
    String result = webClient.getContent(connectionFactory);

    Assertions.assertNull(result);
  }
}
