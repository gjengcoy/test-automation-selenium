package com.series.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
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
            FileInputStream inputStream = new FileInputStream(System.getProperty(("user.dir") + "/src/main/java/com/series/config/config.properties"));
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void initializeConfigurations() {
        String browser = properties.getProperty("browser");

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver-mac-x64/chromedriver");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            testDriver = new ChromeDriver(chromeOptions);
        }

        //more driver pre-run configurations here
        testDriver.get(properties.getProperty("url"));
    }


}
