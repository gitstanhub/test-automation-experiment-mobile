package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    INSTANCE;

    private static final AndroidDriverConfig androidDriverConfig = ConfigFactory.create(
            AndroidDriverConfig.class, System.getProperties());

    public AndroidDriverConfig read() {
        return androidDriverConfig;
    }
}
