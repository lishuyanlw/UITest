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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MA_TC14_YourAddresses_ShippingAddress extends BaseTest {
    /*
     *CER-804
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC14_YourAddresses_ShippingAddress() throws IOException, org.json.simple.parser.ParseException {
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
        //String lsTestDevice = System.getProperty("Device").trim();
        reporter.reportLog("Verify customer information");
        String customerNumber = accountResponse.getCustomerNo();
        String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
        if (customerNumber.equals(userCustomerNumber))
            getReporter().reportLogPass("User is successfully logged in with customer no: " + userCustomerNumber);
        else
            getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: " + userCustomerNumber + " but with other customer no: " + customerNumber);

        boolean value = getGlobalLoginPageThreadLocal().verifySignOutButtonVisibilityOnPage();
        if(value)
            reporter.reportLogPass("SignOut button is displaying correctly");
        else
            reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");

        getMyAccountPageThreadLocal().openSubItemWindow("Your Addresses", "Shipping Address", getMyAccountPageThreadLocal().lblYourAddressTitle);
        int addressAmountBeforeAdding=getMyAccountPageThreadLocal().lstShippingAddressContainer.size();

        String lnk_URL = TestDataHandler.constantData.getMyAccount().getLnk_myAccountShippingAddressURL();
        String expectedURL = basePage.getBaseURL() + lnk_URL;
        if (basePage.URL().equalsIgnoreCase(expectedURL)) {
            reporter.reportLogPass("The navigated URL is equal to expected one:" + expectedURL);
        } else {
            reporter.reportLogFail("The actual navigated URL:+" + basePage.URL() + " is not equal to expected one:" + expectedURL);
        }

        reporter.reportLog("Verify address content");
        getMyAccountPageThreadLocal().verifyYourAddresses();

        reporter.reportLog("Verify editing address content");
        WebElement editButton=getMyAccountPageThreadLocal().getGivenShippingAddressEditButton(0);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("editShippingAddress",editButton);
        getMyAccountPageThreadLocal().verifyAddressContent(false);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(false);

        reporter.reportLog("Adding 2 new shipping addresses");
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        String lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
        getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd, false, false, -1);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        Map<String,String> mapAdd;

        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("addShippingAddress",null);
        lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
        mapAdd=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);

        //To avoid duplicated data issue
        try{
            getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        }
        catch(Exception e){
            lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
            mapAdd=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);
            try{
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
            catch(Exception ex){
                lsAutoSearchKeywordAdd = DataConverter.getSaltString(4,"numberType");
                mapAdd=getMyAccountPageThreadLocal().addNewAddress(lsAutoSearchKeywordAdd,false,false,-1);
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
        }

        String lsFirstNameAdd=mapAdd.get("firstName").toString();
        int addressAmountAfterAdding=getMyAccountPageThreadLocal().lstShippingAddressContainer.size();
        if((addressAmountAfterAdding-addressAmountBeforeAdding)>=2){
            reporter.reportLogPass("Adding a new address successfully");
        }
        else{
            reporter.reportLogFail("Adding a new address failed");
        }

        reporter.reportLog("Verify make default shipping address scenario");
        Map<String,String> mapBeforeMakeDefaultShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        editButton=getMyAccountPageThreadLocal().getGivenShippingAddressEditButton(getMyAccountPageThreadLocal().lstShippingAddressContainer.size()-1);
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

        reporter.reportLog("Edit default shipping address");
        String lsFirstNameEdit=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(5,"lowerStringType");
        String lsLastNameEdit=DataConverter.getSaltString(1,"upperStringType")+DataConverter.getSaltString(7,"lowerStringType");
        String lsAutoSearchKeywordEdit = DataConverter.getSaltString(4,"numberType");
        Map<String,String> mapEditInput=new HashMap<>();
        mapEditInput.put("firstName",lsFirstNameEdit);
        mapEditInput.put("lastName",lsLastNameEdit);
        editButton=getMyAccountPageThreadLocal().getGivenShippingAddressEditButton(0);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("editShippingAddress",editButton);
        String lsAddressEdit=getMyAccountPageThreadLocal().editAddress(mapEditInput,lsAutoSearchKeywordEdit);
        getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        /*//To avoid duplicated data issue
        try{
            getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
        }
        catch(Exception e){
            lsAutoSearchKeywordEdit = DataConverter.getSaltString(4,"numberType");
            lsAddressEdit=getMyAccountPageThreadLocal().editAddress(mapEditInput,lsAutoSearchKeywordEdit);
            try{
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
            catch (Exception ex){
                lsAutoSearchKeywordEdit = DataConverter.getSaltString(4,"numberType");
                lsAddressEdit=getMyAccountPageThreadLocal().editAddress(mapEditInput,lsAutoSearchKeywordEdit);
                getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(true);
            }
        }*/
        Map<String,String> mapAfterEdit=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        String lsFirstName=mapAfterEdit.get("firstName");
        String lsLastName=mapAfterEdit.get("lastName");
        String lsAddress=mapAfterEdit.get("address");
        if(lsFirstName.equalsIgnoreCase(lsFirstNameEdit)&&lsLastName.equalsIgnoreCase(lsLastNameEdit)&&
                lsAddress.equalsIgnoreCase(lsAddressEdit)){
            reporter.reportLogPass("Editing address successfully");
        }
        else{
            reporter.reportLogFail("Editing address failed");
        }

        reporter.reportLog("Verify Editing duplicated address");
        Map<String,String> mapLastShippingAddress=getMyAccountPageThreadLocal().getGivenShippingOrBillingAddress(0);
        editButton=getMyAccountPageThreadLocal().getGivenShippingAddressEditButton(getMyAccountPageThreadLocal().lstShippingAddressContainer.size()-1);
        getMyAccountPageThreadLocal().openAddOrEditAddressWindow("editShippingAddress",editButton);
        getMyAccountPageThreadLocal().editAddress(mapLastShippingAddress,null);

        if(getMyAccountPageThreadLocal().ckbAddOrEditMakeDefaultShippingAddress.isSelected()){
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().labelAddOrEditMakeDefaultShippingAddress);
            getMyAccountPageThreadLocal().labelAddOrEditMakeDefaultShippingAddress.click();
        }
        basePage.getReusableActionsInstance().staticWait(300);

        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().btnSave);
        getMyAccountPageThreadLocal().btnSave.click();
        basePage.waitForCondition(Driver->{return getMyAccountPageThreadLocal().lblAddOrEditAddressExistingErrorMessage.isDisplayed();},120000);
        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().lblAddOrEditAddressExistingErrorMessage);
        String lsActualErrorMessage=getMyAccountPageThreadLocal().lblAddOrEditAddressExistingErrorMessage.getText().trim();
        String lsExpectedErrorMessage = TestDataHandler.constantData.getMyAccount().getLbl_addAddressExistingErrorMessage();
        if(lsActualErrorMessage.equalsIgnoreCase(lsExpectedErrorMessage)){
            reporter.reportLogPass("The duplicated address error message is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The duplicated address error message:'"+lsActualErrorMessage+"' is not displaying as expected:'"+lsExpectedErrorMessage+"'");
        }
        //getMyAccountPageThreadLocal().closeAddOrEditAddressWindow(false);
    }
}
