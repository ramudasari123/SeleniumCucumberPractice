package Demo.Cucumber.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class DriversLaunch {

	public static WebDriver driver;
	
	public static WebDriver createDriver(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", "../Cucumber/servers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver","../Cucumber/servers/chromedriver.exe");
				driver = new ChromeDriver();
			}
					else if(browser.equalsIgnoreCase("Edge")){
						System.setProperty("webdriver.edge.driver","../Cucumber/servers/MicrosoftWebDriver.exe");
						driver = new EdgeDriver();
					}
			else{
				throw new Exception("Browser is not correct");
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	@After
	public void setupAfterSuite() throws InterruptedException {
		driver.wait(5000);
		driver.close();
		driver.quit();
	}

}
