package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
public class PostpaidActivation extends AppTestAndroid {
    CommonActions commonActions = new CommonActions();
    private By ICCIDField = AppiumBy.id("com.salesapp.ooredoo.uat:id/mobileText");
    private By selectPlanButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/selectBtn\").instance(1)");
    private By nextButton = AppiumBy.id("com.salesapp.ooredoo.uat:id/nextBtn");
    private By addressSection = AppiumBy.androidUIAutomator("new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(1)");
    private By contactSection = AppiumBy.androidUIAutomator("new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(2)");
    private By signatureView = AppiumBy.id("com.salesapp.ooredoo.uat:id/signatureView");
    private By buttonSave = AppiumBy.id("com.salesapp.ooredoo.uat:id/buttonSave");
    private By doneButton = AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton");
    private By voiceAddOns = AppiumBy.androidUIAutomator("new UiSelector().text(\"Voice\")");
    private By addOnsSelectButton =AppiumBy.id("com.salesapp.ooredoo.uat:id/selectBtn");
    private By dataButton =AppiumBy.androidUIAutomator("new UiSelector().text(\"Data\")");
    private By passportButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Passport\")");
    private By saveButton = AppiumBy.id("com.salesapp.ooredoo.uat:id/saveBtn");
    private By cityList = AppiumBy.id("com.salesapp.ooredoo.uat:id/citySpinner");
    private By poBoxField = AppiumBy.id("com.salesapp.ooredoo.uat:id/poBoxTv");
    private By pcCodeField = AppiumBy.id("com.salesapp.ooredoo.uat:id/pcCodeTv");
    private By regionList = AppiumBy.id("com.salesapp.ooredoo.uat:id/regionSpinner");
    private By walleyeList = AppiumBy.id("com.salesapp.ooredoo.uat:id/walleyeSpinner");
    private By localityList = AppiumBy.id("com.salesapp.ooredoo.uat:id/localitySpinner");
    private By wayNumberField = AppiumBy.id("com.salesapp.ooredoo.uat:id/wayNumberTv");
    private By houseNumberField = AppiumBy.id("com.salesapp.ooredoo.uat:id/homeNumberTv");
    private By landMarkField = AppiumBy.id("com.salesapp.ooredoo.uat:id/landMarkTv");
    private By phoneNumberField = AppiumBy.id("com.salesapp.ooredoo.uat:id/phoneTv");
    private By emailField = AppiumBy.id("com.salesapp.ooredoo.uat:id/emailTv");

    private String scrollToPostpaid =   "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Postpaid\"))";
    private String scrollToSubmitButton = "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/submitButton\"));";
    private String scrollToSignature = "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/privacyCheckBox\"));";
    public void scrollAndTapPrepaid(){
        commonActions.scrollAndTap(scrollToPostpaid);
    }
    public void searchSubscription(String idNumber) throws InterruptedException {
        CommonActions commonActions = new CommonActions();
        commonActions.searchSubscription(idNumber);
    }
    public void updateExpiryDate(){
        CommonActions commonActions = new CommonActions();
        commonActions.updateExpiryDate();
    }
    public void selectPlan() throws InterruptedException {
        Thread.sleep(2000);
        final var finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        var start1 = new Point(956, 1083);
        var end1 = new Point (134, 1071);
        var swipe1 = new Sequence(finger2, 1);
        swipe1.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start1.getX(), start1.getY()));
        swipe1.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe1.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end1.getX(), end1.getY()));
        swipe1.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe1));

        final var finger3 = new PointerInput(PointerInput.Kind.TOUCH, "finger3");
        var start2 = new Point(956, 1083);
        var end2 = new Point(134, 1071);
        var swipe2 = new Sequence(finger3, 1);
        swipe2.addAction(finger3.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), start2.getX(), start2.getY()));
        swipe2.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe2.addAction(finger3.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), end2.getX(), end2.getY()));
        swipe2.addAction(finger3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe2));

        wait.until(ExpectedConditions.elementToBeClickable(selectPlanButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public void addOns(){
        wait.until(ExpectedConditions.elementToBeClickable(voiceAddOns)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addOnsSelectButton)).click();
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
        wait.until(ExpectedConditions.elementToBeClickable(dataButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addOnsSelectButton)).click();
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
        wait.until(ExpectedConditions.elementToBeClickable(passportButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addOnsSelectButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();

    }
    public void insertICCID(){
        wait.until(ExpectedConditions.elementToBeClickable(ICCIDField)).sendKeys("123");
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    public void fillAddress() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addressSection)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cityList)).click();

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(582, 1103);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        wait.until(ExpectedConditions.elementToBeClickable(poBoxField)).sendKeys("Test");
        wait.until(ExpectedConditions.elementToBeClickable(pcCodeField)).sendKeys("Test");

        wait.until(ExpectedConditions.elementToBeClickable(regionList)).click();
        Thread.sleep(1000);
        final var finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        var tapPoint2 = new Point(735, 1920);
        var tap2 = new Sequence(finger2, 1);
        tap2.addAction(finger2.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint2.x, tapPoint2.y));
        tap2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap2.addAction(new Pause(finger2, Duration.ofMillis(50)));
        tap2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap2));

        wait.until(ExpectedConditions.elementToBeClickable(walleyeList)).click();
        Thread.sleep(1000);
        final var finger3 = new PointerInput(PointerInput.Kind.TOUCH, "finger3");
        var tapPoint3 = new Point(521, 2104);
        var tap3 = new Sequence(finger3, 1);
        tap3.addAction(finger3.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint3.x, tapPoint3.y));
        tap3.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap3.addAction(new Pause(finger3, Duration.ofMillis(50)));
        tap3.addAction(finger3.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap3));


        wait.until(ExpectedConditions.elementToBeClickable(localityList)).click();
        Thread.sleep(1000);
        final var finger4 = new PointerInput(PointerInput.Kind.TOUCH, "finger4");
        var tapPoint4 = new Point(740, 1021);
        var tap4 = new Sequence(finger4, 1);
        tap4.addAction(finger4.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint4.x, tapPoint4.y));
        tap4.addAction(finger4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap4.addAction(new Pause(finger4, Duration.ofMillis(50)));
        tap4.addAction(finger4.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap4));

        wait.until(ExpectedConditions.elementToBeClickable(wayNumberField)).sendKeys("Test");
        wait.until(ExpectedConditions.elementToBeClickable(houseNumberField)).sendKeys("Test");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/buttonSave\"))"));

        wait.until(ExpectedConditions.elementToBeClickable(landMarkField)).sendKeys("Test");
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
    }
    public void fillContact(){
        wait.until(ExpectedConditions.elementToBeClickable(contactSection)).click();
        wait.until(ExpectedConditions.elementToBeClickable(phoneNumberField)).sendKeys("90000000");
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys("a@b.com");
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
    }
    public void captureDocuments(){
        var el100 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(3)")));
        el100.click();
        try {
            var el101 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            el101.click();
        } catch (Exception e) {
            System.out.println("Element el3 not found or not clickable. Continuing without failure.");
        }
        var el102 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/capture_image_view")));
        el102.click();
        var el103 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/captionTv\").instance(0)")));
        el103.click();
        var el104 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/capture_image_view")));
        el104.click();
        var el105 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(4)")));
        el105.click();
        var el106 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/capture_image_view")));
        el106.click();
    }
    public void showContract(){
        var el107 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/showContractLL")));
        el107.click();
        var el108 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/doneBtn")));
        el108.click();
    }
    public void addSignature(){
        commonActions.scrollAndTap(scrollToSignature);
        wait.until(ExpectedConditions.elementToBeClickable(signatureView)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
    }
    public void submitPostpaid(){
        commonActions.scrollAndTap(scrollToSubmitButton);
    }
    public void validatePostpaid(){
        wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
    }
}
