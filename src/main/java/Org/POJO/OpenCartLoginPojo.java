package Org.POJO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartLoginPojo {
	WebDriver driver;

	// Constructor to initialize PageFactory
	public OpenCartLoginPojo() {
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy
	 private String email;
	 private String password;

	   

	  

	    // Getters and Setters
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
}
