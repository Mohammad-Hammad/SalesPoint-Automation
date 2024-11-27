package com.company.project.tests;

import org.example.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ActivationTestsWeb extends AppTestWeb {
    private LoginWeb loginWeb = new LoginWeb();
    private ActivationsWeb activationsWeb = new ActivationsWeb();
    @Test(priority = 1)
    public void testLogin() throws Exception {
        loginWeb.enterUsername("admin"); // replace with actual username
        loginWeb.enterPassword("admin"); // replace with actual password
        loginWeb.clickLoginButton();
    }
    @Test(priority = 2)
    public void testActivationWebAccept() throws Exception {
        activationsWeb.requestByProcessType(By.xpath("//a[contains(text(),'Mobile Prepaid')]"));
        activationsWeb.openRequestByMSISDN();
        activationsWeb.ActivationAccept();
    }
    @Test(priority = 3)
    public void testActivationWebReject() throws Exception {
        activationsWeb.requestByProcessType(By.xpath("//a[contains(text(),'Mobile Prepaid')]"));
        activationsWeb.openRequestByMSISDN();
        activationsWeb.PrepaidActivationReject();
    }
    @Test(priority = 4)
    public void testActivationWebSecond() throws Exception {
        activationsWeb.requestByProcessType(By.xpath("//a[contains(text(),'Mobile Prepaid')]"));
        activationsWeb.openRequestByMSISDN();
        activationsWeb.PrepaidActivationSecondVerification();
    }
}
