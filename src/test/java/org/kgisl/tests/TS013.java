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
public class TS013 extends BaseClass{

	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	
	@Test
	public void TC010() throws InterruptedException {
		 WebElement searchBar = driver.findElement(By.xpath("//input[@class = \"form-control input-lg\"]"));
		 WebElement searchButton = driver.findElement(By.xpath("//button[@class = \"btn btn-default btn-lg\"]"));
	        searchBar.sendKeys("MacBook");
	        Thread.sleep(1000);
	        searchButton.click();
	        
	        Assert.assertFalse(driver.getPageSource().contains("No product"));
	        }
	
//	@Test
	public void TC011() {
		 
	}
}
