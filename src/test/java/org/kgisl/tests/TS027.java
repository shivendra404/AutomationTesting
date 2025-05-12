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
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS027 extends BaseClass {
	
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		launchBrowser();
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
	
	@Test
	public void TC006() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			lPojo.performLogin("Shivass","X85@q@YfpXEVeN");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/login");
	
			Assert.assertTrue(lPojo.getErrorMessage().isDisplayed());
	} 
	
	
	@Test
	public void TC007() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			//correct email incorrect password
			lPojo.performLogin("shivendrarathour1021@gmail.com","X85@@YfpXEVeN");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/login");
	
			Assert.assertTrue(lPojo.getErrorMessage().isDisplayed());
	} 
	
	@Test
	public void TC008() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			lPojo.performLogin("","X85@q@YfpXEVeN");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/login");
	
			Assert.assertTrue(lPojo.getErrorMessage().isDisplayed());
	} 

	@Test
	public void TC009() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			lPojo.performLogin("shivendrarathour1021@gmail.com","");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/login");
	
			Assert.assertTrue(lPojo.getErrorMessage().isDisplayed());
	} 
	
	
	@Test
	public void TC010() throws InterruptedException  {
		
			LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
			//Email and password both are empty
			lPojo.performLogin("","");
			Thread.sleep(3000);
			Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/login");
	
			Assert.assertTrue(lPojo.getErrorMessage().isDisplayed());
	} 
	

}
