package org.kgisl.tests;


import java.util.Iterator;
import java.util.List;

import org.kgisl.POJO.ProductPagePOJO;
import org.kgisl.POJO.RegisterPOJO;
import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class TS033 extends BaseClass {


	private ProductPagePOJO productPagePojo;
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		launchBrowser();
//		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
		Thread.sleep(2000);
		productPagePojo = new ProductPagePOJO(driver);
	}

	@AfterMethod
	public void closeBrowser() {
//				driver.quit();
	}


	@Test
	public void TC008() throws InterruptedException {
		// Test: Check the sort functionality works correctly (e.g., sorting by price).
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		List<WebElement> navBarElements = productPagePojo.getNavBarElements();
		System.out.println(navBarElements);
		// Loop through each dropdown element
		for (WebElement webElement : navBarElements) {

			System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			Thread.sleep(2000);
			webElement.click();
			
			WebElement element = webElement.findElement(By.xpath("//a[@class='see-all']"));
			System.out.println(element+"iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
			element.click();
			Thread.sleep(2000);
	}
		
	}

	@Ignore
	@Test
	public void TC011() {
		// Test: Check if clicking on a product image navigates to the product detail page.
	}

	@Ignore
	@Test
	public void TC012() {
		// Test: Verify that clicking the 'Add to Cart' button adds the product to the cart.
	}

	@Ignore
	@Test
	public void TC013() {
		// Test: Ensure that the cart icon updates to reflect the number of items added.
	}

	@Ignore
	@Test
	public void TC014() {
		// Test: Check if the user can add multiple quantities of the same product to the cart.
	}

	@Ignore
	@Test
	public void TC015() {
		// Test: Check if the 'Add to Wishlist' button is visible on the product detail page.
	}

	@Ignore
	@Test
	public void TC016() {
		// Test: Verify that clicking the 'Add to Wishlist' button adds the product to the wishlist.
	}

	@Ignore
	@Test
	public void TC017() {
		// Test: Ensure that the wishlist icon updates to reflect the number of items added.
	}
}
