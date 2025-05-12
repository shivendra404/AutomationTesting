package org.kgisl.tests;

import java.util.List;

import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS016 extends BaseClass {
	@BeforeClass
	public void openBrowser() {
		launchBrowser();
//		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}

	@Test
	public void TC013() {


		WebElement PhonePad = driver.findElement(By.xpath("//*[text()='Phones & PDAs']"));
		PhonePad.click();
		List<WebElement> items = driver.findElements(By.xpath("//div[@class=\"product-thumb\"]"));
		
		Assert.assertTrue(items.size()>0);
		
	}
}
