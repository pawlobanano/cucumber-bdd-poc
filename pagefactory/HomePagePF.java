package pagefactory;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePagePF {

    private static final String URL_HOME_PAGE = "http://localhost:8080/se/se/home";
    private static final String ALERTS_AVAILABILITY_FEATURE_PNG_PATH = "out/test/resources/features/screenshots/alertsAvailabilityFeature.png";
    private static final String ALERTS_COUNTER_PATTERN = "^(\\d+) \\/ (\\d+)$";
    private final WebDriver driver;
    private int alertsSum = 0;

    @FindBy(
            xpath = "/html/body/sen-root/sen-dialog-frame/sen-home-dialog/sen-alerts-regions/div/div[2]/sen-alerts-map/form/div[1]/label/span[4]")
    private WebElement weatherAlertsCounter;
    @FindBy(
            xpath = "/html/body/sen-root/sen-dialog-frame/sen-home-dialog/sen-alerts-regions/div/div[2]/sen-alerts-map/form/div[2]/label/span[4]")
    private WebElement vesselAlertsCounter;
    @FindBy(
            xpath = "/html/body/sen-root/sen-dialog-frame/sen-home-dialog/sen-alerts-regions/div/div[2]/sen-alerts-map/form/div[3]/label/span[4]")
    private WebElement portAlertsCounter;
    @FindBy(
            xpath = "/html/body/sen-root/sen-dialog-frame/sen-home-dialog/sen-alerts-regions/div/div[2]/sen-alerts-map/form/div[4]/label/span[4]")
    private WebElement generalAlertsCounter;
    @FindBy(xpath = "/html/body/sen-root/sen-dialog-frame/sen-home-dialog/sen-alerts-regions/div/div[2]/div/div/span/span")
    private WebElement alertsCounter;

    public HomePagePF(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.navigate().to(URL_HOME_PAGE);
    }

    public void checkIfHomePage() {
        if (!driver.getCurrentUrl().contentEquals(URL_HOME_PAGE)) {
            throw new IllegalStateException("This is not the Home Page. The current page is " + driver.getCurrentUrl());
        }
    }

    public void takeScreenshot() throws IOException {
        final TakesScreenshot screenshot = ((TakesScreenshot) driver);
        final File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        final File destFile = new File(ALERTS_AVAILABILITY_FEATURE_PNG_PATH);
        FileUtils.copyFile(srcFile, destFile);
    }

    public void checkIfSumOfAllAlertCategoriesCountersIsGreaterThanZero() {
        this.alertsSum = weatherAlerts() + vesselAlerts() + portAlerts() + generalAlerts();

        assertThat(this.alertsSum > 0).isTrue();
    }

    public void checkIfAlertsCounterIsValid() {
        Pattern pattern = Pattern.compile(ALERTS_COUNTER_PATTERN);
        Matcher matcher = pattern.matcher(alertsCounter.getText());
        matcher.matches();

        assertThat(matcher.group(1)).isEqualTo(String.valueOf(this.alertsSum));
        assertThat(matcher.group(2)).isEqualTo(String.valueOf(this.alertsSum));
    }

    private int weatherAlerts() {
        return getInt(weatherAlertsCounter.getText());
    }

    private int vesselAlerts() {
        return getInt(vesselAlertsCounter.getText());
    }

    private int portAlerts() {
        return getInt(portAlertsCounter.getText());
    }

    private int generalAlerts() {
        return getInt(generalAlertsCounter.getText());
    }

    private int getInt(final String s) {
        return NumberUtils.toInt(s.replaceAll("[()]", ""));
    }

}
