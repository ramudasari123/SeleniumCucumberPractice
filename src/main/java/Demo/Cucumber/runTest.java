package Demo.Cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = "src/test/java/scenarios", plugin = { "pretty", "html:target/cucumber-html-report" }, tags={"@smokeTest"})
public class runTest extends AbstractTestNGCucumberTests{
	
}