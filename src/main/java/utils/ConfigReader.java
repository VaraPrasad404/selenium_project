package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static volatile Properties prop;

    private ConfigReader() {}

    public static String getProperty(String key) {
        if (prop == null) {
            synchronized (ConfigReader.class) {
                if (prop == null) {
                    System.out.println(Thread.currentThread().getName() + " loading config...");
                    prop = new Properties();
                    try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
                        if (input == null) {
                            throw new RuntimeException("❌ config.properties file NOT found in resources");
                        }
                        prop.load(input);
                    } catch (IOException e) {
                        throw new RuntimeException("❌ Failed to load config file", e);
                    }
                }
            }
        }

        String value = prop.getProperty(key);

        if (value == null) {
            System.out.println("❗ WARNING: Key '" + key + "' not found in config.properties");
        } else {
            System.out.println(Thread.currentThread().getName() + " → " + key + " = " + value);
        }

        return value;
    }
}