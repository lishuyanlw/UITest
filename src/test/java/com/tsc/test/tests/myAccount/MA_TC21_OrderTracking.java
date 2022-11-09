package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalFooterPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MA_TC21_OrderTracking extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC21_OrderTracking() throws IOException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        String userName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String password = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        String grantType = TestDataHandler.constantData.getApiUserSessionParams().getLbl_grantType();
        String apiKey = TestDataHandler.constantData.getApiUserSessionParams().getLbl_apiKey();

        List<Map<String,Object>> apiDataMap=getOrderTrackingThreadLocal().getPlacedOrderListForUser(userName, password,grantType, apiKey, 2, null);

        //Fetching test data from test data file
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();



        //Login using valid username and password
//        getGlobalLoginPageThreadLocal().Login(lblUserName, lblPassword);

        List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        getOrderTrackingThreadLocal().goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter( getGlobalFooterPageThreadLocal() ,lstNameAndLinks);



        getOrderTrackingThreadLocal().goToOrderTrackingPageByUserNameAndPassword(lblUserName,lblPassword);

        String expectedNoOrderRecorderMessage=TestDataHandler.constantData.getMyAccount().getLbl_noOrderRecordsMessage();
        if(getMyAccountPageThreadLocal().checkOrderItemExisting()){
            getMyAccountPageThreadLocal().goToOrderDetailsPage();
            Map<String,Object> dataDescExceptOrderListForOrderDetails=getMyAccountPageThreadLocal().getOrderDetailsDescExceptOrderList();
            String lsOrderNumberForOrderDetails= (String) dataDescExceptOrderListForOrderDetails.get("orderNumber");
            String lsOrderDateForOrderDetails= (String) dataDescExceptOrderListForOrderDetails.get("orderDate");

            List<Map<String,Object>> orderListMapForOrderDetails=getMyAccountPageThreadLocal().getOrderListDesc();

            String lsUrlBeforeGoToOrderTrackingPage=basePage.URL();
            getMyAccountPageThreadLocal().goToOrderTrackingPage();
            String lsOrderNumberForOrderTracking=getOrderTrackingThreadLocal().getOrderTrackingNumber();
            
            List<Map<String,Object>> orderListMapForOrderTracking=getOrderTrackingThreadLocal().getOrderListDesc();

            reporter.reportLog("Verify Order Tracking Header Section");
            getOrderTrackingThreadLocal().verifyOrderTrackingHeaderSection();

            reporter.reportLog("Verify Order Tracking Status Section");
            getOrderTrackingThreadLocal().verifyOrderTrackingStatusSection();

            reporter.reportLog("Verify Order Tracking Delivery EstimateDate Section");
            getOrderTrackingThreadLocal().verifyOrderTrackingDeliveryEstimateDateSection();

            reporter.reportLog("Verify Order Tracking Items Section");
            getOrderTrackingThreadLocal().verifyOrderTrackingItemsSection();

            reporter.reportLog("Verify Order List Linkage Between OrderDetailsPage And OrderTrackingPage");
            getOrderTrackingThreadLocal().verifyOrderListLinkageBetweenOrderDetailsPageAndOrderTrackingPage(orderListMapForOrderDetails,orderListMapForOrderTracking);

            reporter.reportLog("Verify Back button in header");
            getOrderTrackingThreadLocal().verifyBackButton(lsUrlBeforeGoToOrderTrackingPage);
        }
        else{
            getMyAccountPageThreadLocal().verifyNoOrderRecordsMessage(expectedNoOrderRecorderMessage);
        }
    }
}
