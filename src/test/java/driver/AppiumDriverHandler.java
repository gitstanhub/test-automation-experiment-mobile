package driver;

import config.BrowserstackDriverConfig;
import config.EmulatorDriverConfig;
import config.ConfigReader;
import config.RealDeviceDriverConfig;
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
    private static final EmulatorDriverConfig emulatorDriverConfig = ConfigReader.getConfigReader().getEmulatorDriverConfig();
    private static final RealDeviceDriverConfig realDeviceDriverConfig = ConfigReader.getConfigReader().getRealDeviceDriverConfig();
    private static final BrowserstackDriverConfig browserstackDriverConfig = ConfigReader.getConfigReader().getBrowserstackDriverConfig();
    private static AndroidDriver driver;
    private WebDriverWait wait;

    public void setUp() throws MalformedURLException {
        String deviceHost = System.getProperty("deviceHost");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        if (deviceHost != null) {
            switch (deviceHost) {
                case "emulator":
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + emulatorDriverConfig.appRootPath());
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
                    desiredCapabilities.setCapability(MobileCapabilityType.UDID, emulatorDriverConfig.udid());
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorDriverConfig.deviceName());
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, emulatorDriverConfig.platformVersion());
                    desiredCapabilities.setCapability("appPackage", emulatorDriverConfig.appPackage());
                    desiredCapabilities.setCapability("appActivity", emulatorDriverConfig.appActivity());
                    driver = new AndroidDriver(new URL(emulatorDriverConfig.remoteUrl()), desiredCapabilities);
                    System.out.println("Emulator device is selected");
                    break;

                case "real-device":
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + realDeviceDriverConfig.appRootPath());
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
                    desiredCapabilities.setCapability(MobileCapabilityType.UDID, realDeviceDriverConfig.udid());
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, realDeviceDriverConfig.deviceName());
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, realDeviceDriverConfig.platformVersion());
                    desiredCapabilities.setCapability("appPackage", realDeviceDriverConfig.appPackage());
                    desiredCapabilities.setCapability("appActivity", realDeviceDriverConfig.appActivity());
                    driver = new AndroidDriver(new URL(realDeviceDriverConfig.remoteUrl()), desiredCapabilities);
                    System.out.println("Real device is selected");
                    break;

                case "browserstack":
                    desiredCapabilities.setCapability("deviceName", browserstackDriverConfig.deviceName());
                    desiredCapabilities.setCapability("platformVersion", browserstackDriverConfig.platformVersion());
                    desiredCapabilities.setCapability("platformName", browserstackDriverConfig.browserstackPlatformName());
                    desiredCapabilities.setCapability("project", browserstackDriverConfig.browserstackProjectName());
                    desiredCapabilities.setCapability("build", browserstackDriverConfig.browserstackBuildName());
                    desiredCapabilities.setCapability("name", browserstackDriverConfig.browserstackTestRunName());
                    desiredCapabilities.setCapability("browserstack.debug", browserstackDriverConfig.browserstackDebug());
                    desiredCapabilities.setCapability("app", browserstackDriverConfig.browserstackAppUrl());
                    driver = new AndroidDriver(new URL(String.format(browserstackDriverConfig.browserstackRemoteUrl(), browserstackDriverConfig.browserstackUsername(), browserstackDriverConfig.browserstackAccessToken())), desiredCapabilities);
                    System.out.println("Browserstack device is selected");
                    break;

                default:
                    throw new IllegalArgumentException("Unknown Device Host type. Allowed: emulator, real-device, browserstack.");
            }
        } else {
            throw new IllegalArgumentException("Device Host property cannot be null. Make sure to pass the valid property value.");
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
