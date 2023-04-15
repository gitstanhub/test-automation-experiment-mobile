package base;

import io.appium.java_client.android.AndroidDriver;
import pageobjects.pages.ExplorePage;
import pageobjects.pages.NavTab;
import pageobjects.pages.OnboardingPage;

public class WikiAppTestBase extends AppiumDriverHandler {
    public OnboardingPage onboardingPage;
    public ExplorePage explorePage;
    public NavTab navTab;

    public WikiAppTestBase() {
        AndroidDriver driver = getDriver();
        onboardingPage = new OnboardingPage(driver);
        explorePage = new ExplorePage(driver);
        navTab = new NavTab();
    }
}
