package pageobjects.pages;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.C;
import pageobjects.elements.CommonPageElements;
import pageobjects.elements.ExplorePageElements;
import utils.assertions.ElementChecks;

public class ExplorePage extends AppiumDriverHandler {

    private final ExplorePageElements explorePageElements;
    private final CommonPageElements commonPageElements;
    private final ElementChecks elementChecks;

    public ExplorePage(AndroidDriver driver) {
        explorePageElements = new ExplorePageElements(driver);
        commonPageElements = new CommonPageElements(driver);
        elementChecks = new ElementChecks();
    }

    public ExplorePage verifyExplorePageHeaderIsDisplayed() {
        elementChecks.assertElementVisible(explorePageElements.getExplorePageHeader());
        elementChecks.assertElementVisible(explorePageElements.getExplorePageHeaderLogo());
        return this;
    }

    public ExplorePage verifySearchBarIsDisplayed() {
        elementChecks.assertElementVisible(commonPageElements.getSearchBar());
        return this;
    }
}
