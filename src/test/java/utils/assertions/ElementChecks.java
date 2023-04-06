package utils.assertions;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class ElementChecks extends AppiumDriverHandler {

    private AndroidDriver driver;

    public ElementChecks() {
        this.driver = getDriver();
    }

    public void assertElementVisible(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "Element " + element.toString() + " is not visible");
    }
}
