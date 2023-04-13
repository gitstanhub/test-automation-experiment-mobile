package pageobjects.elements;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.CommonPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageElements extends AppiumDriverHandler {

    private final AndroidDriver driver;
    private final CommonPageLocators commonPageLocators = new CommonPageLocators();

    public CommonPageElements() {
        this.driver = getDriver();
    }

    public WebElement getPrimaryTextView() {
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.PRIMARY_TEXT_VIEW)));
        return driver.findElement(By.id(commonPageLocators.PRIMARY_TEXT_VIEW));


//        try {
//            return driver.findElement(By.id(commonPageLocators.PRIMARY_TEXT_VIEW));
//        } catch (StaleElementReferenceException e) {
//            return driver.findElement(By.id(commonPageLocators.PRIMARY_TEXT_VIEW));
//        }
    }


    //        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.PRIMARY_TEXT_VIEW)));
    public WebElement getSecondaryTextView() {
//        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.SECONDARY_TEXT_VIEW)));
        return driver.findElement(By.id(commonPageLocators.SECONDARY_TEXT_VIEW));
    }

    public WebElement getImageViewCentered() {
//        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(commonPageLocators.IMAGE_VIEW_CENTERED)));
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
