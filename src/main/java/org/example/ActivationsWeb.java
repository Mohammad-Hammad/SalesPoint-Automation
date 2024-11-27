package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ActivationsWeb extends AppTestWeb{
    // Locators
    private By customerOrdersSection = By.xpath("//body/header/nav[@class='o_main_navbar']/div[@class='mk_apps_sidebar_panel']/div[@class='mk_apps_sidebar']/ul[@class='mk_apps_sidebar_menu']/li[9]/div[1]");
    private By searchField = By.xpath("//input[@placeholder='Search...']");
    private By selectFirstResult = By.xpath("//tbody/tr[1]/td[6]");
    private By secondVerificationButton = By.xpath("//button[@name='action_second_verification_request']");
    private By acceptRequestButton = By.xpath("//button[@name='action_accept_request']");
    private By rejectRequestButton = By.xpath("//span[normalize-space()='Reject']");
    public void requestByProcessType(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerOrdersSection)).click();
        chromeDriver.findElement(locator).click();
    }
    public void openRequestByMSISDN() throws InterruptedException {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(SharedContext.getInstance().getICCID());
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys("96126408");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectFirstResult)).click();
    }
    private boolean checkIfRequestInVerificationStage(By locator) throws InterruptedException {
        boolean elementFound = false;
        long startTime = System.currentTimeMillis();
        long maxDuration = 30000; // 30 seconds
        while(!elementFound && (System.currentTimeMillis() - startTime)< maxDuration){
            if(chromeDriver.findElement(locator).isDisplayed()){
                return true;
            }else {
                Thread.sleep(5000);
                chromeDriver.navigate().refresh();
            }
        }
        return false;
    }
    public void PrepaidActivationSecondVerification() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondVerificationButton)).click();
    }
    public void ActivationAccept() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(acceptRequestButton)).click();
        Thread.sleep(10000);
    }
    public void PrepaidActivationReject() throws InterruptedException { {
            wait.until(ExpectedConditions.visibilityOfElementLocated(rejectRequestButton)).click();
        }
    }
}
