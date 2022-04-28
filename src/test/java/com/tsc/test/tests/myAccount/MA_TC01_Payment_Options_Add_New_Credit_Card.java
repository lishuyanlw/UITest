package com.tsc.test.tests.myAccount;

import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Map;

public class MA_TC01_Payment_Options_Add_New_Credit_Card extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC01_Payment_Options_Add_New_Credit_Card() throws ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        //Fetching test data from test data file
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");
        /**
        Scenario for adding a new Credit Card to user
        */
        reporter.reportLog("Scenario for adding new Credit Card to user for all four types");
        reporter.reportLog("Adding Credit Card Type: VISA");
        JSONObject creditCard = (JSONObject) creditCardData.get("visaCard");
        String cardType = creditCard.get("CardType").toString();
        String cardNumber = creditCard.get("Number").toString();

        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword,lblFirstName);

        getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Add");
        Map<String,String> addedCreditCardData = getMyAccountPageThreadLocal().addNewValidCreditCardForUser(cardType,cardNumber,false);
        boolean flag = getMyAccountPageThreadLocal().verifyNewAddedCreditCardForUser(cardType,cardNumber,addedCreditCardData.get("expirationMonth"),addedCreditCardData.get("expirationYear"));
        if(flag)
            reporter.reportLogPass("Credit Card: "+cardNumber+" with type: "+cardType+" is added as expected for the user");
        else
            reporter.reportLogFailWithScreenshot("Credit Card: "+cardNumber+" with type: "+cardType+" is not added as expected for the user");
    }
}
