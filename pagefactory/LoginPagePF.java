package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {

    private final WebDriver driver;
    private static final String URL_LOGIN_PAGE = "http://localhost:8080/se/ssomock/gate/idp/SAML2/SSO/Redirect?SAMLRequest=";

    @FindBy(id = "login")
    private WebElement btn_login;

    @FindBy(id = "username")
    private WebElement form_input_username;

    public LoginPagePF(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.navigate().to(URL_LOGIN_PAGE);
    }

    public void checkIfLoginPage() {
        if (!driver.getCurrentUrl().startsWith("http://localhost:8080/se/ssomock/gate/idp/SAML2/SSO/Redirect?SAMLRequest=")) {
            throw new IllegalStateException("This is not the Login Page. The current page is " + driver.getCurrentUrl());
        }
    }

    public void enterUsername(final String username) {
        form_input_username.sendKeys(username);
    }

    public void clickOnLoginButton() {
        btn_login.click();
    }

}
