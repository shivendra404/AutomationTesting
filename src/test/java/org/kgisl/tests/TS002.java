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
public class TS002 extends BaseClass {

	@BeforeClass
	public void openBrowser() {
		launchBrowser();
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
	}

	@Test
	public void TC004() throws InterruptedException{
		List<WebElement> cards = driver.findElements(By.cssSelector(".product-thumb"));
		Assert.assertTrue(cards.size() > 0, "No feature cards found.");

		for (WebElement card : cards) {

			scrollToElement(card);
			Assert.assertTrue(card.isDisplayed(), "Feature card is not visible.");
		}
	}

	@Test
	public void TC005() throws InterruptedException{
		List<WebElement> products = driver.findElements(By.cssSelector(".product-thumb"));
		Assert.assertTrue(products.size() > 0, "No product cards found.");

		for (WebElement product : products) {
			scrollToElement(product);
			WebElement image = product.findElement(By.tagName("img"));
			WebElement price = product.findElement(By.cssSelector(".price"));


			Assert.assertTrue(image.isDisplayed(), "Product image not visible.");
			Assert.assertFalse(price.getText().trim().isEmpty(), "Product price not visible.");
		}
	}

}
