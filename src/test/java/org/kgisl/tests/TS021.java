package org.kgisl.tests;

import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS021 extends BaseClass {

	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(@Optional("Chrome")String browser) throws InterruptedException {
		
		launchBrowser( browser);
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	public void loginMethod(String emailId,String pass) throws InterruptedException {
		WebElement myAccount = driver.findElement(By.xpath("//span[@class= \"caret\"]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement loginMenu = driver.findElement(By.linkText("Login"));
		loginMenu.click();
		Thread.sleep(1000);
		WebElement email = driver.findElement(By.name("email"));
		WebElement password = driver.findElement(By.id("input-password"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]"));
		email.sendKeys(emailId);
		Thread.sleep(1000);
		password.sendKeys(pass);
		Thread.sleep(1000);
		loginButton.click();
	}
	
	@Test
	public void TC018() throws InterruptedException {
		
		loginMethod("shivendrarathour1021@gmail.com","X85@q@YfpXEVeN");
		WebElement myAccount = driver.findElement(By.xpath("//span[@class= \"caret\"]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement myAccountMenu = driver.findElement(By.linkText("My Account"));
		myAccountMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/account");
	}
}


