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
public class TS028 extends BaseClass{
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
	public void TC011() throws InterruptedException  {

		LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
		WebElement forgotPass = lPojo.getForgotPass();
		Assert.assertTrue(forgotPass.isEnabled(),"Forgot password button is disable");


	} 

	@Test
	public void TC012() throws InterruptedException  {

		LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
		lPojo.getForgotPass().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/forgotten");


	} 
}
