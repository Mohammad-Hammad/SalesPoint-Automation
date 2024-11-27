package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;
import java.time.Duration;
import java.util.Arrays;

public class eTopUp extends AppTestAndroid {
    public void test_eTopUp() throws InterruptedException {

        var ee = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/eWalletTv")));
        String eWalletTextBefore = ee.getText();
        double eWalletValueBefore=0.0;
        try {
            eWalletValueBefore = Double.parseDouble(eWalletTextBefore);
            System.out.println("eWallet Value Before: " + eWalletValueBefore);
        } catch (NumberFormatException e) {
            System.err.println("The text is not a valid integer: " + eWalletTextBefore);
        }
        boolean elementFound = false;

        while (!elementFound) {
            try {
                // Attempt to locate the element with the text "E-Top Up"
                var element = driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"E-Top Up\")"
                ));
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
        var el6 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/eventSourceET")));
        el6.sendKeys("90000000");

// Wait and interact with the second element
        Random random = new Random();
        double value = random.nextInt(30) + 1;
        String valueText = String.valueOf(value);

        var el7 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/amountEditText")));
        el7.sendKeys(valueText);

// Wait and interact with the third element
        var el8 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/offerTypeSpinner")));
        el8.click();

// Wait for the dropdown options to be visible before clicking
        Thread.sleep(5000); // Optional, if needed

// Wait and interact with the fourth element
        var el9 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(1)")));
        el9.click();

        var el10 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/submitBtn")));
        el10.click();

// Wait and interact with the OTP input
        var el11 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/otpInclude")));
        el11.sendKeys("1234");

// Wait and interact with the dialog title
        var el12 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/dialogTitle")));
        el12.click();

// Wait and interact with the negative button
        var el13 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/negativeButton")));
        el13.click();

// Wait and interact with the eWallet text view
        Thread.sleep(3000);
        var el14 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/eWalletTv")));
        String eWalletTextAfter = el14.getText();
        double eWalletValueAfter=0.0;
        try {
            eWalletValueAfter = Double.parseDouble(eWalletTextAfter);
            System.out.println("eWallet Value After Paying 5 OMR: " + eWalletValueAfter);
        } catch (NumberFormatException e) {
            System.err.println("The text is not a valid integer: " + eWalletTextAfter);
        }
        //eWalletValueBefore
        //eWalletValueAfter
        //value
        Assert.assertEquals(eWalletValueAfter, eWalletValueBefore - value,
                "Test Failed: eWallet value after transaction does not match the expected value.");
    }
}