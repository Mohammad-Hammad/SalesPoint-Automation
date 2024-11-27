package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Arrays;
public class PrepaidActivation extends AppTestAndroid {
    CommonActions commonActions = new CommonActions();
    // locators outside method inside class
    private By ICCIDField = AppiumBy.id("com.salesapp.ooredoo.uat:id/mobileText");
    private By linearLayoutElement = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(2)");
    private By captureDocumentText = AppiumBy.androidUIAutomator("new UiSelector().text(\"Capture document \")");
    private By permissionAllowButton = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By captureImageView = AppiumBy.id("com.salesapp.ooredoo.uat:id/capture_image_view");
    private By signatureView = AppiumBy.id("com.salesapp.ooredoo.uat:id/signatureView");
    private By buttonSave = AppiumBy.id("com.salesapp.ooredoo.uat:id/buttonSave");
    private By otpField = AppiumBy.id("com.salesapp.ooredoo.uat:id/otpInclude");
    private By doneButton = AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton");
    private String scrollToPrepaidButton = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Prepaid\"))";
    private String scrollToCaptureDocument = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Capture document \"))";
    private String scrollToActivateButton = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/activateButton\"));";
    private String scrollToSignature =  "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/privacyCheckBox\"));";
    public void scrollAndTapPrepaid(){
        commonActions.scrollAndTap(scrollToPrepaidButton);
    }
    public void searchSubscription(String idNumber) throws InterruptedException {
        CommonActions commonActions = new CommonActions();
        commonActions.searchSubscription(idNumber);
    }
    public void updateExpiryDate(){
        CommonActions commonActions = new CommonActions();
        commonActions.updateExpiryDate();
    }
    public void insertICCID(String ICCID) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(ICCIDField)).sendKeys(ICCID);
        wait.until(ExpectedConditions.elementToBeClickable(ICCIDField)).click();

        Thread.sleep(2000);
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(1205, 2752);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        driver.executeScript("mobile: hideKeyboard");
        wait.until(ExpectedConditions.elementToBeClickable(linearLayoutElement)).click();
        WebElement element = driver.findElement(AppiumBy.id("com.salesapp.ooredoo.uat:id/yourNumberTextView"));
        String iccidText = element.getText();

        //Session alive (driver alive)

        SharedContext.getInstance().setICCID(iccidText);
    }
    public void scrollAndSelectPlan(){
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/selectBtn\"));"
        ));

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


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/selectBtn\").instance(1)"))).click();

    }
    public void scrollAndCaptureDocuments(){
        commonActions.scrollAndTap(scrollToCaptureDocument);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(permissionAllowButton)).click();
        } catch (Exception e) {
            System.out.println("No permissionAllowButton found, Skipped.");
        }
        wait.until(ExpectedConditions.elementToBeClickable(captureImageView)).click();
        wait.until(ExpectedConditions.elementToBeClickable(captureDocumentText)).click();
        wait.until(ExpectedConditions.elementToBeClickable(captureImageView)).click();
    }
    public void acceptTermsAndSignature(){
        commonActions.scrollAndTap(scrollToSignature);
        wait.until(ExpectedConditions.elementToBeClickable(signatureView)).click();
        wait.until(ExpectedConditions.elementToBeClickable(buttonSave)).click();
    }
    public void activatePrepaid() throws InterruptedException {
        commonActions.scrollAndTap(scrollToActivateButton);
        wait.until(ExpectedConditions.elementToBeClickable(otpField)).sendKeys("1234");
    }
    public void validatePrepaid(){
        wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
    }
}

