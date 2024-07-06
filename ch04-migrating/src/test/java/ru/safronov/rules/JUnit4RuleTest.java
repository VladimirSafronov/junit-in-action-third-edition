package ru.safronov.rules;

import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class JUnit4RuleTest {

  @Rule
  public final TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void testTempFolder() throws IOException {
    File createdFolder = folder.newFolder("createdFolder");
    File createdFile = folder.newFile("createdFile.txt");
    Assert.assertTrue(createdFolder.exists());
    Assert.assertTrue(createdFile.exists());
  }
}
