package com.tsc.test.tests.myAccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class MA_TC01_Payment_Options_Add_New_Credit_Card extends BaseTest {
    /*
    *CER-802
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC01_Payment_Options_Add_New_Credit_Card() throws ParseException, IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();
        /**
         Scenario for adding a new Credit Card to user
         */
        reporter.reportLog("Scenario for adding new Credit Card to user for all four types");

        //Fetching test data from test data file
        JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");
        List<String> creditCardTypes = TestDataHandler.constantData.getMyAccount().getLst_newCreditCardType();
        String addCreditCardPageURL = TestDataHandler.constantData.getMyAccount().getLnk_addNewCardURL();
        List<String> errorMessage = TestDataHandler.constantData.getMyAccount().getLbl_invalidCardErrorMessage();
        JSONObject creditCard;
        String cardType,cardDisplayName,cardNumber;

        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();

        //Fetching test data from test data file
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        AccountAPI accountAPI=new AccountAPI();
        CartAPI cartAPI=new CartAPI();
        Response response=accountAPI.getAccountDetailsFromCustomerEDP(customerEDP, accessToken);
        AccountResponse accountResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
        for(AccountResponse.CreditCardsClass item:accountResponse.getCreditCards()){
            cartAPI.deletePaymentDetailsForUserFromCart(customerEDP,item.getId()+"",accessToken);
        }

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lsTestDevice = System.getProperty("Device").trim();
        BasePage basePage=new BasePage(this.getDriver());
        if(lsTestDevice.equalsIgnoreCase("Desktop")) {
            WebElement item=(new GlobalHeaderPage(this.getDriver())).Signinlnk;
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            if(item.getText().trim().toUpperCase().contains(lblFirstName.trim().toUpperCase())) {
                reporter.reportLogPass("The SignIn in the header contains SignIn first name");
            }
            else{
                reporter.reportLogFailWithScreenshot("The SignIn in the header does not contain SignIn first name");
            }
        }

        //Adding Credit Card of all types
        for(String inputCardType:creditCardTypes){
            reporter.reportLog("Adding Credit Card Type: "+inputCardType);
            creditCard = (JSONObject) creditCardData.get(inputCardType);
            cardType = creditCard.get("CardType").toString();
            cardNumber = creditCard.get("Number").toString();
            cardDisplayName = creditCard.get("CardDisplayName").toString();

            getMyAccountPageThreadLocal().clickOnPaymentOptionSubMenuItemsOnMyAccount("Add");
            String landingPageURL = System.getProperty("QaUrl")+addCreditCardPageURL;
            getGlobalLoginPageThreadLocal().validateCurrentUrl(landingPageURL);
            Map<String,String> addedCreditCardData = getMyAccountPageThreadLocal().addNewValidCreditCardForUser(cardType,cardNumber,true);
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
