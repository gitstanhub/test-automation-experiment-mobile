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
                desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + androidConfig.appRootPath());
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, androidConfig.udid());
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, androidConfig.deviceName());
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidConfig.platformVersion());
                desiredCapabilities.setCapability("appPackage", androidConfig.appPackage());
                desiredCapabilities.setCapability("appActivity", androidConfig.appActivity());
                driver = new AndroidDriver(new URL(androidConfig.remoteUrl()), desiredCapabilities);
                System.out.println("Emulator is selected");
                break;

            case "real-device":
                desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + androidConfig.appRootPath());
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, androidConfig.udid());
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, androidConfig.deviceName());
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, androidConfig.platformVersion());
                desiredCapabilities.setCapability("appPackage", androidConfig.appPackage());
                desiredCapabilities.setCapability("appActivity", androidConfig.appActivity());
                driver = new AndroidDriver(new URL(androidConfig.remoteUrl()), desiredCapabilities);
                System.out.println("Real device is selected");
                break;

            case "browserstack":
                desiredCapabilities.setCapability("deviceName", androidConfig.deviceName());
                desiredCapabilities.setCapability("platformVersion", androidConfig.platformVersion());
                desiredCapabilities.setCapability("platformName", androidConfig.browserstackPlatformName());
                desiredCapabilities.setCapability("project", androidConfig.browserstackProjectName());
                desiredCapabilities.setCapability("build", androidConfig.browserstackBuildName());
                desiredCapabilities.setCapability("name", androidConfig.browserstackTestRunName());
                desiredCapabilities.setCapability("browserstack.debug", androidConfig.browserstackDebug());
                desiredCapabilities.setCapability("app", androidConfig.browserstackAppUrl());
                driver = new AndroidDriver(new URL(String.format(androidConfig.browserstackRemoteUrl(), androidConfig.browserstackUsername(), androidConfig.browserstackAccessToken())), desiredCapabilities);
                System.out.println("Browserstack is selected");
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
