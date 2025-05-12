package org.kgisl.tests;

import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS024 extends BaseClass{

	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
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
	public void TC021() throws InterruptedException {
		
		loginMethod("shivendrarathour1021@gmail.com","X85@q@YfpXEVeN");
		WebElement myAccount = driver.findElement(By.xpath("//span[@class= \"caret\"]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement logoutMenu = driver.findElement(By.linkText("Logout"));
		logoutMenu.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/logout");
	}
}
