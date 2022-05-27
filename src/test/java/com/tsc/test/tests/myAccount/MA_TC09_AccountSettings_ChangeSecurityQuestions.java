package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.pojo.AccountResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.pages.GlobalHeaderPage;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;

public class MA_TC09_AccountSettings_ChangeSecurityQuestions extends BaseTest {
    /*
     *CER-800
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC09_AccountSettings_ChangeSecurityQuestions() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());
        /**
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
        String customerNumber=accountResponse.getCustomerNo();

        reporter.reportLog("SignIn with Username: "+lblUserName+" and Password: "+lblPassword);
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        BasePage basePage=new BasePage(this.getDriver());
        String lsTestDevice = System.getProperty("Device").trim();

        //if(!lsTestDevice.equalsIgnoreCase("Mobile")){
        reporter.reportLog("Verify customer information");
        String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
        if(customerNumber.equals(userCustomerNumber))
            getReporter().reportLogPass("User is successfully logged in with customer no: "+userCustomerNumber);
        else
            getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: "+userCustomerNumber+" but with other customer no: "+customerNumber);

        boolean value = getGlobalLoginPageThreadLocal().verifySignOutButtonVisibilityOnPage();
        if(value)
            reporter.reportLogPass("SignOut button is displaying correctly");
        else
            reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");
        //}
        */

        BasePage basePage=new BasePage(this.getDriver());
        String lsTestDevice = System.getProperty("Device").trim();
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        reporter.reportLog("Verify customer information");
        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();
        String userCustomerNumber = getGlobalLoginPageThreadLocal().getCustomerNumberForLoggedInUser();
        if(customerNumber.equals(userCustomerNumber))
            getReporter().reportLogPass("User is successfully logged in with customer no: "+userCustomerNumber);
        else
            getReporter().reportLogFailWithScreenshot("User is not logged in with expected customer no: "+userCustomerNumber+" but with other customer no: "+customerNumber);

        boolean value = getGlobalLoginPageThreadLocal().verifySignOutButtonVisibilityOnPage();
        if(value)
            reporter.reportLogPass("SignOut button is displaying correctly");
        else
            reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");

        reporter.reportLog("Verify Order status URL");
        getMyAccountPageThreadLocal().openSubItemWindow("Your Profile","Security Questions", getMyAccountPageThreadLocal().lblAccountSettingSectionTitle);

        String lnk_securityQuestions=TestDataHandler.constantData.getMyAccount().getLnk_accountSettingsChangeSecurityQuestionsURL();
        String expectedURL=basePage.getBaseURL()+lnk_securityQuestions;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
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

        reporter.reportLog("Verify error message");
        getMyAccountPageThreadLocal().verifyChangeSecurityQuestionErrorMessage();

        reporter.reportLog("Verify clicking Cancel button");
        Map<String,Object> map=getMyAccountPageThreadLocal().changeSecurityQuestionFunctionInAccountSettingsSection(false);
        getMyAccountPageThreadLocal().openChangeSecuritySection();
        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().selectChangeSecurityQuestionSectionQuestion);
        Select select=new Select(getMyAccountPageThreadLocal().selectChangeSecurityQuestionSectionQuestion);
        int selectedValue= Integer.parseInt(select.getFirstSelectedOption().getAttribute("value"));
        if(lsTestDevice.equalsIgnoreCase("Desktop")){
            if(selectedValue==-1){
                reporter.reportLogPass("There is no selected security question by clicking Cancel button");
            }
            else{
                reporter.reportLogFailWithScreenshot("There still is selected security question:"+selectedValue+" by clicking Cancel button");
            }
        }
        else{
            if(selectedValue!=-1){
                reporter.reportLogPass("The selected security question:"+selectedValue+" by clicking Cancel button is displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("There is no selected security question by clicking Cancel button is not displaying correctly");
            }
        }

        reporter.reportLog("Verify clicking Submit button");
        map=getMyAccountPageThreadLocal().changeSecurityQuestionFunctionInAccountSettingsSection(true);
        basePage.getReusableActionsInstance().staticWait(basePage.getStaticWaitForApplication());
        getMyAccountPageThreadLocal().openChangeSecuritySection();
        basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getMyAccountPageThreadLocal().selectChangeSecurityQuestionSectionQuestion);
        select=new Select(getMyAccountPageThreadLocal().selectChangeSecurityQuestionSectionQuestion);
        selectedValue= Integer.parseInt(select.getFirstSelectedOption().getAttribute("value"))+1;
        int expectedSelectedValue= Integer.parseInt(map.get("SelectedIndex").toString());
        if(selectedValue==expectedSelectedValue){
            reporter.reportLogPass("The security question is displaying correctly");
        }
        else{
            reporter.reportLogFailWithScreenshot("The displayed security question value:"+selectedValue+" is not the same as the expected:"+expectedSelectedValue);
        }
    }
}
