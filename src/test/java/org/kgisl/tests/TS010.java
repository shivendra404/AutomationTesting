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

@Listeners(TestListener.class)
public class TS010 extends BaseClass {

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
	
	public void TC007() {
		  WebElement checkoutBtn = driver.findElement(By.xpath("//i[@class = \"fa fa-share\"]"));
		  Assert.assertTrue(checkoutBtn.isDisplayed());	}
}
