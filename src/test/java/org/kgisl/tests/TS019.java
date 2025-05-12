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
public class TS019 extends BaseClass {
	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}


	@Test
	public void TC016() throws InterruptedException {
		WebElement myAccount = driver.findElement(By.xpath("//span[@class= \"caret\"]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement register = driver.findElement(By.linkText("Register"));
		register.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/register");
	}
}
