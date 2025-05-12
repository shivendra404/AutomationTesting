package org.kgisl.POJO;

import java.util.List;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOJO extends BaseClass {

	WebDriver driver;

	// Constructor to initialize PageFactory
	public RegisterPOJO(WebDriver driver2) {
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

	@FindBy(xpath = "//input[@name='password']")
	private WebElement Password;

	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement comfirmPass;
	//	 Warning: No match for E-Mail Address and/or Password.

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement FormSubmCheckBox;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement RegisterButton;

	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div[@class='text-danger']")
	private List<WebElement> firstNameError;
	
	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div[@class='text-danger']")
	private List<WebElement> lastNameError;
	
	@FindBy(xpath = "//input[@type='email']/following-sibling::div[@class='text-danger']")
	private List<WebElement> emailError;
	
	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div[@class='text-danger']")
	private List<WebElement> phoneError;
	
	@FindBy(xpath = "//input[@name='password']/following-sibling::div[@class='text-danger']")
	private List<WebElement> passwordError;
	
	@FindBy(xpath = "//input[@name='confirm']/following-sibling::div[@class='text-danger']")
	private List<WebElement> confirmPasswordError;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private List<WebElement> policyErrorMessage;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFisrtName() {
		return fisrtName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhoneNO() {
		return phoneNO;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getComfirmPass() {
		return comfirmPass;
	}

	public WebElement getFormSubmCheckBox() {
		return FormSubmCheckBox;
	}

	public WebElement getRegisterButton() {
		return RegisterButton;
	}

	public List<WebElement> getFirstNameError() {
		return firstNameError;
	}

	public List<WebElement> getLastNameError() {
		return lastNameError;
	}

	public List<WebElement> getEmailError() {
		return emailError;
	}

	public List<WebElement> getPhoneError() {
		return phoneError;
	}

	public List<WebElement> getPasswordError() {
		return passwordError;
	}

	public List<WebElement> getConfirmPasswordError() {
		return confirmPasswordError;
	}

	public List<WebElement> getPolicyErrorMessage() {
		return policyErrorMessage;
	}



}
