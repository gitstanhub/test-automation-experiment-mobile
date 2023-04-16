package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configuration/${deviceHost}.properties"
})

public interface AndroidDriverConfig extends Config {

    @Key("deviceHost")
    String deviceHost();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("udid")
    String udid();

    @Key("appRootPath")
    String appRootPath();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("buildName")
    String buildName();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("projectName")
    String projectName();

    @Key("testRunName")
    String testRunName();

    @Key("browserStackDebug")
    boolean browserStackDebug();

    @Key("browserStackAppUrl")
    String browserStackAppUrl();

    @Key("browserStackUsername")
    String browserStackUsername();

    @Key("browserStackAccessToken")
    String browserStackAccessToken();
}
