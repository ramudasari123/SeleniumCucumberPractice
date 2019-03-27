package Demo.Cucumber.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(css = ".logo_placement")
	WebElement Logo;
	
	@FindBy(css = "#toggle_img_menu")
	WebElement Leftnavigationbar;

	@FindBy(xpath = ".//*[@id='menu']//img[@class='settings_btn1']")
	List<WebElement> menusection;
	
	public HomePage(){
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public List<WebElement> getMenusection() {
		return menusection;
	}
	public WebElement getLogo() {
		return Logo;
	}
	public WebElement getLeftnavigationbar() {
		return Leftnavigationbar;
	}
	
}
