package org.example;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    // This method will execute before starting of Test suite.
    public void onStart(ITestContext tr) {

    }

    // This method will execute, Once the Test suite is finished.
    public void onFinish(ITestContext tr) {

    }

    // This method will execute only when the test is pass.
    public void onTestSuccess(ITestResult tr) {
        captureScreenShot(tr, "pass");
    }

    // This method will execute only on the event of fail test.
    public void onTestFailure(ITestResult tr) {
        captureScreenShot(tr, "fail");
    }

    // This method will execute before the main test start (@Test)
    public void onTestStart(ITestResult tr) {

    }

    // This method will execute only if any of the main test(@Test) get skipped
    public void onTestSkipped(ITestResult tr) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
    }

    public void captureScreenShot(ITestResult result, String status) {
        // Check if the WebDriver is not null
        if (AppTestWeb.getDriver() != null) {
            captureWebScreenshot(result, status);
        } else {
            captureMobileScreenshot(result, status);
        }
    }

    // Method to capture mobile screenshots
    public void captureMobileScreenshot(ITestResult result, String status) {
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();

        File scrFile = ((TakesScreenshot) AppTestAndroid.getDriver()).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        } else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }

        new File(destDir).mkdirs();
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";

        try {
            FileHandler.copy(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to capture web screenshots
    public void captureWebScreenshot(ITestResult result, String status) {
        String destDir = "";
        String passfailMethod = result.getMethod().getRealClass().getSimpleName() + "." + result.getMethod().getMethodName();

        File scrFile = ((TakesScreenshot) AppTestWeb.getDriver()).getScreenshotAs(OutputType.FILE);
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

        if (status.equalsIgnoreCase("fail")) {
            destDir = "screenshots/Failures";
        } else if (status.equalsIgnoreCase("pass")) {
            destDir = "screenshots/Success";
        }

        new File(destDir).mkdirs();
        String destFile = passfailMethod + " - " + dateFormat.format(new Date()) + ".png";

        try {
            FileHandler.copy(scrFile, new File(destDir + "/" + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}