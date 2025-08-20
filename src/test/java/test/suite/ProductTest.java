package test.suite;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.pages.LoginPage;
import test.pages.MenuPage;
import test.pages.ProductPage;

public class ProductTest extends BaseTest {


    MenuPage menuPage;
    LoginPage loginPage;
    ProductPage productPage;

    @Test
    public void productValidateTest() throws InterruptedException {
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        productPage = new ProductPage();

        Assert.assertEquals(productPage.getItemsCount(), 6);
        productPage.sortBy();
        Assert.assertEquals(productPage.getFirstItemPrice(), "$29.99");
        Assert.assertEquals(productPage.getFirstItemName(), "Sauce Labs Backpack");
    }

}
