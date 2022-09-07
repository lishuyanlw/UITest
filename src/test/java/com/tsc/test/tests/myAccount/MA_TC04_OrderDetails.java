package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MA_TC04_OrderDetails extends BaseTest {
    /*
     * CER-793
     * CER-872
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC04_OrderDetails() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

        //Login using valid username and password
        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);
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
        if(!getMyAccountPageThreadLocal().checkOrderItemExisting()){
            reporter.reportLogFail("No order items existing");
            return;
        }

        String lsSelectedOrderNO=getMyAccountPageThreadLocal().goToOrderDetailsPage();
        if(lsSelectedOrderNO==null){
            String expectedNoOrderRecorderMessage=TestDataHandler.constantData.getMyAccount().getLbl_noOrderRecordsMessage();
            getMyAccountPageThreadLocal().verifyNoOrderRecordsMessage(expectedNoOrderRecorderMessage);
            return;
        }

        String lnk_orderDetailsURL=TestDataHandler.constantData.getMyAccount().getLnk_orderDetailsURL();
        lnk_orderDetailsURL=lnk_orderDetailsURL.replace("{OrderNO}",lsSelectedOrderNO);
        String expectedURL=basePage.getBaseURL()+lnk_orderDetailsURL;
        if(basePage.URL().equalsIgnoreCase(expectedURL)){
            reporter.reportLogPass("The navigated order details URL is equal to expected one:"+expectedURL);
        }
        else{
            reporter.reportLogFail("The actual order details navigated URL:+"+basePage.URL()+" is not equal to expected one:"+expectedURL);
        }

        //Fetching test data from test data file
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

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
