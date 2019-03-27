package Demo.Cucumber.PageFactory;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestMethodLIstener {

	@Before
	public void setUp() throws Exception {
		String browserName = "chrome";
		WebDriver driver = DriversLaunch.createDriver(browserName);
		DriverFactory.setWebDriver(driver);
	}

	@After
	public void afterInvocation() {
		WebDriver driver = DriverFactory.getDriver();
		if (driver != null) {
			driver.quit();
		}
	}
	
//	public void afterInvocation(IInvokedMethod method, ITestResult arg1) {
//		 if (method.isTestMethod()) {
//	            //String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
//			 String browser = "chrome"; 
//	            WebDriver driver = DriversLaunch.createDriver(browser);
//	            DriverFactory.setWebDriver(driver);
//	        }		
//	}
//
//	public void beforeInvocation(IInvokedMethod method, ITestResult arg1) {
//		 if (method.isTestMethod()) {
//	            WebDriver driver = DriverFactory.getDriver();
//	            if (driver != null) {
//	                driver.quit();
//	            }
//	        }		
//	}
}
