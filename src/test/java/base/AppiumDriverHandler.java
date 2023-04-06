package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AppiumDriverHandler {

    private static AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setApp(System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia.apk")
                .setPlatformName(ANDROID)
                .setAutomationName(ANDROID_UIAUTOMATOR2)
                .setDeviceName("Pixel 6 Pro API 33")
                .setPlatformVersion("13.0")
                .setAppPackage("org.wikipedia")
                .setAppActivity("org.wikipedia.main.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            AppiumDriverHandler appiumDriverHandler = new AppiumDriverHandler();
            try {
                appiumDriverHandler.setUp();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}
