package com.tsc.test.tests.myAccount;

import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Map;

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

        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword);

        //Navigate to Manage Credit Card Screen
        getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Manage");

        //Verifying if any card is attached to user for Editing and if not adding card first
        boolean cardAddedStatus = getMyAccountPageThreadLocal().verifyMinimumOneCardIsPresentForUser();
        if(!cardAddedStatus)
            getMyAccountPageThreadLocal().addNewValidCreditCardForUser("visa",((JSONObject)creditCardData.get("visa")).get("Number").toString(),false);

        //Edit Functionality
        getMyAccountPageThreadLocal().editAndVerifyCreditCardAttachedToUser(null,null,null,null,creditCardData,true);
        //Cancel the changes done for Edit
        /**
         Scenario for verifying Cancel Edit functionality on Manage Credit Card
         */
        reporter.reportLog("Scenario for verifying Cancel Edit functionality on Manage Credit Card");
        Map<String,String> cardData = getMyAccountPageThreadLocal().editAndVerifyCreditCardAttachedToUser(null,null,null,null,creditCardData,false);

        /**
         Scenario for verifying Cancel Remove functionality on Manage Credit Card
         */
        reporter.reportLog("Scenario for verifying Cancel Remove functionality on Manage Credit Card");
        getMyAccountPageThreadLocal().removeCreditCardFromUser(cardData.get("cardType"),cardData.get("cardNumber"),cardData.get("expirationMonthAndYear"),false);
        /**
         Scenario for verifying Remove functionality on Manage Credit Card
         */
        reporter.reportLog("Scenario for verifying Remove functionality on Manage Credit Card");
        getMyAccountPageThreadLocal().removeCreditCardFromUser(cardData.get("cardType"),cardData.get("cardNumber"),cardData.get("expirationMonthAndYear"),true);
    }
}
