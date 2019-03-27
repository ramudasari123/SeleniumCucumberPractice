package Demo.Cucumber.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = ".//*[@id='username']")
	WebElement UserNameLogin;
	
	@FindBy(xpath = ".//*[@id='password']")
	WebElement PasswordLogin;
	
	@FindBy(xpath = ".//*[@id='loginForm']/button")
	WebElement LoginButton; 
	
	public LoginPage() {
		PageFactory.initElements(DriverFactory.getDriver(),this);
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}
	public WebElement getPasswordLogin() {
		return PasswordLogin;
	}
	public WebElement getUserNameLogin() {
		return UserNameLogin;
	}
}
