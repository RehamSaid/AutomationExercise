package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    public static String getBaseUrl() {
        return get("baseUrl");
    }

    public static String getUserName() {
        return get("userName");
    }

    public static String getUserEmail() {
        return get("userEmail");
    }

    public static String getUserPassword() {
        return get("userPassword");
    }
}
