package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class MA_TC22_OrderTracking_ByOrderNumberAndBillingPostalCode extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC22_OrderTracking_ByOrderNumberAndBillingPostalCode() throws IOException, ParseException {
        //Closing SignIn pop up on login
        getGlobalFooterPageThreadLocal().closePopupDialog();

        reporter.reportLog("Verify SignIn");
        BasePage basePage=new BasePage(this.getDriver());
        //Fetching test data from test data file
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
        ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
        apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lblUserName,lblPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

        String accessToken = apiUserSessionData.get("access_token").toString();
        String customerEDP = apiUserSessionData.get("customerEDP").toString();
        getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();

        List<Map<String,Object>> dataList = getOrderTrackingThreadLocal().getPlacedOrderListForUser(2,null,customerEDP,accessToken,null,null,null,null);
        Map<String,Object> dataMapItem=dataList.get(0);
        String lsOrderNumberFromApi= (String) dataMapItem.get("orderNumber");
        String lsPostalCodeFromApi= (String) dataMapItem.get("postalCode");
        List<Map<String,Object>> orderDetailsMapFromApi= (List<Map<String, Object>>) dataMapItem.get("orderDetails");

        List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        getOrderTrackingThreadLocal().goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter( getGlobalFooterPageThreadLocal() ,lstNameAndLinks);

        String lsUrlBeforeGoToOrderTrackingPage=basePage.URL();
        getOrderTrackingThreadLocal().goToOrderTrackingPageByOrderNumberAndBillingPostal(lsOrderNumberFromApi,lsPostalCodeFromApi);

        getOrderTrackingThreadLocal().getOrderTrackingNumber();

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
        getOrderTrackingThreadLocal().verifyOrderListLinkageBetweenOrderDetailsPageAndOrderTrackingPage(orderDetailsMapFromApi,orderListMapForOrderTracking);

        reporter.reportLog("Verify Back button in header");
        getOrderTrackingThreadLocal().verifyBackButton(lsUrlBeforeGoToOrderTrackingPage);

    }
}
