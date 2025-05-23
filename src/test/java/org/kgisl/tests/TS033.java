package org.kgisl.tests;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.kgisl.POJO.ProductPagePOJO;
import org.kgisl.POJO.RegisterPOJO;
import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




@Listeners(TestListener.class)
public class TS033 extends BaseClass {


	private ProductPagePOJO productPagePojo;


	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(@Optional("Chrome")String browser) throws InterruptedException {
		System.out.println(browser);
		launchBrowser( browser);
		//		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
		Thread.sleep(2000);
		productPagePojo = new ProductPagePOJO(driver);
	}

	@AfterMethod
	public void closeBrowser() {
		//				driver.quit();
	}


	@Ignore
	//	@Test
	public void TC001() throws InterruptedException {


		List<WebElement> navBarElements = productPagePojo.getNavBarElements();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Loop through each dropdown element
		for (WebElement toggle : navBarElements) {
			toggle.click();

			// Wait for the see-all link to be present in this dropdown
			WebElement seeAllLink = wait.until(ExpectedConditions.elementToBeClickable(
					toggle.findElement(By.xpath("../div/a[contains(@class, 'see-all')]"))
					));

			seeAllLink.click();
			List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
					By.className("product-thumb")
					));
			System.out.println(products.size());
			Assert.assertTrue(products.size()>0);

			// If it navigates, you may want to return or reload the original page here
			driver.navigate().back();
		}

	}

	//	@Ignore
	@Test
	public void TC008() {

		List<WebElement> navBarElements = productPagePojo.getNavBarElements();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		navBarElements.get(0).click();

		// Wait for the see-all link to be present in this dropdown
		WebElement seeAllLink = wait.until(ExpectedConditions.elementToBeClickable(
				navBarElements.get(0).findElement(By.xpath("../div/a[contains(@class, 'see-all')]"))
				));

		seeAllLink.click();
		productPagePojo.getSortByMenu();

		List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.className("product-thumb")
				));

		System.out.println(products);


		List<String> productNames = new ArrayList<>();

		for (WebElement product : products) {
			// Assuming product name is inside <div class="caption"><a>Product Name</a></div>
			WebElement nameElement = product.findElement(By.xpath(".//div[@class='caption']//a"));
			productNames.add(nameElement.getText().trim());
		}

		System.out.println("Product Names: " + productNames);

		// Create a copy and sort it
		List<String> sortedNames = new ArrayList<>(productNames);
		Collections.sort(productNames, String.CASE_INSENSITIVE_ORDER);
		System.out.println(sortedNames);

		Assert.assertTrue(productNames.equals(sortedNames));


	}

	@Ignore
	@Test
	public void TC011() throws InterruptedException {
		// Test: Check if clicking on a product image navigates to the product detail page.

		List<WebElement> navBarElements = productPagePojo.getNavBarElements();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		navBarElements.get(0).click();

		// Wait for the see-all link to be present in this dropdown
		WebElement seeAllLink = wait.until(ExpectedConditions.elementToBeClickable(
				navBarElements.get(0).findElement(By.xpath("../div/a[contains(@class, 'see-all')]"))
				));

		seeAllLink.click();
		List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
				By.className("product-thumb")
				));

		for (WebElement product : products) {
			WebElement image = wait.until(ExpectedConditions.elementToBeClickable(
					product.findElement(By.xpath(".//div[contains(@class, 'image')]"))
					));
			image.click();
			Thread.sleep(1000);
			String currentUrl = driver.getCurrentUrl();
			Assert.assertTrue(currentUrl.contains("https://awesomeqa.com/ui/index.php?route=product/product&path=20"));
			Thread.sleep(1000);
			driver.navigate().back();

		}




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
