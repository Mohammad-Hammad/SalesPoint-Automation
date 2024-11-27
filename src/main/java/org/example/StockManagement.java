package org.example;

import com.google.common.collect.ImmutableMap;
import com.sun.jdi.event.ThreadDeathEvent;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class StockManagement extends AppTestAndroid {
    public void SalesOrder() throws InterruptedException {
        Thread.sleep(2000);
        Random rand = new Random();
        int randomNumber = 10000000 + rand.nextInt(90000000);
        boolean isElementFound = false;
        while (!isElementFound) {
            try {
                // Attempt to find the "Sales order" element
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()"
                                + ".scrollForward().scrollIntoView(new UiSelector().text(\"Sales order\"));"));

                // Click the element if found
                var ee = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sales order\")"));
                ee.click();
                isElementFound = true;  // Element found, break the loop
            } catch (Exception e) {
                // Handle case where element is not found after scrolling
                System.out.println("Element not found, trying to scroll down...");

                // Scroll down explicitly if the element is not found
                try {
                    driver.findElement(AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollForward();"));
                } catch (Exception ex) {
                    System.out.println("Reached the end of the page, element not found.");
                    break;  // Exit loop if the end of the page is reached
                }

                // Optionally, add a small delay between scrolls to avoid overloading
                Thread.sleep(1000);
            }
        }
//        driver.findElement(AppiumBy.id("com.salesapp.ooredoo.uat:id/childChannelMemberSpinner")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("fabPurchaseOrderFragmentAdd")));
        Thread.sleep(10000);
        var els3 = driver.findElements(AppiumBy.id("fabPurchaseOrderFragmentAdd"));
        els3.get(0).click();
        WebElement el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/childChannelMemberSpinner")));
        el3.click();
        el3.sendKeys("Tamer Ahmad");
        Thread.sleep(3000);
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(842, 776);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
        Thread.sleep(3000);
        var el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submitBtn")));
        el2.click();
        try {
            var e2e = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            e2e.click();
        } catch (Exception e) {
            System.out.println("Element e2e not found or not clickable. Continuing without failure.");
        }
        Thread.sleep(3000);
        var el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/increaseTv\").instance(0)")));
        el1.click();

        var el22 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/requestForQuotationBtn")));
        el22.click();

        Thread.sleep(3000);
        var el33 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        el33.click();

        var el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Approve\")")));
        el4.click();
        Thread.sleep(3000);
        var el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        el5.click();

        var el20 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/scanFrame")));
        el20.click();

        var el21 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/scanItem")));
        el21.click();

        var el222 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Item by Item")));
        el222.click();

        var el23 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/start_range_text_view")));
        el23.click();
        el23.sendKeys("" + randomNumber);
        driver.executeScript("mobile: hideKeyboard");

        var el24 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submit_button")));
        el24.click();

        var el25 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Update\")")));
        el25.click();
        Thread.sleep(3000);
        var el26 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        el26.click();

        var el27 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/btn")));
        el27.click();
        Thread.sleep(3000);
        var el28 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        el28.click();

        var el29 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/orderStatusCV")));
        el29.click();
    }

    public void PurchaseOrderDSM() throws InterruptedException {
        String name = "Purchase order";
        boolean isElementFound = false;
        while (!isElementFound) {
            try {
                // Attempt to find the "Sales order" element
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()"
                                + ".scrollForward().scrollIntoView(new UiSelector().text(\""+name+"\"));"));

                // Click the element if found
                var ee = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+name+"\")"));
                ee.click();
                isElementFound = true;  // Element found, break the loop
            } catch (Exception e) {
                // Handle case where element is not found after scrolling
                System.out.println("Element not found, trying to scroll down...");

                // Scroll down explicitly if the element is not found
                try {
                    driver.findElement(AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollForward();"));
                } catch (Exception ex) {
                    System.out.println("Reached the end of the page, element not found.");
                    break;  // Exit loop if the end of the page is reached
                }

                // Optionally, add a small delay between scrolls to avoid overloading
                Thread.sleep(1000);
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/fabPurchaseOrderFragmentAdd")));
        Thread.sleep(10000);
        var el2 = driver.findElements(AppiumBy.id("com.salesapp.ooredoo.uat:id/fabPurchaseOrderFragmentAdd"));
        el2.get(0).click();
        Thread.sleep(2000);
        var el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/increaseTv\").instance(0)")));
        el1.click();
        var el22 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/requestForQuotationBtn")));
        el22.click();
        Thread.sleep(500);
    }

    public void PurchaseOrderDistributor() throws Exception {
        Random rand = new Random();
        int randomNumber = 10000000 + rand.nextInt(90000000);
        var ee = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sales order\")")));
        ee.click();
        Thread.sleep(3000);
        var el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        el1.click();
//        var el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Approve\")")));
//        el2.click();
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(904, 1527);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
        Thread.sleep(3000);
        var st = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        st.click();
        // Wait for el2
        Thread.sleep(1000);
        var el22 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/scanFrame")));
        el22.click();
        Thread.sleep(1000);
// Wait for el3
        var el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/scanItem")));
        el3.click();

// Wait for el4
        var el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Item by Item\")")));
        el4.click();

        var el23 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/start_range_text_view")));
        el23.click();
        el23.sendKeys("" + randomNumber);
        driver.executeScript("mobile: hideKeyboard");
        Thread.sleep(1000);
        var el24 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submit_button")));
        el24.click();
        Thread.sleep(1000);
// Wait for el5
        var el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"Update\")")));
        el5.click();
// Wait for el6
        Thread.sleep(3000);
        var el6 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/cardView\").instance(0)")));
        el6.click();
// Wait for el7
        var el7 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/btn")));
        el7.click();
    }
}

