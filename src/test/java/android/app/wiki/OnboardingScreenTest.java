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
                .verifyOnboardingPageIsSelected("Page 1 of 4")
                .pressContinueButton();

        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle("New ways to explore")
                .verifyPageBodyText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \n" +
                        "Customize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.")
                .verifyOnboardingPageIsSelected("Page 2 of 4")
                .pressContinueButton();

        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle("Reading lists with sync")
                .verifyPageBodyText("You can make reading lists from articles you want to read later, even when you’re offline. \n" +
                        "Login to your Wikipedia account to sync your reading lists. Join Wikipedia")
                .verifyOnboardingPageIsSelected("Page 3 of 4")
                .pressContinueButton();

        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle("Send anonymous data")
                .verifyPageBodyText("Help make the app better by letting us know how you use it. Data collected is anonymous. Learn more")
                .verifySwitchContainerIsDisplayed()
                .verifyOnboardingPageIsSelected("Page 4 of 4")
                .pressDoneButton();

        explorePage.verifyExplorePageHeaderIsDisplayed();
        navTab.verifyNavTabIsDisplayed()
                .verifyExploreButtonIsDisplayed()
                .verifySavedButtonIsDisplayed()
                .verifySearchButtonIsDisplayed()
                .verifyEditsButtonIsDisplayed()
                .verifyMoreButtonIsDisplayed();
    }
}
