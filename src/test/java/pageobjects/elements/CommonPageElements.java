package pageobjects.elements;

import driver.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.CommonPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonPageElements extends AppiumDriverHandler {

    private final AndroidDriver driver;
    private final CommonPageLocators commonPageLocators = new CommonPageLocators();

    public CommonPageElements(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getPrimaryTextView() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.PRIMARY_TEXT_VIEW)));
        return driver.findElement(By.id(commonPageLocators.PRIMARY_TEXT_VIEW));
    }

    public WebElement getSecondaryTextView() {
        return driver.findElement(By.id(commonPageLocators.SECONDARY_TEXT_VIEW));
    }

    public WebElement getImageViewCentered() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.IMAGE_VIEW_CENTERED)));
        return driver.findElement(By.id(commonPageLocators.IMAGE_VIEW_CENTERED));
    }

    public WebElement getSwitchContainer() {
        return driver.findElement(By.id(commonPageLocators.SWITCH_CONTAINER));
    }

    public WebElement getSwitchView() {
        return driver.findElement(By.id(commonPageLocators.SWITCH_VIEW));
    }

    public WebElement getSearchBar() {
        return driver.findElement(By.id(commonPageLocators.SECONDARY_TEXT_VIEW));
    }
}
