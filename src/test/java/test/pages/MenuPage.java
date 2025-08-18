package test.pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage{

    By menuOption;

    public MenuPage()
    {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver)
        {
            menuOption = AppiumBy.accessibilityId("open menu");
        } else if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            menuOption = AppiumBy.accessibilityId("open menu");
        }
    }

    @AndroidFindBy(accessibility = "menu item log in")
    public WebElement menuLogin;

    public void navigateToLogin() {
        waitNdClick(menuOption);
        menuLogin.click();
    }
}
