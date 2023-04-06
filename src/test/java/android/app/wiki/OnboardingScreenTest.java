package android.app.wiki;


import base.WikiAppTestBase;
import org.junit.jupiter.api.Test;

public class OnboardingScreenTest extends WikiAppTestBase {

    @Test
    public void onboardingScreenTest() {
        onboardingPage.verifyAddLangContainerIsVisible();
    }

}
