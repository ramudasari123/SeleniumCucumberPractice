package Demo.Cucumber.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RUtils {
	WebDriverWait wait = null;
	public void clickOn(WebElement element) {
		Actions actions = new Actions(DriverFactory.getDriver());
		actions.contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).perform();
	}
	public void waitForVisibility(WebElement element) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static String getEmail(String email) {
		if (email == null || email.equalsIgnoreCase("")) {
			return "auto_" + org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric(15) + "@example.com";
		} else {
			return email;
		}
	}
	public void scrollElementIntoView(WebElement element) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}
	
	public void clcikUsingJavaScript(WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor)DriverFactory.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void waitForelementToBeClickable(final WebElement webElement) {
		wait = new WebDriverWait(DriverFactory.getDriver(), 120);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public boolean isElementPresent(By locator) {
		return !DriverFactory.getDriver().findElements(locator).isEmpty();
	}
	
	public void waitForPageToLoad() {
		waitForAjaxToComplete();
		waitForLoaderToDismiss();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitForAjaxToComplete(long... second) {
		try {
			(new WebDriverWait(DriverFactory.getDriver(), 60))
					.until(new ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(WebDriver d) {
							JavascriptExecutor js =
									(JavascriptExecutor) DriverFactory.getDriver();
							return (Boolean) js
									.executeScript("return !!window.jQuery && window.jQuery.active == 0");

						}
					});
		} catch (Exception e) {
		}
	}
	
	public void waitForLoaderToDismiss() {
		WebDriverWait wait =
				new WebDriverWait(DriverFactory.getDriver(), 20);
		try {
			wait.until(new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) DriverFactory
							.getDriver()).executeScript("return document.readyState")
							.equals("complete");
				}
			});
		} catch (Exception e) {
			System.out.println("Waiting for Loader to dismiss timed out");
		}
	}
}
