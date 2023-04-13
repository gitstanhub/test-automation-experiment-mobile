package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AppiumDriverHandler {

    private static AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        String deviceHost = "physical";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();


        if (deviceHost.equals("emulator")) {
            desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 Pro API 33");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
            desiredCapabilities.setCapability("appPackage", "org.wikipedia");
            desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);

        } else if (deviceHost.equals("physical")) {
            desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
            desiredCapabilities.setCapability(MobileCapabilityType.UDID, "01021FFBA000PH");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL Android 13");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
            desiredCapabilities.setCapability("appPackage", "org.wikipedia");
            desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
        } else if (deviceHost.equals("browserstack")) {
            desiredCapabilities.setCapability("device", "Google Pixel 7 Pro");
            desiredCapabilities.setCapability("os_version", "13.0");
        } else {
            System.out.println("Unknown device host type");
        }


//        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options()
//                .setApp(System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia.apk")
//                .setPlatformName(ANDROID)
//                .setAutomationName(ANDROID_UIAUTOMATOR2)
//                .setDeviceName("Pixel 6 Pro API 33")
//                .setPlatformVersion("13.0")
//                .setAppPackage("org.wikipedia")
//                .setAppActivity("org.wikipedia.main.MainActivity");

//        uiAutomator2Options.setCapability(MobileCapabilityType.UDID, "emulator-5554");
//        uiAutomator2Options.setCapability(MobileCapabilityType.UDID, "01021FFBA000PH");


//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
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

    public WebDriverWait getWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }
}
