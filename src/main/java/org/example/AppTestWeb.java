package org.example;


import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppTestWeb {
    protected static WebDriver chromeDriver;
    protected static WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Setup ChromeDriver for web automation
        chromeDriver = new ChromeDriver();
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(30));
        chromeDriver.get("https://ooqa.salespoint.live/");

    }
    @AfterClass
    public void tearDown() {
        if (chromeDriver != null) {
            chromeDriver.quit();
        }
    }
    public static WebDriver getDriver() {
        return chromeDriver;
    }
}
