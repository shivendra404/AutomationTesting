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
public class TS004 extends BaseClass {
	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	  
	
	@Test
	public void TC001() {
		  WebElement logo = driver.findElement(By.id("logo")); 
	        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
	        
	        int width = logo.getSize().getWidth();
	        int height = logo.getSize().getHeight();

	        Assert.assertTrue(width > 0 && height > 0, "Logo dimensions seem invalid (non-responsive or not visible)");
	}
}
