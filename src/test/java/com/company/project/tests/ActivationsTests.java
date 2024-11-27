package com.company.project.tests;

import org.example.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ActivationsTests extends AppTestAndroid {
    private LoginAndroid loginAndroid = new LoginAndroid();
    private PrepaidActivation prepaidActivation = new PrepaidActivation();
    private PostpaidActivation postpaidActivation = new PostpaidActivation();
    private PrepaidPortIn prepaidPortIn = new PrepaidPortIn();
    private PostpaidPortIn postpaidPortIn = new PostpaidPortIn();
    private ActivationsWeb activationsWeb = new ActivationsWeb();
    private HBB hbb = new HBB();
    @Test (priority = 1)
    public void testLogin() throws Exception {
        // Perform login actions using the page object methods
        loginAndroid.allowPermissionsIfNeeded();
        loginAndroid.clickSignInButton();
        loginAndroid.enterUsername("dsm1");
        loginAndroid.enterPassword("1234");
        loginAndroid.clickLoginButton();
        Thread.sleep(2000);
    }
    @Test (priority = 2) //dependsOnMethods = "com.company.project.tests.ActivationsTests.testLogin")
    public void testPrepaidActivation() throws Exception {
        prepaidActivation.scrollAndTapPrepaid();
        prepaidActivation.searchSubscription("888");
        prepaidActivation.insertICCID("123");
        prepaidActivation.scrollAndSelectPlan();
        prepaidActivation.scrollAndCaptureDocuments();
        prepaidActivation.acceptTermsAndSignature();
        prepaidActivation.activatePrepaid();
        prepaidActivation.validatePrepaid();
    }
    @Test (priority = 3)
    public void testPostpaidActivation() throws Exception {
        postpaidActivation.scrollAndTapPrepaid();
        postpaidActivation.searchSubscription("888");
        postpaidActivation.selectPlan();
        postpaidActivation.addOns();
        postpaidActivation.insertICCID();
        postpaidActivation.fillAddress();
        postpaidActivation.fillContact();
        postpaidActivation.captureDocuments();
        postpaidActivation.showContract();
        postpaidActivation.addSignature();
        postpaidActivation.submitPostpaid();
        postpaidActivation.validatePostpaid();
    }
    @Test (priority = 4)
    public void testPrepaidPortIn() throws Exception {
        prepaidPortIn.activatePrepaid();
    }
    @Test (priority = 5)
    public void testPostpaidPortIn() throws Exception {
        postpaidPortIn.validatePostpaid();
    }
    @Test (priority = 6)
    public void testFTTH() throws Exception {
        hbb.testFTTH();
    }

}
