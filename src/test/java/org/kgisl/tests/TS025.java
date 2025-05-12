package org.kgisl.tests;

import org.kgisl.POJO.LoginPOJO;
import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS025 extends BaseClass {

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

	@Test
	public void TC001() throws InterruptedException {
		
		LoginPOJO lPojo = new LoginPOJO(BaseClass.driver);
		WebElement email = lPojo.getEmail();
		WebElement password = lPojo.getPassword();
		WebElement loginButton = lPojo.getLoginButton();
		WebElement forgotPass = lPojo.getForgotPass();
		
		Assert.assertTrue(email.isEnabled(),"Email is disable");
		Assert.assertTrue(password.isEnabled()," password is disable");
		Assert.assertTrue(loginButton.isEnabled(),"Login button is disable");
		Assert.assertTrue(forgotPass.isEnabled(),"Forgot password button is disable");

}

//	@Test
//	public void TC002() throws InterruptedException  {
//		
//	} 
//
//	@Test
//	public void TC003() throws InterruptedException  {
//				Assert.assertTrue(lPojo.getErrorMessage().isDisplayed());
//	} 
	
}