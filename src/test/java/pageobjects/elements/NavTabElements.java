package pageobjects.elements;

import driver.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.NavTabLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavTabElements extends AppiumDriverHandler {

    private final AndroidDriver driver;
    private final NavTabLocators navTabLocators = new NavTabLocators();

    public NavTabElements(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getNavTab() {
        return driver.findElement(By.id(navTabLocators.NAV_TAB_CONTAINER));
    }

    public WebElement getExploreButton() {
       return driver.findElement(By.id(navTabLocators.NAV_TAB_EXPLORE_BUTTON));
    }

    public WebElement getSavedButton() {
        return driver.findElement(By.id(navTabLocators.NAV_TAB_SAVED_BUTTON));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.id(navTabLocators.NAV_TAB_SEARCH_BUTTON));
    }

    public WebElement getEditsButton() {
        return driver.findElement(By.id(navTabLocators.NAV_TAB_EDITS_BUTTON));
    }

    public WebElement getMoreButton() {
        return driver.findElement(By.id(navTabLocators.NAV_TAB_MORE_BUTTON));
    }

    public WebElement getNavTabButtonLabel() {
        return driver.findElement(By.id(navTabLocators.NAV_TAB_COMMON_BUTTON_LABEL));
    }
}
