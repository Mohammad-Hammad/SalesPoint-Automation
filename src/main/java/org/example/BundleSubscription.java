package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;

public class BundleSubscription extends AppTestAndroid {
    public void testBundleSubscription() {

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(735, 1751);
        var end = new Point(731, 972);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));

        var el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"androidx.cardview.widget.CardView\").instance(8)")));
        el1.click();

        var el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/mobileNumberEt")));
        el2.sendKeys("90000000");

        var el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submitSubscriptionBtn")));
        el3.click();

        var el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(3)")));
        el4.click();

        var el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/selectBtn")));
        el5.click();

        var el6 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submitSubscriptionBundleBtn")));
        el6.click();

        var el7 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/otpInclude")));
        el7.sendKeys("0000");

        var el8 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/dialogTitle")));
        el8.click();

        var el9 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/negativeButton")));
        el9.click();
    }
}
