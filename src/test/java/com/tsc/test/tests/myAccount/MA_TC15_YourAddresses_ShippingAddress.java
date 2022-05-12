package com.tsc.test.tests.myAccount;

import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class MA_TC15_YourAddresses_ShippingAddress extends BaseTest {
    /*
     *CER-799
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC15_YourAddresses_ShippingAddress() throws IOException, org.json.simple.parser.ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage = new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

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

        String lnk_URL = TestDataHandler.constantData.getMyAccount().getLnk_myAccountShippingAddressURL();
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

        reporter.reportLog("Verify address content");
        getMyAccountPageThreadLocal().verifyYourAddresses();

        reporter.reportLog("Adding a new shipping address");
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        String lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
        Map<String,String> mapAdd=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);
        String lsFirstNameAdd=mapAdd.get("firstName").toString();
        reporter.reportLog("lsFirstNameAdd: "+lsFirstNameAdd);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        int selectedIndex= Integer.parseInt(mapAdd.get("selectedIndex"));
        int addressAmountAfterAdding=getMyAccountPageThreadLocal().lstShippingAddressContainer.size();
        if((addressAmountAfterAdding-addressAmountBeforeAdding)==1){
            reporter.reportLogPass("Adding a new address successfully");
        }
        else{
            reporter.reportLogFail("Adding a new address failed");
        }

        reporter.reportLog("Verify make default shipping address scenario");
        Map<String,String> mapBeforeMakeDefaultShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        reporter.reportLog("Shipping list size: "+getMyAccountPageThreadLocal().lstShippingAddressContainer.size());
        WebElement editButton=getMyAccountPageThreadLocal().getGivenShippingAddressEditButton(getMyAccountPageThreadLocal().lstShippingAddressContainer.size()-1);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("editShippingAddress",editButton);
        getMyAccountPageThreadLocal().setDefaultShippingAddress();
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        basePage.getReusableActionsInstance().staticWait(3000);
        Map<String,String> mapAfterMakeDefaultShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        String lsFirstNameBeforeMakeDefaultShippingAddress=mapBeforeMakeDefaultShippingAddress.get("firstName").toString();
        String lsFirstNameAfterMakeDefaultShippingAddress=mapAfterMakeDefaultShippingAddress.get("firstName").toString();
        if(!lsFirstNameBeforeMakeDefaultShippingAddress.equalsIgnoreCase(lsFirstNameAfterMakeDefaultShippingAddress)&&
                lsFirstNameAdd.equalsIgnoreCase(lsFirstNameAfterMakeDefaultShippingAddress)){
            reporter.reportLogPass("Make default shipping address successfully");
        }
        else{
            reporter.reportLogFailWithScreenshot("Make default shipping address failed with "+lsFirstNameBeforeMakeDefaultShippingAddress+" : "+lsFirstNameAfterMakeDefaultShippingAddress);
        }



    }
}
