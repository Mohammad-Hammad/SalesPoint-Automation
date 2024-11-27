package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Arrays;


public class CreditTransferEWallet extends AppTestAndroid{

    CommonActions commonActions = new CommonActions();
    String scrollToCreditTransfer =  "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Credit transfer\"))";
    String scrollToSendButton =  " new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
            "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/sendBtn\"))";
    public void oneTimeCreditTransfer(){
        commonActions.scrollAndTap(scrollToCreditTransfer);

// Wait and interact with el2
        var el2 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/walletRadio\").instance(0)")));
        el2.click();

// Wait and interact with el3
        var el3 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/channelMemberSpinner")));
        el3.click();

// Perform the touch action
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(740, 1338);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

// Wait and interact with el4
        var el4 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/button")));
        el4.click();

// Wait and interact with el5
        var el5 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/amountEt")));
        el5.sendKeys("5");

// Wait and interact with el6
        var el6 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/addChannelMemberBtn")));
        el6.click();

// Wait and interact with el7
        var el7 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/selectAllCb")));
        el7.click();

// Wait and interact with el8
        var el8 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/submitBtn")));
        el8.click();

        commonActions.scrollAndTap(scrollToSendButton);

// Wait and interact with el10
        var el10 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/otpInclude")));
        el10.sendKeys("0000");

// Wait and interact with el11
        var el11 = wait.until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton")));
        el11.click();
    }
    public void moreThanOneTimeCreditTransfer(){
        commonActions.scrollAndTap(scrollToCreditTransfer);
// Wait and interact with el2
        var el2 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/walletRadio\").instance(0)")));
        el2.click();

// Wait and interact with el3
        var el3 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/channelMemberSpinner")));
        el3.click();

// Perform the touch action
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(1037, 1368);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

// Wait and interact with el4
        var el4 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/button")));
        el4.click();

// Wait and interact with el5
        var el5 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/differentAmountRadio")));
        el5.click();

// Wait and interact with el6
        var el6 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/addChannelMemberBtn")));
        el6.click();

// Wait and interact with el7
        var el7 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/itemSelectCheckbox\").instance(0)")));
        el7.click();

// Wait and interact with el8
        var el8 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/submitBtn")));
        el8.click();

// Wait and interact with el9
        var el9 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/amountEt")));
        el9.sendKeys("5");

// Wait and interact with el10
        var el10 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/sendBtn")));
        el10.click();

// Wait and interact with el11
        var el11 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/otpInclude")));
        el11.sendKeys("0000");

// Wait and interact with el12
        var el12 = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id(
                "com.salesapp.ooredoo.uat:id/doneButton")));
        el12.click();

    }
}
