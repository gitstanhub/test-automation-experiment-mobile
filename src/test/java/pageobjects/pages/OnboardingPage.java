package pageobjects.pages;

import base.AppiumDriverHandler;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.elements.CommonPageElements;
import pageobjects.elements.OnboardingPageElements;
import utils.assertions.ElementChecks;

public class OnboardingPage extends AppiumDriverHandler {

    ElementChecks elementChecks = new ElementChecks();
    OnboardingPageElements onboardingPageElements = new OnboardingPageElements();
    CommonPageElements commonPageElements = new CommonPageElements();

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

    public OnboardingPage verifyPageTitle(String pageTitleText) {
        try {
            elementChecks.assertElementContainsText(pageTitleText, commonPageElements.getPrimaryTextView());
        } catch (StaleElementReferenceException e) {
            commonPageElements = new CommonPageElements();
            elementChecks.assertElementContainsText(pageTitleText, commonPageElements.getPrimaryTextView());
        }
        return this;
    }

    public OnboardingPage verifyPageBodyText(String pageBodyText) {
        elementChecks.assertElementContainsText(pageBodyText, commonPageElements.getSecondaryTextView());
        return this;
    }

    public OnboardingPage verifyOnboardingImageIsDisplayed() {
        elementChecks.assertElementVisible(commonPageElements.getImageViewCentered());
        return this;
    }


    public OnboardingPage verifySwitchContainerIsDisplayed() {
        elementChecks.assertElementVisible(commonPageElements.getSwitchContainer());
        elementChecks.assertElementVisible(commonPageElements.getSwitchView());
        return this;
    }

    public OnboardingPage verifyDoneButtonIsDisplayed() {
        elementChecks.assertElementVisible(onboardingPageElements.getOnboardingDoneButton());
        return this;
    }

    public OnboardingPage pressDoneButton() {
        onboardingPageElements.getOnboardingDoneButton().click();
        return this;
    }

    public OnboardingPage pressSkipButton() {
        onboardingPageElements.getOnboardingSkipButton().click();
        return this;
    }
}
