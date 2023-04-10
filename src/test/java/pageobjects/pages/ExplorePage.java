package pageobjects.pages;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.C;
import pageobjects.elements.CommonPageElements;
import pageobjects.elements.ExplorePageElements;
import utils.assertions.ElementChecks;

public class ExplorePage extends AppiumDriverHandler {

    private final AndroidDriver driver;
    private final ExplorePageElements explorePageElements = new ExplorePageElements();
    private final CommonPageElements commonPageElements = new CommonPageElements();
    private final ElementChecks elementChecks = new ElementChecks();

    public ExplorePage() {
        this.driver = getDriver();
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
