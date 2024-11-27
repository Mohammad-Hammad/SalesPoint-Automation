package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class CustomerRecharge extends AppTestAndroid {
    public void testCustomerRechargeWallet() {

        // Elements with waits
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"Customer recharge\"));"));

        var el31 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Customer recharge\")")));
        el31.click();

        var el32 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/phoneNumberEt")));
        el32.sendKeys("96126566");

        var el33 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/eWalletRadio")));
        el33.click();

        var el34 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/rechargeAmountEt")));
        el34.sendKeys("10");

        var el35 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/rechargeBtn")));
        el35.click();

        var el36 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/otpInclude")));
        el36.sendKeys("1234");

        var el37 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/tvBlockText")));
        el37.click();

        var el38 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton")));
        el38.click();
    }
    public void testCustomerRechargeVoucher() {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(458, 1929);
        var end = new Point(514, 304);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        // Second swipe
        final var finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start2 = new Point(352, 1937);
        var end2 = new Point(411, 320);
        var swipe2 = new Sequence(finger2, 1);
        swipe2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start2.getX(), start2.getY()));
        swipe2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end2.getX(), end2.getY()));
        swipe2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe2));

        // Elements with waits
        var el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/phoneNumberEt")));
        el1.sendKeys("90000000");

        var el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/rechargeRadio")));
        el2.click();

        var el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/voucherCodeEt")));
        el3.sendKeys("123456789");

        var el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/rechargeBtn")));
        el4.click();

        var el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/tvBlockText")));
        el5.click();

        var el6 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton")));
        el6.click();
    }
}
