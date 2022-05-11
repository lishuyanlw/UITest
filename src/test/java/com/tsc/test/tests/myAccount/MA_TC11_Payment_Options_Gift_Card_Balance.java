package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class MA_TC11_Payment_Options_Gift_Card_Balance extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC11_Payment_Options_Gift_Card_Balance() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        /**
         Scenario for verifying gift card balance
         */
        reporter.reportLog("Scenario for verifying gift card balance on application");

        //Get Test Data
        List<String> giftCardBalanceData = TestDataHandler.constantData.getMyAccount().getLst_giftCardDetails();
        String invalidGiftCardNumberErrorMessage = TestDataHandler.constantData.getMyAccount().getLbl_invalidGiftCardNumberErrorMessage();
        String invalidGiftCardPinErrorMessage = TestDataHandler.constantData.getMyAccount().getLbl_invalidGiftCardPinErrorMessage();
        String giftCardPageURL = TestDataHandler.constantData.getMyAccount().getLnk_giftCardURL();

        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword);

        //Navigate to Manage Credit Card Screen
        getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Gift");
        String landingPageURL = System.getProperty("QaUrl")+giftCardPageURL;
        getMyAccountPageThreadLocal().validateCurrentUrl(landingPageURL);
        getMyAccountPageThreadLocal().getAndVerifyGiftCardBalance(giftCardBalanceData.get(0),giftCardBalanceData.get(1),giftCardBalanceData.get(2));

        /**
         Scenario for verifying invalid gift card number Error Message
         */
        reporter.reportLog("Scenario for verifying invalid gift card number Error Message on application");
        getMyAccountPageThreadLocal().verifyGiftCardErrorMessage(null,"number",invalidGiftCardNumberErrorMessage);

        /**
         Scenario for verifying invalid pin Error Message
         */
        reporter.reportLog("Scenario for verifying invalid pin Error Message on application");
        getMyAccountPageThreadLocal().verifyGiftCardErrorMessage(giftCardBalanceData.get(0),"pin",invalidGiftCardPinErrorMessage);
    }
}
