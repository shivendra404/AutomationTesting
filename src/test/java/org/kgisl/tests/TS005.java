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
public class TS005 extends BaseClass {

	
	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	
	@Test
	public void TC002() {
		 WebElement logo = driver.findElement(By.id("logo"));
	        logo.click();
	        
	        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=common/home");
	}
	  
}
