package com.company.project.tests;

import org.example.AppTestWeb;
import org.example.GetChannelMemberQRCode;
import org.testng.annotations.Test;

public class StockManagementWebTests extends AppTestWeb {
    private GetChannelMemberQRCode getChannelMemberQRCode = new GetChannelMemberQRCode();
    @Test
    public void getQRCode() throws Exception {
        getChannelMemberQRCode.setQRImage();
    }
}
