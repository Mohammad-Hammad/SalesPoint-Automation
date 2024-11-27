package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginAndroid extends AppTestAndroid {
    private By allowPermissionButton = By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button");
    private By signInButton = By.id("com.salesapp.ooredoo.uat:id/singInButton");
    private By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private By usernameField = By.id("com.salesapp.ooredoo.uat:id/idEditText");
    private By passwordField = By.id("com.salesapp.ooredoo.uat:id/passwordEditText");
    private By loginButton = By.id("com.salesapp.ooredoo.uat:id/buttonLoginFragmentLogin");
    public void allowPermissionsIfNeeded() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(allowPermissionButton)).click();
        } catch (Exception e) {
            System.out.println("Permission button not found or not clickable. Continuing without failure.");
        }
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

//    public void allowAdditionalPermissionsIfNeeded() {
//        try {
//            WebElement additionalPermissionButton = wait.until(ExpectedConditions.elementToBeClickable(allowButton));
//            additionalPermissionButton.click();
//        } catch (Exception e) {
//            System.out.println("Additional permission button not found or not clickable. Continuing without failure.");
//        }
//    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}

