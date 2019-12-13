package Tranning.mavenproject;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver=null;
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException {
	  
  driver.findElement(By.id("username")).sendKeys(n);
  
  driver.findElement(By.id("password")).sendKeys(s);
  driver.findElement(By.id("Login")).click();
  String msg=driver.findElement(By.id("error")).getText();
  System.out.println(msg);
   Assert.assertTrue("Error Text not displayed", driver.findElement(By.id("error")).isDisplayed());
   Reporter.log(msg);
   
   Thread.sleep(5000);
   //driver.navigate().back();
   }
  @Test
  public void fd() {
	  driver.findElement(By.id("forgot_password_link")).click();
  }
   //forgot password
   @Test(dataProvider= "dp1")
   
   public void fp(String m, String b) throws InterruptedException {
	  
	   driver.findElement(By.id("un")).sendKeys(m);
	   driver.findElement(By.id("continue")).click();
	   Thread.sleep(3000);
	   //For back browser
	   driver.navigate().back();
	  // driver.navigate().back();
   }
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"akter@gmail.com" , "abcd789" },
      new Object[] { "khaleda@gmail.com", "xyz785" },
      new Object[] { "mossammad@gmail.com", "xyz785" },
    };
  }
  @BeforeClass
  @Parameters({"browser", "url"})
  public void beforeClass(String br, String ur) {
	  if(br.equalsIgnoreCase("chrome")) {
		  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\moemo\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get(ur);
	  driver.findElement(By.linkText("Login")).click();
	  }
		  System.out.println();
	  } 
  
  @DataProvider
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] {"akter@gmail.com" , "abcd789" },
      new Object[] { "khaleda@gmail.com", "xyz785" },
      new Object[] { "mossammad@gmail.com", "xyz785" },
    };
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
}

