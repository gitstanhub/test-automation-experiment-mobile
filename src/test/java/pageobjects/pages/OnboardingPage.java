package pageobjects.pages;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import locators.OnboardingPageLocators;
import pageobjects.elements.OnboardingPageElements;
import utils.assertions.ElementChecks;

public class OnboardingPage extends AppiumDriverHandler {

    ElementChecks elementChecks = new ElementChecks();
    OnboardingPageElements onboardingPageElements = new OnboardingPageElements();

    public OnboardingPage verifyAddLangContainerIsVisible() {
        elementChecks.assertElementVisible(onboardingPageElements.getAddLangContainer());
        return this;
    }

}
