package pageobjects.elements;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.OnboardingPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OnboardingPageElements extends AppiumDriverHandler {

    private final AndroidDriver driver;

    private final OnboardingPageLocators onboardingPageLocators = new OnboardingPageLocators();


    public OnboardingPageElements(AndroidDriver driver) {
        this.driver = driver;
    }

    public WebElement getLangListContainer() {
        return driver.findElement(By.id(onboardingPageLocators.LANG_LIST_CONTAINER));
    }

    public WebElement getLangList() {
        return driver.findElement(By.id(onboardingPageLocators.LANG_LIST));
    }

    public WebElement getAddLangContainer() {
        return driver.findElement(By.id(onboardingPageLocators.ADD_LANG_CONTAINER));
    }

    public WebElement getOnboardingSkipButton() {
        return driver.findElement(By.id(onboardingPageLocators.ONBOARDING_SKIP_BUTTON));
    }

    public WebElement getOnboardingPageIndicator() {
        return driver.findElement(By.id(onboardingPageLocators.ONBOARDING_PAGE_INDICATOR));
    }

    public WebElement getOnboardingForwardButton() {
        return driver.findElement(By.id(onboardingPageLocators.ONBOARDING_FORWARD_BUTTON));
    }

    public WebElement getOnboardingDoneButton() {
        return driver.findElement(By.id(onboardingPageLocators.ONBOARDING_DONE_BUTTON));
    }
}
