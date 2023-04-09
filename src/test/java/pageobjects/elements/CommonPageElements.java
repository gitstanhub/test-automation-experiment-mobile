package pageobjects.elements;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.CommonPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonPageElements extends AppiumDriverHandler {

    private final AndroidDriver driver;
    public CommonPageLocators commonPageLocators = new CommonPageLocators();

    public CommonPageElements() {
        this.driver = getDriver();
    }

    public WebElement getPrimaryTextView() {
        return driver.findElement(By.id(commonPageLocators.PRIMARY_TEXT_VIEW));
    }

    public WebElement getSecondaryTextView() {
        return driver.findElement(By.id(commonPageLocators.SECONDARY_TEXT_VIEW));
    }

    public WebElement getImageViewCentered() {
        return driver.findElement(By.id(commonPageLocators.IMAGE_VIEW_CENTERED));
    }
}
