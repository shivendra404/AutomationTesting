package org.kgisl.tests;

import org.kgisl.POJO.LoginPOJO;
import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS029 extends BaseClass {

	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(@Optional("Chrome")String browser) throws InterruptedException {
		
		launchBrowser( browser);
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
		WebElement myAccount = driver.findElement(By.xpath("//span[@class= \"caret\"]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement loginMenu = driver.findElement(By.linkText("Login"));
		loginMenu.click();
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
//	@Test
	public void TC013() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			WebElement registerLink = lPojo.getRegisterLink();
			Assert.assertTrue(registerLink.isEnabled(),"Register button is disable");
	
			
	} 
	
	@Test
	public void TC014() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			lPojo.getRegisterLink().click();
			Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/register");
	
			
	} 
	
	
}
