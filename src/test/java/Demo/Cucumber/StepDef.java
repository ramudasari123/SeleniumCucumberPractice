package Demo.Cucumber;

import org.testng.Assert;

import Demo.Cucumber.PageFactory.DriverFactory;
import Demo.Cucumber.PageFactory.HomePage;
import Demo.Cucumber.PageFactory.LoginPage;
import Demo.Cucumber.PageFactory.RUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	LoginPage loginpage  = new LoginPage();
	HomePage homepage = new HomePage();
	RUtils util = new RUtils();
	@Given("^user opens nest Page$")
	 public void user_opens_nest_page(){
	    DriverFactory.getDriver().get("https://nest.infostretch.com/#/login");
	    util.waitForPageToLoad();
	}
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_username_and_password(String username, String password){
		loginpage.getUserNameLogin().sendKeys(username);
		loginpage.getPasswordLogin().sendKeys(password);
    }
	@And("^clicks on login button$")
	public void clicks_on_login_button(){
		loginpage.getLoginButton().click();
    }
	@Then("^user sees the nest home page$")
	public void user_sees_the_nest_home_page(){
		util.waitForPageToLoad();
		util.waitForVisibility(homepage.getLogo());
		Assert.assertTrue(homepage.getLogo().isDisplayed(), "homepage logo is visible");
		System.out.println("logo visible-------------------");
	}
	@When("^user clciks on left navigation bar$")
	public void user_clciks_on_left_navigation_bar(){
		util.clcikUsingJavaScript(homepage.getLeftnavigationbar());
		System.out.println("clicked-------------------");
	}
	@Then("^user sees the navigation menu$")
	public void user_sees_the_navigation_menu(){
	int size = homepage.getMenusection().size();
	Assert.assertTrue(size>0);	
	System.out.println("size verified-------------------");
	}
}
