package android.app.wiki;


import base.WikiAppTestBase;
import org.junit.jupiter.api.Test;

public class OnboardingScreenTest extends WikiAppTestBase {

    @Test
    public void onboardingScreenTest() {
        onboardingPage.verifyLangListContainerIsVisible()
                .verifyOnboardingPageIsSelected("Page 1 of 4")
                .pressContinueButton();
    }

}
