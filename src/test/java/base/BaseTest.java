package base;

import driver.AppDriver;
import driver.AppFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class BaseTest {

    @BeforeClass
    public static void launchApp() throws MalformedURLException, URISyntaxException {
        AppFactory.launchApp();
    }

    @AfterMethod
    public static void closeApp(ITestResult result) throws MalformedURLException, URISyntaxException {
//        AppDriver.getCurrentDriver().quit();
//        AppiumServer.stop();
        if (result.getStatus() == ITestResult.FAILURE)
        {
//            Util.captureFullPageShot(result.getTestName());
        }
    }

        @BeforeSuite
    public static void serverStart()
    {
        AppiumServer.start();
    }

    @AfterSuite
    public static void serverStop()
    {
        AppiumServer.stop();
    }
}

