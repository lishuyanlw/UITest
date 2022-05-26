package com.tsc.test.tests.myAccount;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.DataConverter;
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

public class MA_TC13_YourAddresses_AddingAddress extends BaseTest {
    /*
     *CER-805
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC13_YourAddresses_AddingAddress() throws IOException, org.json.simple.parser.ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage = new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Fetching test data from test data file
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

        reporter.reportLog("Verify adding address content");
        getMyAccountPageThreadLocal().verifyAddressContent(true);

        reporter.reportLog("Adding a new shipping address");
        String lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
        Map<String,String> map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);

        //To avoid duplicated data issue
        try{
            getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        }
        catch(Exception e){
            lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
            map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);
            try{
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
            catch (Exception ex){
                lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
                map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
        }

        int addressAmountAfterAdding=getMyAccountPageThreadLocal().lstShippingAddressContainer.size();
        if((addressAmountAfterAdding-addressAmountBeforeAdding)>=1){
            reporter.reportLogPass("Adding a new address successfully");
        }
        else{
            reporter.reportLogFail("Adding a new address failed");
        }

        reporter.reportLog("Verify make default shipping address scenario");
        Map<String,String> mapBeforeMakeDefaultShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        String lsAutoSearchKeywordSetDefault = DataConverter.getSaltString(4,"numberType");
        reporter.reportLog("lsAutoSearchKeywordSetDefault: "+lsAutoSearchKeywordSetDefault);
        map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordSetDefault,true,false,-1);

        //To avoid duplicated data issue
        try{
            getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        }
        catch(Exception e){
            lsAutoSearchKeywordSetDefault = DataConverter.getSaltString(4,"numberType");
            map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordSetDefault,true,false,-1);
            try{
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
            catch(Exception ex){
                lsAutoSearchKeywordSetDefault = DataConverter.getSaltString(4,"numberType");
                map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordSetDefault,true,false,-1);
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
        }

        String lsExpectedFirstname=map.get("firstName").toString();
        basePage.getReusableActionsInstance().staticWait(3000);
        Map<String,String> mapAfterMakeDefaultShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        String lsFirstNameBeforeMakeDefaultShippingAddress=mapBeforeMakeDefaultShippingAddress.get("firstName").toString();
        String lsFirstNameAfterMakeDefaultShippingAddress=mapAfterMakeDefaultShippingAddress.get("firstName").toString();
        if(!lsFirstNameBeforeMakeDefaultShippingAddress.equalsIgnoreCase(lsFirstNameAfterMakeDefaultShippingAddress)&&
            lsExpectedFirstname.equalsIgnoreCase(lsFirstNameAfterMakeDefaultShippingAddress)){
            reporter.reportLogPass("Make default shipping address successfully");
        }
        else{
            reporter.reportLogFailWithScreenshot("Make default shipping address failed with "+lsFirstNameBeforeMakeDefaultShippingAddress+" : "+lsFirstNameAfterMakeDefaultShippingAddress);
        }

        reporter.reportLog("Verify make address as billing address scenario");
        Map<String,String> mapBeforeMakeAsBillingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(-1);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        lsAutoSearchKeywordSetDefault = DataConverter.getSaltString(4,"numberType");
        map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordSetDefault,false,true,-1);

        //To avoid duplicated data issue
        try{
            getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        }
        catch(Exception e){
            lsAutoSearchKeywordSetDefault = DataConverter.getSaltString(4,"numberType");
            map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordSetDefault,false,true,-1);
            try{
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
            catch (Exception ex){
                lsAutoSearchKeywordSetDefault = DataConverter.getSaltString(4,"numberType");
                map=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordSetDefault,false,true,-1);
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
        }
        lsExpectedFirstname=map.get("firstName").toString();

        //Waiting for Default shipping address change
        basePage.getReusableActionsInstance().staticWait(8000);
        Map<String,String> mapAfterMakeAsBillingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(-1);
        String lsFirstNameBeforeMakeAsBillingAddress=mapBeforeMakeAsBillingAddress.get("firstName").toString();
        String lsFirstNameAfterMakeAsBillingAddress=mapAfterMakeAsBillingAddress.get("firstName").toString();
        Map<String,String> mapDefaultShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        String lsFirstDefaultShippingAddress=mapDefaultShippingAddress.get("firstName").toString();
        reporter.reportLog(lsFirstNameBeforeMakeAsBillingAddress+":"+lsExpectedFirstname+":"+lsFirstNameAfterMakeAsBillingAddress+":"+lsFirstDefaultShippingAddress);
        if(!lsFirstNameBeforeMakeAsBillingAddress.equalsIgnoreCase(lsFirstNameAfterMakeAsBillingAddress)&&
                lsExpectedFirstname.equalsIgnoreCase(lsFirstNameAfterMakeAsBillingAddress)){
            reporter.reportLogPass("Make As billing address successfully");
        }
        else{
            reporter.reportLogFail("Make As billing address failed with "+lsExpectedFirstname+" : "+lsFirstNameAfterMakeAsBillingAddress);
        }

        reporter.reportLog("Verify auto search function for address");
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        getMyAccountPageThreadLocal().verifyAutoSearchForAddress(false);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(false);

        reporter.reportLog("Verify adding duplicated address");
        Map<String,String> mapLastShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(getMyAccountPageThreadLocal().lstShippingAddressContainer.size()-1);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        getMyAccountPageThreadLocal().editAddress(mapLastShippingAddress,null);

        if(getMyAccountPageThreadLocal().ckbAddOrEditMakeDefaultShippingAddress.isSelected()){
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().labelAddOrEditMakeDefaultShippingAddress);
            getMyAccountPageThreadLocal().labelAddOrEditMakeDefaultShippingAddress.click();
        }
        basePage.getReusableActionsInstance().staticWait(300);

        if(getMyAccountPageThreadLocal().ckbAddOrEditMakeShippingAsBillingAddress.isSelected()){
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().labelAddOrEditMakeShippingAsBillingAddress);
            getMyAccountPageThreadLocal().labelAddOrEditMakeShippingAsBillingAddress.click();
        }
        basePage.getReusableActionsInstance().staticWait(300);

        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().btnSave);
        getMyAccountPageThreadLocal().btnSave.click();
        basePage.waitForCondition(Driver->{return getMyAccountPageThreadLocal().lblAddOrEditAddressExistingErrorMessage.isDisplayed();},60000);
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
