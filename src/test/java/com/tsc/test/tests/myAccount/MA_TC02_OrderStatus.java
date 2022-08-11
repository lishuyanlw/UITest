package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MA_TC02_OrderStatus extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC02_OrderStatus() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

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

        boolean value = getGlobalLoginPageThreadLocal().verifySignOutButtonVisibilityOnPage();
        if(value)
            reporter.reportLogPass("SignOut button is displaying correctly");
        else
            reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");

        getMyAccountPageThreadLocal().openSubItemWindow("Your Orders","Order Status", getMyAccountPageThreadLocal().lblOrderStatusSectionTitle);

        String lnk_orderStatusURL=TestDataHandler.constantData.getMyAccount().getLnk_orderStatusURL();
        String expectedURL=basePage.getBaseURL()+lnk_orderStatusURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        String expectedNoOrderRecorderMessage=TestDataHandler.constantData.getMyAccount().getLbl_noOrderRecordsMessage();
        if(getMyAccountPageThreadLocal().checkOrderItemExisting()){
            reporter.reportLog("Verify Order status section");
            getMyAccountPageThreadLocal().verifyOrderStatusSection(false,expectedNoOrderRecorderMessage);

            reporter.reportLog("Verify search order function with invalid orderNO");
            String lbl_orderSearchErrorMessage=TestDataHandler.constantData.getMyAccount().getLbl_orderSearchErrorMessage();
            getMyAccountPageThreadLocal().verifyOrderSearchErrorMessage(lbl_orderSearchErrorMessage);

            basePage.navigateBack();

            reporter.reportLog("Verify search order function with valid orderNO");
            String lnk_orderDetailsURL=TestDataHandler.constantData.getMyAccount().getLnk_orderDetailsURL();
            getMyAccountPageThreadLocal().verifySearchOrderFunction(lnk_orderDetailsURL);
        }
        else{
            getMyAccountPageThreadLocal().verifyNoOrderRecordsMessage(expectedNoOrderRecorderMessage);
        }
    }
}
