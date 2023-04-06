package utils.mobileactions;

import base.AppiumDriverHandler;
import io.appium.java_client.android.AndroidDriver;

public class AppiumMobileDriverActions extends AppiumDriverHandler {

    private AndroidDriver driver;

    public AppiumMobileDriverActions() {
        this.driver = getDriver();
    }


}
