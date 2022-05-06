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

public class MA_TC08_AccountSettings_ChangePassword extends BaseTest {
    /*
     *CER-799
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC08_AccountSettings_ChangePassword() throws ParseException, IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        String accessToken = apiUserSessionData.get("access_token").toString();

        AccountAPI accountAPI=new AccountAPI();
        Map<String,Object> userData= new HashMap<>();
        userData.put("Password","testMail123");
        userData.put("RetypedPassword","testMail123");
        Response response=accountAPI.createNormalAccount(accessToken,null,userData);
        AccountResponse accountResponse=null;
        if(response.statusCode()==200){
            accountResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<AccountResponse>() {});
        }
        else{
            reporter.reportLogFail("Creating account failed");
            return;
        }

        lblUserName=accountResponse.getEmail();
        lblPassword="testMail123";
        String lblFirstName=accountResponse.getBillingAddress().getFirstName();
        String customerNumber=accountResponse.getCustomerNo();

        reporter.reportLog("SignIn with Username: "+lblUserName+" and Password: "+lblPassword);
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        BasePage basePage=new BasePage(this.getDriver());
        String lsTestDevice = System.getProperty("Device").trim();
        if(lsTestDevice.equalsIgnoreCase("Desktop")) {
            WebElement item=(new GlobalHeaderPage(this.getDriver())).Signinlnk;
            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(item);
            basePage.waitForCondition(Driver->{return !item.getText().isEmpty()&&item.getText().trim().toUpperCase().contains(lblFirstName.trim().toUpperCase());},12000);
            if(item.getText().trim().toUpperCase().contains(lblFirstName.trim().toUpperCase())) {
                reporter.reportLogPass("The SignIn in the header contains SignIn first name");
            }
            else{
                reporter.reportLogFailWithScreenshot("The SignIn in the header does not contain SignIn first name");
            }
        }

        reporter.reportLog("Verify Order status URL");
        getMyAccountPageThreadLocal().openSubItemWindow("Your Profile","Change Password", getMyAccountPageThreadLocal().lblAccountSettingSectionTitle);

        String lnk_changePasswordURL=TestDataHandler.constantData.getMyAccount().getLnk_accountSettingsChangePasswordURL();
        String expectedURL=basePage.getBaseURL()+lnk_changePasswordURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        if(!lsTestDevice.equalsIgnoreCase("Mobile")){
            reporter.reportLog("Verify customer information");
            String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
            if(customerNumber.equals(userCustomerNumber))
                getReporter().reportLogPass("User is successfully logged in with customer no: "+userCustomerNumber);
            else
                getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: "+userCustomerNumber+" but with other customer no: "+customerNumber);

            basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getGlobalLoginPageThreadLocal().lblSignInPageTitle);
            String lsSignInPageTitle=getGlobalLoginPageThreadLocal().lblSignInPageTitle.getText();
            if(lsSignInPageTitle.toUpperCase().contains(lblFirstName.toUpperCase())){
                reporter.reportLogPass("The Title contains SignIn user's name");
            }
            else{
                reporter.reportLogFailWithScreenshot("The Title does not contain SignIn user's name");
            }

            if(basePage.getReusableActionsInstance().isElementVisible(getGlobalLoginPageThreadLocal().btnSignOut)){
                reporter.reportLogPass("SignOut button is displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");
            }
        }

        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().lblAccountSettingSectionTitle);
        String lsTitle=getMyAccountPageThreadLocal().lblAccountSettingSectionTitle.getText().trim();
        String lsExpectedTitle=TestDataHandler.constantData.getMyAccount().getLbl_accountSettingsTitle().trim();
        if(lsTitle.equalsIgnoreCase(lsExpectedTitle)){
            reporter.reportLogPass("The Account settings title is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The account settings title:"+lsTitle+" is not displaying correctly as the expected:"+lsExpectedTitle);
        }

        reporter.reportLog("Verify canceling changed password");
        String lsPassword=getMyAccountPageThreadLocal().changePasswordFunctionInAccountSettingsSection(lblPassword,false);
        getGlobalLoginPageThreadLocal().SignOut();

        reporter.reportLog("SignIn with "+lblUserName +" and "+lsPassword);
        getGlobalLoginPageThreadLocal().LoginWithoutWaitingTime(lblUserName, lsPassword);
        if(basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().lblSignInGlobalResponseBanner.isDisplayed();},120000)){
            reporter.reportLogPass("Canceling password successfully");
        }
        else{
            reporter.reportLogFail("Canceling password failed");
        }

        getMyAccountPageThreadLocal().openSubItemWindow("Your Profile","Change Password", getMyAccountPageThreadLocal().lblAccountSettingSectionTitle);

        reporter.reportLog("Verify error message for changing password");
        List<String> lstExpectedTitle=TestDataHandler.constantData.getMyAccount().getLst_changingPasswordErrorMessage();
        getMyAccountPageThreadLocal().VerifyChangePasswordFunctionInAccountSettingsSectionWithInvalidValue(lsPassword,lstExpectedTitle);

        reporter.reportLog("Verify submitting changed password");
        String lsChangedPassword=getMyAccountPageThreadLocal().changePasswordFunctionInAccountSettingsSection(lblPassword,true);
        reporter.reportLog("Changed password from "+lblPassword+" to "+lsChangedPassword);
        getGlobalLoginPageThreadLocal().SignOut();
        if(getGlobalLoginPageThreadLocal().Login(lblUserName, lsChangedPassword)){
            reporter.reportLogPass("Changing password successfully");
        }
        else{
            reporter.reportLogFail("Changing password failed");
        }
    }
}
