package org.kgisl.tests;

import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class TS010 extends BaseClass {
	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	
	public void TC007() {
		  WebElement checkoutBtn = driver.findElement(By.xpath("//i[@class = \"fa fa-share\"]"));
		  Assert.assertTrue(checkoutBtn.isDisplayed());	}
}
