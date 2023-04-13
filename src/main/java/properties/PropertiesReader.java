package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/main/resources/config.properties");
            properties.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}