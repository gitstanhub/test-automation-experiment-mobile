package android.app.wiki;


import android.app.wiki.base.WikiAppTestBase;
import org.junit.jupiter.api.Test;

public class OnboardingScreenTests extends WikiAppTestBase {

    @Test
    public void onboardingCompleteFlowTest() {
        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle(onboardingPageConstants.FIRST_PAGE_TITLE)
                .verifyPageBodyText(onboardingPageConstants.FIRST_PAGE_BODY_TEXT)
                .verifyLangListContainerIsVisible()
                .verifyOnboardingPageIsSelected(onboardingPageConstants.FIRST_PAGE_INDICATOR_TEXT)
                .pressContinueButton();

        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle(onboardingPageConstants.SECOND_PAGE_TITLE)
                .verifyPageBodyText(onboardingPageConstants.SECOND_PAGE_BODY_TEXT)
                .verifyOnboardingPageIsSelected(onboardingPageConstants.SECOND_PAGE_INDICATOR_TEXT)
                .pressContinueButton();

        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle(onboardingPageConstants.THIRD_PAGE_TITLE)
                .verifyPageBodyText(onboardingPageConstants.THIRD_PAGE_BODY_TEXT)
                .verifyOnboardingPageIsSelected(onboardingPageConstants.THIRD_PAGE_INDICATOR_TEXT)
                .pressContinueButton();

        onboardingPage
                .verifyOnboardingImageIsDisplayed()
                .verifyPageTitle(onboardingPageConstants.FOURTH_PAGE_TITLE)
                .verifyPageBodyText(onboardingPageConstants.FOURTH_PAGE_BODY_TEXT)
                .verifySwitchContainerIsDisplayed()
                .verifyOnboardingPageIsSelected(onboardingPageConstants.FOURTH_PAGE_INDICATOR_TEXT)
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
