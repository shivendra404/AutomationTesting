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
public class TS003 extends BaseClass{

	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}
	
	@Test
	public void TC006()throws InterruptedException {
		WebElement footer = driver.findElement(By.tagName("footer"));
		scrollToElement(footer);
		Assert.assertTrue(footer.isDisplayed(), "Footer is not visible.");
	}


}
