package utils.assertions;

import driver.AppiumDriverHandler;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class ElementChecks extends AppiumDriverHandler {

    public void assertElementVisible(WebElement element) {
        Assertions.assertTrue(element.isDisplayed(), "Element with id: " + element.getAttribute("resource-id") + " is not visible");
    }

    public void assertElementAccessibilityId(String expectedValue, WebElement element) {
        Assertions.assertEquals(expectedValue, element.getAttribute("content-desc"));
    }

    public void assertElementContainsText(String expectedText, WebElement element) {
        Assertions.assertEquals(expectedText, element.getText());
    }
}
