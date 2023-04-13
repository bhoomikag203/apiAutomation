package utils;

import properties.PropertiesReader;

import java.util.Properties;

public class ConfigLoader {

    Properties configProperties;
    private PropertiesReader propertiesReader;

    public ConfigLoader() {
        this.propertiesReader = new PropertiesReader();
        configProperties = this.propertiesReader.getProperties();
    }

    public String getHost() {
        return configProperties.getProperty("host");
    }
}
