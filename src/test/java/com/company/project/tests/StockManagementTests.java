package com.company.project.tests;

import org.example.*;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class StockManagementTests extends AppTestAndroid{
    private LoginAndroid loginAndroid = new LoginAndroid();
    private StockManagement stockManagement = new StockManagement();
    private CommonActions commonActions = new CommonActions();
    private GetChannelMemberQRCode getChannelMemberQRCode = new GetChannelMemberQRCode();
    @Test (priority = 1)
    public void testLogin(){
        loginAndroid.allowPermissionsIfNeeded();
        loginAndroid.clickSignInButton();
        //loginAndroid.allowAdditionalPermissionsIfNeeded();
        loginAndroid.enterUsername("dsm1");
        loginAndroid.enterPassword("1234");
        loginAndroid.clickLoginButton();
    }
    @Test (priority = 2)
    public void testSalesOrder() throws InterruptedException {
        stockManagement.SalesOrder();
        quit();
    }
    @Test (priority = 3)
    public void testPurchaseOrderDSM() throws InterruptedException, MalformedURLException {
        setup();
        stockManagement.PurchaseOrderDSM();
    }
    @Test (priority = 4)
    public void testPurchaseOrderDistributor() throws Exception {
        tearDown();
        setup();
        loginAndroid.allowPermissionsIfNeeded();
        loginAndroid.clickSignInButton();
        //loginAndroid.allowAdditionalPermissionsIfNeeded();
        loginAndroid.enterUsername("dst00007");
        loginAndroid.enterPassword("1234");
        loginAndroid.clickLoginButton();
        stockManagement.PurchaseOrderDistributor();
    }
}