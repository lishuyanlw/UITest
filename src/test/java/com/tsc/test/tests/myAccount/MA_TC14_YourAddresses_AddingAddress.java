package com.tsc.test.tests.myAccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MA_TC14_YourAddresses_AddingAddress extends BaseTest {
    /*
     *CER-799
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC14_YourAddresses_AddingAddress() throws ParseException, IOException, org.json.simple.parser.ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage = new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();

        //Fetching test data from test data file and remove CC info
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        AccountAPI accountAPI=new AccountAPI();
        AccountResponse accountResponse=getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken);
        List<AccountResponse.AddressClass> addressClasses=accountResponse.getShippingAddresses();
        if(!addressClasses.isEmpty()){
            for(int i=0;i<addressClasses.size();i++){
                accountAPI.deletingShippingAddressInAccount(accountResponse,customerEDP,accessToken,i);
            }
        }

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lsTestDevice = System.getProperty("Device").trim();

        getMyAccountPageThreadLocal().openSubItemWindow("Your Addresses", "Shipping Address", getMyAccountPageThreadLocal().lblYourAddressTitle);
        int addressAmountBeforeAdding=getMyAccountPageThreadLocal().lstShippingAddressContainer.size();
        getMyAccountPageThreadLocal().goBackUpperLevel();

        getMyAccountPageThreadLocal().openSubItemWindow("Your Addresses", "Add a New Address", getMyAccountPageThreadLocal().lblAddOrEditAddressTitle);

        String lnk_URL = TestDataHandler.constantData.getMyAccount().getLnk_myAccountAddingAddressURL();
        String expectedURL = basePage.getBaseURL() + lnk_URL;
        if (basePage.URL().equalsIgnoreCase(expectedURL)) {
            reporter.reportLogPass("The navigated URL is equal to expected one:" + expectedURL);
        } else {
            reporter.reportLogPass("The actual navigated URL:+" + basePage.URL() + " is not equal to expected one:" + expectedURL);
        }

        if (!lsTestDevice.equalsIgnoreCase("Mobile")) {
            reporter.reportLog("Verify customer information");
            String customerNumber = accountResponse.getCustomerNo();
            String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
            if (customerNumber.equals(userCustomerNumber))
                getReporter().reportLogPass("User is successfully logged in with customer no: " + userCustomerNumber);
            else
                getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: " + userCustomerNumber + " but with other customer no: " + customerNumber);

            if (basePage.getReusableActionsInstance().isElementVisible(getGlobalLoginPageThreadLocal().btnSignOut)) {
                reporter.reportLogPass("SignOut button is displaying correctly");
            } else {
                reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");
            }
        }

        reporter.reportLog("Adding a new shipping address");
        String lsAutoSearchKeyword = TestDataHandler.constantData.getMyAccount().getLbl_autoSearchKeyword();
        getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeyword,false,false,0);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        int addressAmountAfterAdding=getMyAccountPageThreadLocal().lstShippingAddressContainer.size();
        if((addressAmountAfterAdding-addressAmountBeforeAdding)==1){
            reporter.reportLogPass("Adding a new address successfully");
        }
        else{
            reporter.reportLogFail("Adding a new address failed");
        }

        reporter.reportLog("Verify make default shipping address scenario");

        reporter.reportLog("Verify auto search function for address");
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        getMyAccountPageThreadLocal().verifyAutoSearchForAddress(false);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(false);

        reporter.reportLog("Verify adding duplicated address");
        getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeyword,false,false,0);
        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().lblAddOrEditAddressExistingErrorMessage);
        String lsActualErrorMessage=getMyAccountPageThreadLocal().lblAddOrEditAddressExistingErrorMessage.getText().trim();
        String lsExpectedErrorMessage = TestDataHandler.constantData.getMyAccount().getLbl_addAddressExistingErrorMessage();
        if(lsActualErrorMessage.equalsIgnoreCase(lsExpectedErrorMessage)){
            reporter.reportLogPass("The duplicated address error message is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The duplicated address error message:'"+lsActualErrorMessage+"' is not displaying as expected:'"+lsExpectedErrorMessage+"'");
        }
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(false);


    }
}
