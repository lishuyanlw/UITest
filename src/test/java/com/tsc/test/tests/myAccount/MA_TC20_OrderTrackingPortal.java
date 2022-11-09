package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MA_TC20_OrderTrackingPortal extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC20_OrderTrackingPortal() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

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
