package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {

    private static ConfigReader configReader;
    private static final EmulatorDriverConfig emulatorDriverConfig = ConfigFactory.create(EmulatorDriverConfig.class, System.getProperties());
    private static final RealDeviceDriverConfig realDeviceDriverConfig = ConfigFactory.create(RealDeviceDriverConfig.class, System.getProperties());
    private static final BrowserstackDriverConfig browserstackDriverConfig = ConfigFactory.create(BrowserstackDriverConfig.class, System.getProperties());

    public static ConfigReader getConfigReader() {
        if (configReader == null) {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public EmulatorDriverConfig getEmulatorDriverConfig() {
        return emulatorDriverConfig;
    }

    public RealDeviceDriverConfig getRealDeviceDriverConfig() {
        return realDeviceDriverConfig;
    }

    public BrowserstackDriverConfig getBrowserstackDriverConfig() {
        return browserstackDriverConfig;
    }

}
