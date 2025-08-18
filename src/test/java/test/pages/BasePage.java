package test.pages;

import driver.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public BasePage()
    {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(30));

    protected WebElement waitForEl(By byLocator)
    {
        return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    protected WebElement getEle(By bylocator)
    {
        return AppDriver.getCurrentDriver().findElement(bylocator);
    }

    protected List<WebElement> getEles(By bylocator)
    {
        return AppDriver.getCurrentDriver().findElements(bylocator);
    }

    protected void click(By bylocator)
    {
        getEle(bylocator).click();
    }

    protected void sendTxt(By bylocator, String txt)
    {
        getEle(bylocator).sendKeys(txt);
    }

    protected void waitNdSend(By bylocator, String txt)
    {
        waitForEl(bylocator);
        getEle(bylocator).clear();
        getEle(bylocator).sendKeys(txt);
    }

    protected void waitNdClick(By bylocator)
    {
        waitForEl(bylocator).click();
    }

    protected int size(By bylocator)
    {
        return getEles(bylocator).size();
    }

    protected String getText(By bylocator)
    {
        return getEle(bylocator).getText();
    }

    protected String getAttribute(By bylocator, String attr)
    {
        return getEle(bylocator).getAttribute(attr);
    }

    protected boolean isListItemContains(List<WebElement> items, String text)
    {
        boolean flag = false;
        for (WebElement el: items)
        {
            if(el.getText().contains(text))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected boolean isTextMatches(WebElement ele, String text){
        return ele.getText().equals(text);
    }

    protected boolean isTextContains(WebElement ele, String text){
        return ele.getText().contains(text);
    }

    protected Set<String> getContext(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContextHandles();
    }

    protected String getCurrentContext(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContext();
    }

    private Select getDropDownElement(By byLocator) {
        return new Select(AppDriver.getCurrentDriver().findElement(byLocator));
    }

    private Select getDropDownElement(WebElement el) {
        return new Select(el);
    }

    public void selectDropDownByOption(By byLocator, String option) {
        getDropDownElement(byLocator).selectByVisibleText(option);
    }

    protected List<WebElement> getDropDownOptions(By byLocator) {
        return getDropDownElement(byLocator).getOptions();
    }

    protected List<WebElement> getDropDownAllSelectedOptions(By byLocator) {
        return getDropDownElement(byLocator).getAllSelectedOptions();
    }

}


