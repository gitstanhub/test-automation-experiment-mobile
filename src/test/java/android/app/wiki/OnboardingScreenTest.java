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


        onboardingPage
                .pressContinueButton()
                .verifyPageTitle("New ways to explore")
                .verifyPageBodyText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \n" +
                        "Customize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.")
                .verifyOnboardingPageIsSelected("Page 2 of 4");
    }
}
