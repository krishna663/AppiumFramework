package test.pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    By userName;
    By password;
    By usernameError;
    By passwordError;
    By invalidCredentialsError;


    public LoginPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
            usernameError = By.xpath("//android.widget.TextView[@text=\"Username is required\"]");
            passwordError = By.xpath("//android.widget.TextView[@text=\"Password is required\"]");
            invalidCredentialsError = By.xpath("//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]");

        } else if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
        }
    }

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement Password;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Login\"])[2]")
    public WebElement btnLogin;

    MenuPage menuPage = new MenuPage();

    public void login(String username, String password) {
        waitNdSend(userName, username);
        Password.clear();
        Password.sendKeys(password);
        btnLogin.click();
    }

    public String getUsernameErrorText()
    {
        return getText(usernameError);
    }

    public String getPasswordErrorText()
    {
        return getText(passwordError);
    }
    public String getInvalidCredentialErrorMessage()
    {
        return getText(invalidCredentialsError);
    }


}



