package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;


public class AppTestAndroid {
    protected static AppiumDriver driver;
    protected static WebDriverWait wait;
    @BeforeSuite
    public static void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("appium:deviceName", "Galaxy S22 Ultra");
//        cap.setCapability("appium:udid", "R5CTA2106ZZ");
//        cap.setCapability("appium:platformName", "Android");
//        cap.setCapability("appium:platformVersion", "14");
//        cap.setCapability("appium:automationName", "UiAutomator2");
//        cap.setCapability("appium:appPackage", "com.salesapp.ooredoo.uat");
//        cap.setCapability("appium:appActivity", "com.leadingpoint.salesapp.modules.main.ui.views.MainActivity");
//        cap.setCapability("appium:noReset", "true");  // Keeps the app data and state between tests

        cap.setCapability("appium:deviceName", "sdk_gphone_x86");
        cap.setCapability("appium:udid", "emulator-5554");
        cap.setCapability("appium:platformName", "Android");
        cap.setCapability("appium:platformVersion", "11");
        cap.setCapability("appium:automationName", "UiAutomator2");
        cap.setCapability("appium:appPackage", "com.salesapp.ooredoo.uat");
        cap.setCapability("appium:appActivity", "com.leadingpoint.salesapp.modules.main.ui.views.MainActivity");
        cap.setCapability("appium:noReset", "true");  // Keeps the app data and state between tests

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        System.out.println("App Started");
    }
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            // Clear app storage
            driver.executeScript("mobile: shell", ImmutableMap.of("command", "pm clear com.salesapp.ooredoo.uat"));
        }
    }
    public static AppiumDriver getDriver() {
        return driver;
    }
    public void quit(){
        //Kill
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "am force-stop com.salesapp.ooredoo.uat"));
    }
}
