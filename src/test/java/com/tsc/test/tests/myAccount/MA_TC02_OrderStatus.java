package com.tsc.test.tests.myAccount;

import com.tsc.api.util.DataConverter;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class MA_TC02_OrderStatus extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC02_OrderStatus() throws ParseException, IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify Order status URL");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();
        String lblFirstName = TestDataHandler.constantData.getMyAccount().getLbl_FirstName();
        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword, lblFirstName);

        getMyAccountPageThreadLocal().openSubItemWindow("Order Status", getMyAccountPageThreadLocal().lblOrderStatusSectionTitle);

        String lnk_orderStatusURL=TestDataHandler.constantData.getMyAccount().getLnk_orderStatusURL();
        String expectedURL=basePage.getBaseURL()+lnk_orderStatusURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        String lsTestDevice = System.getProperty("Device").trim();
        if(!lsTestDevice.equalsIgnoreCase("Mobile")){
            reporter.reportLog("Verify customer information");
            //Fetching test data from test data file
            ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
            apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

            String accessToken = apiUserSessionData.get("access_token").toString();
            String customerEDP = apiUserSessionData.get("customerEDP").toString();
            String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();
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

        if(getMyAccountPageThreadLocal().checkOrderItemExisting()){
            reporter.reportLog("Verify Order status section");
            getMyAccountPageThreadLocal().verifyOrderStatusSection(false);

            reporter.reportLog("Verify search order function with invalid orderNO");
            String lbl_orderSearchErrorMessage=TestDataHandler.constantData.getMyAccount().getLbl_orderSearchErrorMessage();
            getMyAccountPageThreadLocal().verifyOrderSearchErrorMessage(lbl_orderSearchErrorMessage);

            getMyAccountPageThreadLocal().goBackUpperLevel();

            reporter.reportLog("Verify search order function with valid orderNO");
            String lnk_orderDetailsURL=TestDataHandler.constantData.getMyAccount().getLnk_orderDetailsURL();
            getMyAccountPageThreadLocal().verifySearchOrderFunction(lnk_orderDetailsURL);
        }
        else{
            reporter.reportLogFail("No order items existing");
        }

    }
}
