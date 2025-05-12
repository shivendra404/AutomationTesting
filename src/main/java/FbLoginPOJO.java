import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPOJO extends BaseClass {
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	WebDriver driver;

	// Constructor to initialize PageFactory
	public FbLoginPOJO() {
		PageFactory.initElements(driver, this);
	}

	// WebElements should be class-level, not inside a method
	@FindBy(id = "email") // Facebook email field
	private WebElement email;

	@FindBy(xpath = "//input[@name='pass']") // Facebook password field
	private WebElement password;

	@FindBy(name = "login") // Facebook login button
	private WebElement loginBtn;

}
