package com.tsc.test.tests.myAccount;

import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.text.ParseException;

public class MA_TC10_Payment_Options_Manage_Credit_Card extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC10_Payment_Options_Manage_Credit_Card() throws ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        /**
         Scenario for verifying Edit functionality on Manage Credit Card
         */
        reporter.reportLog("Scenario for verifying Edit functionality on Manage Credit Card");

        //Fetching Credit Card Data from application
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");

        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword,lblFirstName);

        //Navigate to Manage Credit Card Screen
        getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Manage");

        //Edit Functionality
        getMyAccountPageThreadLocal().editAndVerifyCreditCardAttachedToUser(null,null,null,null,creditCardData,true);
        //Cancel the changes done for Edit
        /**
         Scenario for verifying Cancel Edit functionality on Manage Credit Card
         */
        reporter.reportLog("Scenario for verifying Cancel Edit functionality on Manage Credit Card");
        getMyAccountPageThreadLocal().editAndVerifyCreditCardAttachedToUser(null,null,null,null,creditCardData,false);

    }
}
