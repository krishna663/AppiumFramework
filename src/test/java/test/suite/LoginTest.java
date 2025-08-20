package test.suite;

import base.BaseTest;
import base.dataprovider.ExcelDataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.pages.LoginPage;
import test.pages.MenuPage;
import test.pages.ProductPage;

public class LoginTest extends BaseTest {

    MenuPage menuPage;
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeClass
    void setup() {
        menuPage = new MenuPage();
        loginPage = new LoginPage();
        productPage = new ProductPage();
        menuPage.navigateToLogin();
    }

    @Test(priority = 4)
    public void validLoginTest() {
//        menuPage.navigateToLogin();
        loginPage.login("bob@example.com", "10203040");
        Assert.assertTrue(productPage.waitForProductText());
    }

    @Test(priority = 1)
    public void usernameEmptyTest() {
        loginPage.login("", "10203040");
        Assert.assertEquals(loginPage.getUsernameErrorText(), "Username is required");

    }

    @Test(priority = 2)
    public void passwordEmptyTest() {
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), "Password is required");

    }

//    @Test (priority = 3)
//    public void invalidLoginTest()
//    {
//        menuPage.navigateToLogin();
//        loginPage.login("bob@example.com","10203040");
//        Assert.assertTrue(productPage.waitForProductText());
//
//    }

    @Test(priority = 3, dataProvider = "excelDataProvider", dataProviderClass = ExcelDataProviders.class)
    public void testInvalidLogin(String username, String password, String expectedMessage) {
        System.out.println("Testing login with: " + username + " | " + password);
        System.out.println("Expecting: " + expectedMessage);
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getInvalidCredentialErrorMessage(), expectedMessage);
    }
}