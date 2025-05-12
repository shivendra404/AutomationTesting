package org.kgisl.tests;

import static org.testng.Assert.assertNotEquals;


import java.util.List;

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
public class TS001 extends BaseClass {


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
	public void TC001()throws InterruptedException {
		String firstSlide = driver.findElement(By.cssSelector(".swiper-slide-active img")).getAttribute("src");
		Thread.sleep(2000); // wait for auto-rotation
		String newSlide = driver.findElement(By.cssSelector(".swiper-slide-active img")).getAttribute("src");
	

		assertNotEquals(firstSlide, newSlide, "Slider did not auto-rotate.");
	}


	@Test
	public void TC002() throws InterruptedException{
		String initialSlide = driver.findElement(By.cssSelector(".swiper-slide-active img")).getAttribute("src");
		driver.findElement(By.cssSelector(".swiper-button-next")).click();
		Thread.sleep(1000);
		String changedSlide = driver.findElement(By.cssSelector(".swiper-slide-active img")).getAttribute("src");

		assertNotEquals(initialSlide, changedSlide, "Manual slide navigation failed.");
	}

	@Test
	public void TC003()throws InterruptedException {
		
		List<WebElement> images = driver.findElements(By.cssSelector(".swiper-slide img"));
		for (WebElement image : images) {
		    if (image.isDisplayed()) {
		        Assert.assertTrue(image.getSize().getHeight() > 50, "Visible image height too small.");
		        Assert.assertTrue(image.getSize().getWidth() > 50, "Image width too small.");
				
		    } else {
		        System.out.println("Skipping hidden image: " + image.getAttribute("src"));
		    }
		}
	}

	


}
