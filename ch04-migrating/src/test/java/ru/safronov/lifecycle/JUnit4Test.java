package ru.safronov.lifecycle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnit4Test {

  private static ResourceForTests resourceForTests;
  private SUT resourceUnderTest;

  @BeforeClass
  public static void setUpClass() {
    resourceForTests = new ResourceForTests("resource for all tests");
  }

  @AfterClass
  public static void tearDownClass() {
    resourceForTests.close();
  }

  @Before
  public void setUp() {
    resourceUnderTest = new SUT("recourse for single test");
  }

  @After
  public void tearDown() {
    resourceUnderTest.close();
  }

  @Test
  public void testRegularWork() {
    Assert.assertTrue(resourceUnderTest.canReceiveRegularWork());
  }

  @Test
  public void testAdditionalWork() {
    Assert.assertFalse(resourceUnderTest.canReceiveAdditionalWork());
  }

  @Test
  @Ignore
  public void thirdTest() {
    Assert.assertEquals("Not equal numbers", 2, 1);
  }
}
