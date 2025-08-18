package test.pages;

import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    By productPage;
    By itemNames;
    By sortByOption = AppiumBy.accessibilityId("sort button");
    By ascendingOption = AppiumBy.accessibilityId("nameAsc");
    By descendingOption = AppiumBy.accessibilityId("nameDesc");
    By priceAscendingOption = AppiumBy.accessibilityId("priceAsc");
    By priceDescendingOption = AppiumBy.accessibilityId("priceDesc");
    By firstItemName;
    By firstItemPrice;


    public ProductPage()
    {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver)
        {
            productPage = AppiumBy.accessibilityId("container header");
            itemNames = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item price']");
            firstItemName = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item text'])[1]");
            firstItemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item price'])[1]");

        } else if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            productPage = AppiumBy.accessibilityId("container header");
        }
    }

    public boolean waitForProductText()
    {
        return waitForEl(productPage).isDisplayed();
    }

    public String getFirstItemName() {
        return getText(firstItemName);
    }
    public String getFirstItemPrice() throws InterruptedException {
        Thread.sleep(100);
        return getText(firstItemPrice);
    }

    public int getItemsCount() throws InterruptedException {
        int count = Util.getItems(itemNames).size();
        System.out.println(count);
        return count;
    }

    public void sortBy()
    {
        waitNdClick(sortByOption);
        waitNdClick(ascendingOption);
    }
}
