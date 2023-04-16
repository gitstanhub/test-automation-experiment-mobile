package base;

import config.AndroidDriverConfig;
import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AppiumDriverHandler {
    private static final AndroidDriverConfig androidConfig = ConfigReader.getConfigReader().getAndroidDriverConfig();
    private static AndroidDriver driver;
    private WebDriverWait wait;

    public void setUp() throws MalformedURLException {
        String deviceHost = androidConfig.deviceHost();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        switch (deviceHost) {
            case "emulator":
                desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia.apk");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6 Pro API 33");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
                desiredCapabilities.setCapability("appPackage", "org.wikipedia");
                desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
                break;

            case "realdevice":
                desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/apk/org.wikipedia.apk");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, "01021FFBA000PH");
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4 XL Android 13");
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
                desiredCapabilities.setCapability("appPackage", "org.wikipedia");
                desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), desiredCapabilities);
                break;

            case "browserstack":
                desiredCapabilities.setCapability("deviceName", "Google Pixel 7 Pro");
                desiredCapabilities.setCapability("platformVersion", "13.0");
                desiredCapabilities.setCapability("platformName", "android");
                desiredCapabilities.setCapability("project", "Experiment UI Automation project - Wiki Android");
                desiredCapabilities.setCapability("build", "Android test build");
                desiredCapabilities.setCapability("name", "OnboardingScreenTest");
                desiredCapabilities.setCapability("browserstack.debug", true);
                desiredCapabilities.setCapability("app", "app_url");
                driver = new AndroidDriver(new URL("http://" + "username" + ":" + "access" + "@" + "hub-cloud.browserstack.com" + "/wd/hub"), desiredCapabilities);
                break;

            default:
                throw new IllegalArgumentException("Unknown device host type");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.removeApp("org.wikipedia");
            driver.quit();
            driver = null;
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
