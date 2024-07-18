package ru.safronov.web;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WebClientRefactorMockitoTest {

  @Mock
  private ConnectionFactory mockFactory;

  @Mock
  private InputStream mockInputStream;

  @Test
  void testGetContentOk() throws IOException {
    when(mockFactory.getData()).thenReturn(mockInputStream);
    when(mockInputStream.read()).thenReturn((int) 'W')
        .thenReturn((int) 'o')
        .thenReturn((int) 'r')
        .thenReturn((int) 'k')
        .thenReturn((int) 's')
        .thenReturn((int) '!')
        .thenReturn(-1);

    WebClientRefactor client = new WebClientRefactor();
    String result = client.getContent(mockFactory);
    Assertions.assertEquals("Works!", result);
  }

  @Test
  void testGetContentCannotCloseInputStream() throws IOException {
    when(mockFactory.getData()).thenReturn(mockInputStream);
    when(mockInputStream.read()).thenReturn(-1);
    doThrow(new IOException("cannot close")).when(mockInputStream).close();

    WebClientRefactor client = new WebClientRefactor();
    String result = client.getContent(mockFactory);
    Assertions.assertNull(result);
  }
}
