package pageobjects.elements;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.CommonPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.pages.ExplorePage;
import utils.assertions.ElementChecks;

public class ExplorePageElements extends AppiumDriverHandler {

    private final AndroidDriver driver;
    private final CommonPageLocators commonPageLocators = new CommonPageLocators();

    public ExplorePageElements(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getExplorePageHeader() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.MAIN_TOOLBAR)));
        return driver.findElement(By.id(commonPageLocators.MAIN_TOOLBAR));
    }

    public WebElement getExplorePageHeaderLogo() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.MAIN_TOOLBAR_WORDMARK)));
        return driver.findElement(By.id(commonPageLocators.MAIN_TOOLBAR_WORDMARK));
    }

}
