package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class DealerRecharge extends AppTestAndroid {
    public void testDealerRecharge(){
        boolean elementFound = false;

        while (!elementFound) {
            try {
                // Attempt to locate the element with the text "E-Top Up"
                var element = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                                + "new UiSelector().text(\"Dealer recharge\"));"));
                elementFound = true; // Element found, exit the loop

                // Perform any action on the element if needed
                element.click(); // Example action: click on the element

            } catch (Exception e) {
                // Scroll down if the element is not found yet
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                ));
                // int Random() = new Rand() --> int(0)*int(30) 0 - 30 var     get 500-var= int x
            }
        }

        var el1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Dealer recharge\")"));
        el1.click();
        var el2 = driver.findElement(AppiumBy.id("com.salesapp.ooredoo.uat:id/voucherCodeEt"));
        el2.sendKeys("123456789");
        var el3 = driver.findElement(AppiumBy.id("com.salesapp.ooredoo.uat:id/rechargeBtn"));
        el3.click();
        var el4 = driver.findElement(AppiumBy.id("com.salesapp.ooredoo.uat:id/tvBlockText"));
        el4.click();
        var el5 = driver.findElement(AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton"));
        el5.click();
    }
}
