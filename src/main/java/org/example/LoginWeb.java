package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginWeb extends AppTestWeb{
    private By emailField = By.xpath("//input[@placeholder='Email']");
    private By passwordField = By.xpath("//input[@placeholder='Password']");
    private By loginButton = By.xpath("//button[@type='button']");
    public void enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(username);

    }
    public void enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }
    public void clickLoginButton(){
        chromeDriver.findElement(loginButton).click();
    }
}
