package pageobjects.pages;

import base.AppiumDriverHandler;
import pageobjects.elements.OnboardingPageElements;
import utils.assertions.ElementChecks;

public class OnboardingPage extends AppiumDriverHandler {

    ElementChecks elementChecks = new ElementChecks();
    OnboardingPageElements onboardingPageElements = new OnboardingPageElements();

    public OnboardingPage verifyLangListContainerIsVisible() {
        elementChecks.assertElementVisible(onboardingPageElements.getLangListContainer());
        elementChecks.assertElementVisible(onboardingPageElements.getLangList());
        elementChecks.assertElementVisible(onboardingPageElements.getAddLangContainer());

        return this;
    }

    public OnboardingPage verifyOnboardingPageIsSelected(String pageNumberAccessibilityData) {
        elementChecks.assertElementAccessibilityId(pageNumberAccessibilityData, onboardingPageElements.getOnboardingPageIndicator());
        return this;
    }

    public OnboardingPage pressContinueButton() {
        onboardingPageElements.getOnboardingForwardButton().click();
        return this;
    }
}
