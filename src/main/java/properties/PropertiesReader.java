package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();
        try {
            String fileName = this.getClass().getClassLoader().getResource("config.properties").getFile();
            FileInputStream fileInputStream = new FileInputStream(fileName);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }
}