package pageobjects.elements;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.OnboardingPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnboardingPageElements extends AppiumDriverHandler {

    private final AndroidDriver driver;

    public OnboardingPageElements() {
        this.driver = getDriver();
    }

    public OnboardingPageLocators onboardingPageLocators = new OnboardingPageLocators();

    WebElement addLangContainer = getDriver().findElement(By.id(onboardingPageLocators.ADD_LANG_CONTAINER));

    public WebElement getAddLangContainer() {
        return addLangContainer;
    }
}
