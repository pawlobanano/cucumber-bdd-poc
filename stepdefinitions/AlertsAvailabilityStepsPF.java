package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.HomePagePF;
import pagefactory.LoginPagePF;

public class AlertsAvailabilityStepsPF {

    private WebDriver webDriver;
    private LoginPagePF loginPage;
    private HomePagePF homePage;

    @Before(order = 0)
    public void browserDriverSetup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions().addArguments("--headless", "--window-size=1920,1080");
        webDriver = new ChromeDriver(options);
    }

    @Before(order = 1)
    public void scenarioSetup() {
        this.loginPage = new LoginPagePF(webDriver);
        this.homePage = new HomePagePF(webDriver);
    }

//    @After(order = 0)
//    public void teardown(final Scenario scenario) {
//        if (!scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) webDriver)
//                    .getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", "name");
//        }
//    }

    @After(order = 1)
    public void teardown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Given("browser is open")
    public void browser_is_open() {
        if (webDriver == null) {
            throw new IllegalStateException("WebDriver is not instantiated");
        }
    }

    @And("user is on login page")
    public void user_is_on_login_page() {
        loginPage.checkIfLoginPage();
    }

    @When("^user enters (.*)$")
    public void user_enters_username_and_password(final String username) {
        loginPage.enterUsername(username);
    }

    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        homePage.checkIfHomePage();
    }

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        homePage.checkIfHomePage();
    }

    @Then("at least one alert from all categories is available")
    public void at_least_one_alert_from_all_categories_is_available() {
        homePage.checkIfSumOfAllAlertCategoriesCountersIsGreaterThanZero();
    }

    @Then("alerts counter is valid")
    public void alerts_counter_is_valid() {
        homePage.checkIfAlertsCounterIsValid();
    }

    @And("take screenshot of the home page")
    public void take_screenshot_of_the_home_page() throws IOException {
        homePage.takeScreenshot();
    }

}
