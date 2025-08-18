package test.pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    By productPage;
    public ProductPage()
    {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver)
        {
            productPage = AppiumBy.accessibilityId("container header");
        } else if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            productPage = AppiumBy.accessibilityId("container header");
        }
    }

    public boolean waitForProductText()
    {
        return waitForEl(productPage).isDisplayed();
    }


}
