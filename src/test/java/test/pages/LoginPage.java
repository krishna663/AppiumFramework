package test.pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    By userName;
    By passWord;

    public LoginPage()
    {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver)
        {
            userName = AppiumBy.accessibilityId("Username input field");
        } else if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
        }
    }

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement Password;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Login\"])[2]")
    private WebElement btnLogin;

    MenuPage menuPage = new MenuPage();

    public void login(String username, String password)
    {
        waitNdSend(userName, username);
        Password.sendKeys(password);
        btnLogin.click();
    }
}


