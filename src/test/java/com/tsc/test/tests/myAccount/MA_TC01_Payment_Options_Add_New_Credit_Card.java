package com.tsc.test.tests.myAccount;

import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class MA_TC01_Payment_Options_Add_New_Credit_Card extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC01_Payment_Options_Add_New_Credit_Card() throws ParseException, IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        //Fetching test data from test data file
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");
        List<String> creditCardTypes = TestDataHandler.constantData.getMyAccount().getLst_newCreditCardType();
        String landingPageURL = TestDataHandler.constantData.getMyAccount().getLnk_addNewCardURL();
        List<String> errorMessage = TestDataHandler.constantData.getMyAccount().getLbl_invalidCardErrorMessage();
        JSONObject creditCard;
        String cardType,cardDisplayName,cardNumber;
        /**
        Scenario for adding a new Credit Card to user
        */
        reporter.reportLog("Scenario for adding new Credit Card to user for all four types");

        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName,lblPassword,lblFirstName);

        //Adding Credit Card of all types
        for(String inputCardType:creditCardTypes){
            reporter.reportLog("Adding Credit Card Type: "+inputCardType);
            creditCard = (JSONObject) creditCardData.get(inputCardType);
            cardType = creditCard.get("CardType").toString();
            cardNumber = creditCard.get("Number").toString();
            cardDisplayName = creditCard.get("CardDisplayName").toString();

            getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Add");
            getGlobalLoginPageThreadLocal().validateCurrentUrlContains(landingPageURL);
            Map<String,String> addedCreditCardData = getMyAccountPageThreadLocal().addNewValidCreditCardForUser(cardType,cardNumber,false);
            getMyAccountPageThreadLocal().verifyNewAddedCreditCardForUser(cardType,cardDisplayName,cardNumber,addedCreditCardData.get("expirationMonth"),addedCreditCardData.get("expirationYear"),true);
            //Navigating back to Add New Credit Card Page
            getMyAccountPageThreadLocal().navigateToMyAccountFromBreadCrumb();
        }

        /**
         Scenario for adding invalid Credit Card to user for verifying error message
         */
        for(String inputCardType:creditCardTypes){
            getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Add");
            getMyAccountPageThreadLocal().addNewValidCreditCardForUser(inputCardType,"1234",false);
            reporter.reportLog("Validating Error Message for Card Type: "+inputCardType);
            if(inputCardType.toLowerCase().contains("tsc"))
                getMyAccountPageThreadLocal().verifyInvalidCreditCardErrorMessage(errorMessage.get(1));
            else
                getMyAccountPageThreadLocal().verifyInvalidCreditCardErrorMessage(errorMessage.get(0));
            getMyAccountPageThreadLocal().navigateToMyAccountFromBreadCrumb();
        }
    }
}
