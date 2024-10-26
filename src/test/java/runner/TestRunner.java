package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = {"src//test//java//features"},
        glue = {"stepdefinitions", "utils"},
        plugin = {"pretty", "html:target/cucumber"},
        tags = "@appium "
)
@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
