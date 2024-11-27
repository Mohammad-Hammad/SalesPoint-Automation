package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class HBB extends AppTestAndroid{
    CommonActions commonActions = new CommonActions();
    public void testFTTH() throws InterruptedException {
        commonActions.scrollAndTap(  "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"HBB\"))");
        commonActions.searchSubscription("888");

        var el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/positiveButton")));
        el3.click();
        var el4 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/placesEt")));
        el4.sendKeys("Muscat");
        var el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/searchFullText")));
        el5.click();
        var el6 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Map Marker")));
        el6.click();
        var el7 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"FTTH\")")));
        el7.click();
        var el8 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/button")));
        el8.click();
        var el9 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/contactNumberEt")));
        el9.sendKeys("90000000");
        var el10 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/emailEt")));
        el10.sendKeys("a@b.com");
        var el11 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/governorate")));
        el11.click();
        var el12 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(1)")));
        el12.click();
        var el13 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/wilayat")));
        el13.click();
        var el14 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/exitToolbarPageTitle")));
        el14.click();
        var el15 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/area")));
        el15.click();
        var el16 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(1)")));
        el16.click();
        var el17 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/streetName")));
        el17.sendKeys("Test");
        var el18 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/houseNumber")));
        el18.sendKeys("Test");
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/btnAddressFragmentNext\"));"));
        var el19 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/postalCode")));
        el19.sendKeys("Test");
        var el20 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.salesapp.ooredoo.uat:id/pobox")));
        el20.sendKeys("Test");
        var el21 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/btnAddressFragmentNext")));
        el21.click();
        var el22 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/selectBtn\").instance(0)")));
        el22.click();
        var el23 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/nextBtn")));
        el23.click();
        var el24 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/buttonNext")));
        el24.click();
        var el25 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"androidx.appcompat.widget.LinearLayoutCompat\").instance(0)")));
        el25.click();
        var el26 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/camera")));
        el26.click();
        try {
            // Wait for the element to be clickable and then click it
            var el27 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            el27.click();
            System.out.println("Permission button clicked successfully.");
        } catch (Exception e) {
            // Handle the exception (element not found, not clickable, etc.)
            System.out.println("Permission button not found or not clickable. Skipping this step.");
        }
        var el28 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/capture_image_view")));
        el28.click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/captionTv\"));"));
        var el29 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/captionTv")));
        el29.click();
        var el30 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/camera")));
        el30.click();
        var el31 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/capture_image_view")));
        el31.click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceId(\"com.salesapp.ooredoo.uat:id/privacyCheckBox\"));"));
        var el32 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/privacyCheckBox")));
        el32.click();
        var el33 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/signatureView")));
        el33.click();
        var el34 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/buttonSave")));
        el34.click();
        var el35 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submitBtn")));
        el35.click();
        var el36 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/doneBtn")));
        el36.click();
        var el37 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/successMessageTv")));
        el37.click();
        var el38 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/doneButton")));
        el38.click();
    }
}
