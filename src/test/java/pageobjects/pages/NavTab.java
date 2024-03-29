package pageobjects.pages;

import driver.AppiumDriverHandler;
import pageobjects.elements.NavTabElements;
import utils.assertions.ElementChecks;

public class NavTab extends AppiumDriverHandler {

    private final ElementChecks elementChecks = new ElementChecks();
    private final NavTabElements navTabElements = new NavTabElements(getDriver());

    public NavTab verifyNavTabIsDisplayed() {
        elementChecks.assertElementVisible(navTabElements.getNavTab());
        return this;
    }

    public NavTab verifyExploreButtonIsDisplayed() {
        elementChecks.assertElementVisible(navTabElements.getExploreButton());
        return this;
    }

    public NavTab verifySavedButtonIsDisplayed() {
        elementChecks.assertElementVisible(navTabElements.getSavedButton());
        return this;
    }

    public NavTab verifySearchButtonIsDisplayed() {
        elementChecks.assertElementVisible(navTabElements.getSearchButton());
        return this;
    }

    public NavTab verifyEditsButtonIsDisplayed() {
        elementChecks.assertElementVisible(navTabElements.getEditsButton());
        return this;
    }

    public NavTab verifyMoreButtonIsDisplayed() {
        elementChecks.assertElementVisible(navTabElements.getMoreButton());
        return this;
    }
}
