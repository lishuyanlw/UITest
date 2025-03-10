package com.tsc.test.tests.orderTracking;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;


public class OT_TC01_OrderTrackingPortal extends BaseTest {
    /*
     * CER-910
     * CER-911
     */
    @Test(groups={"OrderTracking","Regression"})
    public void OT_TC01_OrderTrackingPortal() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        getOrderTrackingThreadLocal().goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter( getGlobalFooterPageThreadLocal() ,lstNameAndLinks);

        getOrderTrackingThreadLocal().verifyOrderTrackPortalContents();

        reporter.reportLog("Verify Order Track Portal Error Messages without Input value");
        List<String> lstErrorMessageForNoInputForOrderNumberAndBillingPostal=TestDataHandler.constantData.getMyAccount().getLstTrackingOrderPortalErrorMessageForOrderNumberAndPostalCode();
        List<String> lstErrorMessageForNoInputForSignIn=TestDataHandler.constantData.getMyAccount().getLstTrackingOrderPortalErrorMessageForSignIn();
        getOrderTrackingThreadLocal().verifyOrderTrackPortalErrorMessagesForNoInput(lstErrorMessageForNoInputForOrderNumberAndBillingPostal,lstErrorMessageForNoInputForSignIn);

        reporter.reportLog("Verify Error Message With Invalid UserName And Password");
        String lblErrorMessageWithInvalidUserNameAndPassword=TestDataHandler.constantData.getMyAccount().getLblErrorMessageWithInvalidUserNameAndPasswordForOrderTrackingPortal();
        getOrderTrackingThreadLocal().verifyErrorMessageWithInvalidUserNameAndPassword(lblErrorMessageWithInvalidUserNameAndPassword);

        reporter.reportLog("Verify Not Found Message For Track Portal With invalid Order Number");
        String lblTrackingOrderPortalNotFoundMessage=TestDataHandler.constantData.getMyAccount().getLblTrackingOrderPortalNotFoundMessage();
        getOrderTrackingThreadLocal().verifyNotFoundMessageForTrackPortalWithWrongOrderNumber(lblTrackingOrderPortalNotFoundMessage);

    }
}
