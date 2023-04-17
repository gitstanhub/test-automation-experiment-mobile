package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/browserstack.properties"
})

public interface BrowserstackDriverConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String platformVersion();

    @Key("browserstackRemoteUrl")
    String browserstackRemoteUrl();

    @Key("browserstackProjectName")
    String browserstackProjectName();

    @Key("browserstackTestRunName")
    String browserstackTestRunName();

    @Key("browserstackDebug")
    boolean browserstackDebug();

    @Key("browserstackUsername")
    String browserstackUsername();

    @Key("browserstackAccessToken")
    String browserstackAccessToken();

    @Key("browserstackBuildName")
    String browserstackBuildName();

    @Key("browserstackAppUrl")
    String browserstackAppUrl();

    @Key("browserstackPlatformName")
    String browserstackPlatformName();
}
