package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:configuration/real-device.properties"
})

public interface RealDeviceDriverConfig extends Config {

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
}
