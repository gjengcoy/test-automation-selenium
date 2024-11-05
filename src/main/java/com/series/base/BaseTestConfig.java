package com.series.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.tinylog.Logger;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

/*
 * Best Practice: Create class to initialize and setup driver configurations and extend to page classes
 * */
public class BaseTestConfig {
    public static WebDriver testDriver;
    public static Properties properties;

    public BaseTestConfig() {
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            Logger.error("Error encountered {}", e.getMessage());
        }
    }

    // driver pre-run configurations
    public static void initializeConfigurations() {
        Logger.info("Initializing testing configurations");
        try {
            String browser = properties.getProperty("app.browser");

            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", properties.getProperty("app.driver"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                testDriver = new ChromeDriver(chromeOptions);
            }

            testDriver.manage().window().maximize();
            testDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
            testDriver.get(properties.getProperty("app.url"));
        } catch (Exception e) {
            Logger.error("Error encountered {}", e.getMessage());
        }

    }
}
