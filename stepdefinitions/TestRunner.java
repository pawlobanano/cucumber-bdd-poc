package stepdefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "stepdefinitions" },
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/reports/cucumber/cucumber-report.html",
                "json:target/reports/cucumber/cucumber-report.json",
                "junit:target/reports/cucumber/cucumber-report.xml" },
        tags = "@Regression and @GoLive and @AlertsAvailability and @SEAEXPD-0001")
public class TestRunner {

}
