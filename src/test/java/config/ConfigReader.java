package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    private static ConfigReader configReader;
    private static final AndroidDriverConfig androidDriverConfig = ConfigFactory.create(AndroidDriverConfig.class, System.getProperties());

    public static ConfigReader getConfigReader() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public AndroidDriverConfig getAndroidDriverConfig() {
        return androidDriverConfig;
    }

}
