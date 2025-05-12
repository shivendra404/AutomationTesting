package org.kgisl.POJO;

import java.util.List;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ProductPagePOJO extends BaseClass {

	WebDriver driver;

	// Constructor to initialize PageFactory
	public ProductPagePOJO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ul[contains(@class, 'nav') and contains(@class, 'navbar-nav')]//a[@class='dropdown-toggle' and @data-toggle='dropdown']")
	private List<WebElement> navBarElements;

	@FindBy(id = "input-sort")
	private WebElement SortByMenu;

	@FindBy(linkText = "Name (A - Z)")
	private WebElement SortByMenuOption;

	@FindBy(xpath = "//input[@name='']//div[@class=\"product-thumb\"]")
	private List<WebElement> Products;

	@FindBy(xpath = "//input[@name='']//div[@class=\"img-responsive\"]")
	private List<WebElement> productImage;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSortByMenu() {
		return SortByMenu;

	}

	public WebElement getSortByMenuOption() {
		return SortByMenuOption;
	}

	public List<WebElement> getProducts() {
		return Products;
	}

	public List<WebElement> getNavBarElements() {
		return navBarElements;
	}

}
