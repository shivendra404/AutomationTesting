package org.kgisl.POJO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPagePOJO   {
	WebDriver driver;

	// Constructor to initialize PageFactory
	public ProductDetailPagePOJO(WebDriver driver2) {
		PageFactory.initElements(driver2, this);
	}


	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement fisrtName;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@type='email']")
	private WebElement email;

	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement phoneNO;

}
