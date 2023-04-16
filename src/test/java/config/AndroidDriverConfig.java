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


}
