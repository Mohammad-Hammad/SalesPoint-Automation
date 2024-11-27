package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommonActions extends AppTestAndroid{

    public void scrollAndTap(String Element){
        boolean elementFound = false;
        long startTime = System.currentTimeMillis();
        long maxDuration = 30000; // 30 seconds

        while (!elementFound && (System.currentTimeMillis() - startTime) < maxDuration) {
            try {
                driver.findElement(AppiumBy.androidUIAutomator(Element)).click();
                elementFound = true;
            } catch (Exception e) {
                scrollDown();
            }
        }
        if (!elementFound) {
            throw new NoSuchElementException("Element with text 'Credit transfer' not found within 30 seconds.");
        }
    }

    private void scrollDown() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
    }

    public void searchSubscription(String idNumber) throws InterruptedException {
        var el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//*[@text='ID type']")));
        el2.sendKeys("Omani Civil ID");
        Thread.sleep(3000);
        el2.click();
        var el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/idNumberText")));
        el3.click();
        var el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/idNumberText")));
        el4.click();
        el4.sendKeys(idNumber);
        var el11 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/searchButton")));
        el11.click();
    }

    public void updateExpiryDate() {
        var el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/expiryDateText")));
        el1.click();
        var el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Next month")));
        el2.click();
        var el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().text(\"28\")\n")));
        el3.click();
        var el4 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("android:id/button1")));
        el4.click();
        var el5 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.salesapp.ooredoo.uat:id/positiveButton")));
        el5.click();
    }

    public static void setVirtualImage(Path path, String fileName) throws Exception {
        String dir = "";
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }
        File imageFile = Files.walk(path)
                .filter(Files::isReadable)
                .filter(Files::isRegularFile)
                .filter(p -> p.getFileName().toString().equalsIgnoreCase(fileName))
                .map(Path::toFile)
                .findFirst()
                .orElse(null);
        if (imageFile != null || Files.probeContentType(imageFile.toPath()) != null
                && Files.probeContentType(imageFile.toPath()).split(File.separator)[1].equals("png")) {
            if (System.getenv("ANDROID_SDK_ROOT") != null)
                dir = System.getenv("ANDROID_SDK_ROOT");
            else if (System.getenv("ANDROID_HOME") != null)
                dir = System.getenv("ANDROID_HOME");
            else
                throw new Exception("System environment not found.");

            ImageIO.write(ImageIO.read(imageFile),
                    "png",
                    new File(
                            dir + File.separator + "emulator" + File.separator + "resources" + File.separator
                                    + "your-image.png"));
        } else {
            throw new Exception("File is not a png image.");
        }
    }

}
