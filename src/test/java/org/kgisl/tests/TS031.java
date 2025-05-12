package org.kgisl.tests;

import org.kgisl.POJO.RegisterPOJO;
import org.kgisl.utils.BaseClass;
import org.kgisl.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TS031 extends BaseClass {

	private RegisterPOJO regPojo;
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		launchBrowser();
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
		driver.quit();
	}

			@Test
		public void TC005() {
			//Fail
			regPojo.getFisrtName().sendKeys("Shiva123");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getFirstNameError().get(0).isDisplayed(),
					"Error should display for alphanumeric first name");
		}
	
			@Test
		public void TC006() {
			//Fail
	
			regPojo.getFisrtName().sendKeys("12345678");
			regPojo.getRegisterButton().click();
	
			Assert.assertTrue(regPojo.getFirstNameError().get(0).isDisplayed(), "Error should display for numeric first name");
		}
	
			@Test
		public void TC007() {
			//Fail
			RegisterPOJO regPojo = new RegisterPOJO(driver);
	
			regPojo.getFisrtName().sendKeys("shiv123$^");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getFirstNameError().get(0).isDisplayed(), "Error should display for alpahnumeric and special character first name");
		}
	
			@Test
		public void TC008() throws InterruptedException {
			//pass
			RegisterPOJO regPojo = new RegisterPOJO(driver);
	
			regPojo.getFisrtName().sendKeys("");
			regPojo.getRegisterButton().click();
			Thread.sleep(2000);
	
			Assert.assertTrue(regPojo.getFirstNameError().get(0).isDisplayed(), "Error should display for empty first name");
		}
	
			@Test
		public void TC009() {
			//pass
			RegisterPOJO regPojo = new RegisterPOJO(driver);
	
			regPojo.getFisrtName().sendKeys("Shivendra");
			regPojo.getRegisterButton().click();
			//		System.out.println(regPojo.getFirstNameError().get(0).isDisplayed());
			Assert.assertTrue(regPojo.getFirstNameError().isEmpty(), "Error should not  display for aphabetic first name");
	
		}
	
		//---------------------------------------------------------------
				@Test
		public void TC010() {
			//fail
			RegisterPOJO regPojo = new RegisterPOJO(driver);
			regPojo.getLastName().sendKeys("kumar");
			regPojo.getRegisterButton().click();
			Assert.assertFalse(regPojo.getLastNameError().get(0).isDisplayed(), "Error should not display for alphabetic last name");
	
		}
	
			@Test
		public void TC011() {
	
			//fail
			RegisterPOJO regPojo = new RegisterPOJO(driver);
	
			regPojo.getLastName().sendKeys("1234");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getLastNameError().get(0).isDisplayed(), "Error should display  for numeric last name");
	
		}
	
			@Test
		public void TC012() {
			//fail
			RegisterPOJO regPojo = new RegisterPOJO(driver);
	
			regPojo.getLastName().sendKeys("Kum123$%");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getLastNameError().get(0).isDisplayed(), "Error should display foralphanumeric & special char last name");
	
		}
	
				@Test
		public void TC013() {
			//fail
			RegisterPOJO regPojo = new RegisterPOJO(driver);
	
			regPojo.getLastName().sendKeys("");
			regPojo.getRegisterButton().click();
			Assert.assertFalse(regPojo.getLastNameError().get(0).isDisplayed(), "Error should not display empty last name");
	
		}
	
	@Test
	public void TC014() throws InterruptedException {
		//pass
		RegisterPOJO regPojo = new RegisterPOJO(driver);

		regPojo.getLastName().sendKeys("kumar");
		regPojo.getRegisterButton().click();
	    Thread.sleep(3000);
		Assert.assertTrue(regPojo.getLastNameError().isEmpty(), "Error should not display foralphanumeric & special char last name");
	}

	@Test
	public void TC015() {
		//pass
		regPojo.getEmail().sendKeys(""); // Assuming you have a method to get the email field
		regPojo.getRegisterButton().click();
		Assert.assertTrue(regPojo.getEmailError().get(0).isDisplayed(), "Error should display for empty email");
	}
	@Test
	public void TC016() {
		//pass
		regPojo.getEmail().sendKeys("shivendrakuamr@gmail.com");
		regPojo.getRegisterButton().click();
		Assert.assertTrue(regPojo.getEmailError().isEmpty(), "No error should display for valid email");
	}
	@Test
	public void TC017() {
		//pass
		regPojo.getEmail().sendKeys("shivekumargmail.com");
		regPojo.getRegisterButton().click();
		Assert.assertTrue(regPojo.getEmailError().get(0).isDisplayed(), "Error should display for invalid email format");
	}


	@Test
	public void TC018() {
		//fail
		regPojo.getPhoneNO().sendKeys("87878787");
		regPojo.getRegisterButton().click();
		Assert.assertTrue(regPojo.getPhoneError().get(0).isDisplayed(), "Error should display for phone number less than 10 digits");
	}
		@Test
		public void TC019() {
			//pass
			regPojo.getPhoneNO().sendKeys("8787878787");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getPhoneError().isEmpty(), "No error should display for valid 10 digit phone number");
		}
		@Test
		public void TC020() {
			//fail
			regPojo.getPhoneNO().sendKeys("878788888888");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getPhoneError().get(0).isDisplayed(), "Error should display for phone number more than 10 digits");
		}
	
		@Test
		public void TC021() {
			//fail
			regPojo.getPhoneNO().sendKeys("shiv123456");
			regPojo.getRegisterButton().click();
			Assert.assertTrue(regPojo.getPhoneError().get(0).isDisplayed(), "Error should display for alphanumeric phone number");
		}
		@Test
		public void TC022() {
			//fail
			regPojo.getPhoneNO().sendKeys("");
			regPojo.getRegisterButton().click();
			scrollToElement(regPojo.getPhoneNO());
			Assert.assertTrue(regPojo.getPhoneError().get(0).isDisplayed(), "Error should display for empty phone number");
		}
		@Test
		public void TC023() {
			//pass
			regPojo.getPassword().sendKeys("123");
			regPojo.getRegisterButton().click();
			scrollToElement(regPojo.getPassword());
			Assert.assertTrue(regPojo.getPasswordError().get(0).isDisplayed(), "Error should display for password less than 4 chars");
		}
	
		@Test
		public void TC024() {
			//fail
			regPojo.getPassword().sendKeys("Shivendr");
			regPojo.getRegisterButton().click();
			scrollToElement(regPojo.getPassword());
			Assert.assertTrue(regPojo.getPasswordError().get(0).isDisplayed(), "Error should display if password does not meet complexity");
		}
		@Test
		public void TC025() {
			//    	pass
			regPojo.getPassword().sendKeys("shivendra");
			regPojo.getComfirmPass().sendKeys("shivendra");
			regPojo.getRegisterButton().click();
		scrollToElement(regPojo.getPassword());
			Assert.assertNotSame(regPojo.getConfirmPasswordError().isEmpty(), "No error should display when passwords match");
		}
		@Test
		public void TC026() {
			//pass
			regPojo.getPassword().sendKeys("shivendra");
			regPojo.getComfirmPass().sendKeys("sendra");
			regPojo.getRegisterButton().click();
			scrollToElement(regPojo.getPassword());
			Assert.assertTrue(regPojo.getConfirmPasswordError().get(0).isDisplayed(), "Error should display when passwords do not match");
		}
}
