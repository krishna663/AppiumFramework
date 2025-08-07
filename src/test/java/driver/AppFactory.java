package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class AppFactory {
    static AppiumDriver driver;

    public static void android_launchApp() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("13.0")
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity");

        driver = new AndroidDriver(new URI("http://localhost:4723/wd/hub").toURL()
                , options);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    public static void ios_launchApp(XCUITestOptions options) throws MalformedURLException, URISyntaxException {
        driver = new IOSDriver(new URI("http://localhost:4723/wd/hub").toURL()
                , options);
        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }

}
