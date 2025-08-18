package test.suite;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.pages.LoginPage;
import test.pages.MenuPage;
import test.pages.ProductPage;

public class LoginTest extends BaseTest{

    @Test
    public void launcAppTest()
    {
        MenuPage menuPage = new MenuPage();
        LoginPage loginpPage = new LoginPage();
        ProductPage productPage = new ProductPage();

        menuPage.navigateToLogin();
        loginpPage.login("bob@example.com","10203040");
        Assert.assertTrue(productPage.waitForProductText());

    }
}
