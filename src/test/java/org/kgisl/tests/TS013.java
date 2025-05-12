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
public class TS013 extends BaseClass{


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
