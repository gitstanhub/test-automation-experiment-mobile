package android.app.wiki;


import base.WikiAppTestBase;
import org.junit.jupiter.api.Test;

public class OnboardingScreenTest extends WikiAppTestBase {

    @Test
    public void onboardingScreenTest() {
        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle("The Free Encyclopedia\n" +
                        "…in over 300 languages")
                .verifyPageBodyText("We’ve found the following on your device:")
                .verifyLangListContainerIsVisible()
                .verifyOnboardingPageIsSelected("Page 1 of 4");


        onboardingPage.pressContinueButton();
    }
}
