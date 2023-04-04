package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AppiumDriverHandler {

    private AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setUp() throws MalformedURLException {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
                .setApp("src/test/resources/apk/org.wikipedia.apk")
                .setPlatformName(ANDROID)
                .setAutomationName(ANDROID_UIAUTOMATOR2);
    }
}
