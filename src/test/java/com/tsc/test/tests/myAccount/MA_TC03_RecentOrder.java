package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class MA_TC03_RecentOrder extends BaseTest {
    /*
     *CER-790
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC03_RecentOrder() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getMyAccount().getLbl_Username();
        String lblPassword = TestDataHandler.constantData.getMyAccount().getLbl_Password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        String lsTestDevice = System.getProperty("Device").trim();

        getMyAccountPageThreadLocal().openSubItemWindow("Your Orders","Recent Orders", getMyAccountPageThreadLocal().lblOrderStatusSectionTitle);

        String lnk_recentOrderURL=TestDataHandler.constantData.getMyAccount().getLnk_recentOrderURL();
        String expectedURL=basePage.getBaseURL()+lnk_recentOrderURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

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

            if(basePage.getReusableActionsInstance().isElementVisible(getGlobalLoginPageThreadLocal().btnSignOut)){
                reporter.reportLogPass("SignOut button is displaying correctly");
            }
            else{
                reporter.reportLogFailWithScreenshot("SignOut button is not displaying correctly");
            }
        }

        if(getMyAccountPageThreadLocal().checkOrderItemExisting()){
            reporter.reportLog("Verify Order status section");
            getMyAccountPageThreadLocal().verifyOrderStatusSection(true);

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
