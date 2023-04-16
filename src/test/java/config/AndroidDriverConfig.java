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

    @Key("remoteUrl")
    String remoteUrl();

    @Key("browserstackBuildName")
    String browserstackBuildName();

    @Key("browserstackRemoteUrl")
    String browserstackRemoteUrl();

    @Key("browserstackProjectName")
    String browserstackProjectName();

    @Key("browserstackTestRunName")
    String browserstackTestRunName();

    @Key("browserstackDebug")
    boolean browserstackDebug();

    @Key("browserstackAppUrl")
    String browserstackAppUrl();

    @Key("browserstackUsername")
    String browserstackUsername();

    @Key("browserstackAccessToken")
    String browserstackAccessToken();

    @Key("browserstackPlatformName")
    String browserstackPlatformName();
}
