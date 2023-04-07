package android.app.wiki;


import base.WikiAppTestBase;
import org.junit.jupiter.api.Test;
import pageobjects.elements.OnboardingPageElements;

public class OnboardingScreenTest extends WikiAppTestBase {
    OnboardingPageElements onboardingPageElements = new OnboardingPageElements();

    @Test
    public void onboardingScreenTest() {
        onboardingPage.verifyLangListContainerIsVisible();
    }

}
