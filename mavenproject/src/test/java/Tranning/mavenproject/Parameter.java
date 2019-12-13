package Tranning.mavenproject;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;

public class Parameter {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "", "a" },
      new Object[] { "", "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterTest
  public void afterTest() {
  }

}
