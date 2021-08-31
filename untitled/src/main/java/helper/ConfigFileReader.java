package helper;

import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configuration.properties";
    public ConfigFileReader() {
        try {
            FileReader reader = new FileReader(propertyFilePath);
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }
    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url == null)
            Assert.fail("Application Url not specified in the Configuration.properties file for the Key:url");
        return url;
    }
    public String getDriverType() {
        String browser = properties.getProperty("browser");
        if(browser == null)
            Assert.fail("Browser is not specified in the Configuration.properties file");
        return browser;
    }

}
