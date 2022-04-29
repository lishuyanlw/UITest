package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

public class MA_TC04_OrderDetails extends BaseTest {
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC04_OrderDetails() throws ParseException, IOException {
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
        if(!getMyAccountPageThreadLocal().checkOrderItemExisting()){
            reporter.reportLogFail("No order items existing");
            return;
        }

        String lsSelectedOrderNO=getMyAccountPageThreadLocal().goToOrderDetailsPage();

        String lnk_orderDetailsURL=TestDataHandler.constantData.getMyAccount().getLnk_orderDetailsURL();
        lnk_orderDetailsURL=lnk_orderDetailsURL.replace("{OrderNO}",lsSelectedOrderNO);
        String expectedURL=basePage.getBaseURL()+lnk_orderDetailsURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated order details URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogPass("The actual order details navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        //Fetching test data from test data file
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();

        String lsTestDevice = System.getProperty("Device").trim();
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

        reporter.reportLog("Verify order main header");
        getMyAccountPageThreadLocal().verifyMainHeaderSectionInOrderDetails(lsSelectedOrderNO,customerNumber);
        getMyAccountPageThreadLocal().verifyMainHeaderSectionInOrderDetails_DifferentDevice();

        reporter.reportLog("Verify order sub header");
        getMyAccountPageThreadLocal().verifySubHeaderSectionInOrderDetails(lsSelectedOrderNO);
        getMyAccountPageThreadLocal().verifySubHeaderSectionInOrderDetails_DifferentDevices();

        reporter.reportLog("Verify order item list section");
        getMyAccountPageThreadLocal().verifyOrderItemListSectionInOrderDetails();

        reporter.reportLog("Verify order summary section");
        getMyAccountPageThreadLocal().verifySummarySectionInOrderDetails();

        reporter.reportLog("To compare subTotal and order total");
        getMyAccountPageThreadLocal().verifySubTotalAndOrderTotal();

    }
}
