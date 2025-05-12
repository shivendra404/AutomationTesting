package org.kgisl.POJO;

import org.kgisl.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOJO extends BaseClass {
	WebDriver driver;

	// Constructor to initialize PageFactory
	public LoginPOJO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(linkText="Forgotten Password")
	
	private WebElement forgotPass;
	
	@FindBy(linkText="Continue")
	private WebElement registerLink;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement ErrorMessage;
//	 Warning: No match for E-Mail Address and/or Password.
	
	
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}


	public WebElement getForgotPass() {
		return forgotPass;
	}


	public WebElement getRegisterLink() {
		return registerLink;
	}


	public WebElement getErrorMessage() {
		return ErrorMessage;
	}
	
	public void performLogin(String mailAdd,String pass) {
		email.clear();
		email.sendKeys(mailAdd);
		password.clear();
		password.sendKeys(pass);
		loginButton.click();	
		
	}
	
}
