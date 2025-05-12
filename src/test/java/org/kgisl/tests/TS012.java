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
public class TS012 extends BaseClass{

	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	
	@Test
	public void TC009() {
		  WebElement searchBar = driver.findElement(By.xpath("//input[@class = \"form-control input-lg\"]"
		  		+ ""));
		  Assert.assertTrue(searchBar.isDisplayed());
		  
	}
}
