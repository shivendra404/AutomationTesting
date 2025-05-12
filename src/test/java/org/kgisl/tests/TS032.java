package org.kgisl.tests;

import org.kgisl.POJO.ProductPagePOJO;
import org.kgisl.POJO.RegisterPOJO;
import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners(TestListener.class)
public class TS032 extends BaseClass {

	private RegisterPOJO regPojo;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void openBrowser(@Optional("Chrome")String browser) throws InterruptedException {
		
		launchBrowser( browser);
		windowMaximize();
		launchUrl("https://awesomeqa.com/ui/");
		WebElement myAccount = driver.findElement(By.xpath("//span[@class= \"caret\"]"));
		myAccount.click();
		Thread.sleep(2000);
		WebElement registerMenu = driver.findElement(By.linkText("Register"));
		registerMenu.click();
		Thread.sleep(5000);
		regPojo = new RegisterPOJO(driver);
	}

	@AfterMethod
	public void closeBrowser() {
//		driver.quit();
	}

	@Test
	public void TC027() {
		regPojo.getFisrtName().sendKeys("shive");
		regPojo.getLastName().sendKeys("kumar");
		regPojo.getEmail().sendKeys("shivendraK8@gmail.com");
		regPojo.getPhoneNO().sendKeys("8375837583");
		regPojo.getPassword().sendKeys("Devu@123");
		regPojo.getComfirmPass().sendKeys("Devu@123");
//		regPojo.getFormSubmCheckBox().click();         // not checked
		scrollToElement(regPojo.getFormSubmCheckBox());
		
		regPojo.getRegisterButton().click();
		Assert.assertTrue(regPojo.getPolicyErrorMessage().get(0).isDisplayed(), "Error should display when passwords do not match");
	}

		 @Test
	public void TC028() {
		regPojo.getFisrtName().sendKeys("shive");
		regPojo.getLastName().sendKeys("kumar");
		regPojo.getEmail().sendKeys("shivendraK888@gmail.com");
		regPojo.getPhoneNO().sendKeys("8375837583");
		regPojo.getPassword().sendKeys("Devu@123");
		regPojo.getComfirmPass().sendKeys("Devu@123");
	
		regPojo.getFormSubmCheckBox().click();
		scrollToElement(regPojo.getFormSubmCheckBox());
		regPojo.getRegisterButton().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
		}
}
