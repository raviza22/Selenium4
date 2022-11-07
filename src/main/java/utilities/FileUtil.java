package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtil {

    Properties prop;
    Properties prop2;
    String configFilePath = "src/test/resources/config.properties";
    String dataFilePath = "src/test/resources/testdata.properties";

    public FileUtil() {
        prop = new Properties();
        prop2 = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(configFilePath);
            prop.load(fileInputStream);
            fileInputStream = new FileInputStream(dataFilePath);
            prop2.load(fileInputStream);
            prop.putAll(prop2);
        } catch (Exception e) {
            System.out.println("Unable to read file: " + e.getMessage());
        }
    }

    public String getBrowserConfig() {
        return prop.getProperty("browser");
    }

    public String getAppURL() {
        return prop.getProperty("url");
    }

    public String getUsername() {
        return prop.getProperty("user");
    }

    public String getPassword() {
        return prop.getProperty("pass");
    }

    public String getPropertyWithName(String name) {
        return prop.getProperty(name);
    }
}
