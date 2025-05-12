
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemoClass extends BaseClass {
  @Test
  public void demoFunction() throws IOException {
	  
	  System.out.println("Running TC001");
		launchBrowser();

		launchUrl("https://www.facebook.com");
		windowMaximize();

        FbLoginPOJO f = PageFactory.initElements(driver, FbLoginPOJO.class);
		
		passText("shivendra@gmailcom", f.getEmail()); 
		passText("12345678", f.getPassword()); 
		
		screenShot("FullNameTakingAlphnumeric");
		
		assertTrue(true);
  }
  
  @BeforeMethod
  public void TC001() {
      System.out.println("Runs before each test");
  }

  @AfterMethod
  public void TC002() {
      System.out.println("Runs after each test");
  }
}
