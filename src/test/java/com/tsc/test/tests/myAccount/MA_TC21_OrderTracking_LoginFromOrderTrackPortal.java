package com.tsc.test.tests.myAccount;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MA_TC21_OrderTracking_LoginFromOrderTrackPortal extends BaseTest {
    /*
     *CER-789
     */
    @Test(groups={"MyAccount","Regression"})
    public void MA_TC21_OrderTracking_LoginFromOrderTrackPortal() throws IOException, ParseException {
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
        String customerNumber = getApiResponseThreadLocal().getUserDetailsFromCustomerEDP(customerEDP,accessToken).getCustomerNo();

        List<Map<String,Object>> dataList = getOrderTrackingThreadLocal().getPlacedOrderListForUser(2,null,customerEDP,accessToken,null,null,null,null);
        Map<String,Object> dataMapItem=dataList.get(0);
        String lsOrderNumberFromApi= (String) dataMapItem.get("orderNumber");
        String lsOrderPlacedDateTimeFromApi= (String) dataMapItem.get("orderPlacedDateTime");

        List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        getOrderTrackingThreadLocal().goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter( getGlobalFooterPageThreadLocal() ,lstNameAndLinks);

        getOrderTrackingThreadLocal().goToOrderStatusPageByUserNameAndPasswordInOrderTrackingPortalPage(lblUserName,lblPassword);

        String expectedNoOrderRecorderMessage=TestDataHandler.constantData.getMyAccount().getLbl_noOrderRecordsMessage();
        if(getMyAccountPageThreadLocal().checkOrderItemExisting()){
            String lsOrderDetailsURL= TestDataHandler.constantData.getMyAccount().getLnk_orderDetailsURL();
            getMyAccountPageThreadLocal().goToOrderDetailsPageByGivenOrderNumberSearching(lsOrderNumberFromApi,lsOrderDetailsURL);
//            getMyAccountPageThreadLocal().goToOrderDetailsPage();
            Map<String,Object> dataDescExceptOrderListForOrderDetails=getMyAccountPageThreadLocal().getOrderDetailsDescExceptOrderList();
            String lsOrderNumberForOrderDetails= (String) dataDescExceptOrderListForOrderDetails.get("orderNumber");
            String lsOrderDateForOrderDetails= (String) dataDescExceptOrderListForOrderDetails.get("orderDate");

            List<Map<String,Object>> orderListMapForOrderDetails=getMyAccountPageThreadLocal().getOrderListDesc();

            String lsUrlBeforeGoToOrderTrackingPage=basePage.URL();
            getMyAccountPageThreadLocal().goToOrderTrackingPage();
            String lsOrderNumberForOrderTracking=getOrderTrackingThreadLocal().getOrderTrackingNumber();
            String lsOrderDateForOrderTracking=getOrderTrackingThreadLocal().getOrderDate();

            if(lsOrderNumberForOrderDetails.substring(7).equalsIgnoreCase(lsOrderNumberForOrderTracking.substring(7))){
                reporter.reportLogPass("The order number:"+lsOrderNumberForOrderTracking+" on order tracking page is the same as the one:"+lsOrderNumberForOrderDetails+" on order details page");
            }
            else{
                reporter.reportLogFail("The order number:"+lsOrderNumberForOrderTracking+" on order tracking page is not the same as the one:"+lsOrderNumberForOrderDetails+" on order details page");
            }

            if(basePage.replaceBlank(lsOrderDateForOrderDetails).replace(",","").toLowerCase().equalsIgnoreCase(basePage.replaceBlank(lsOrderDateForOrderTracking).replace(",","").toLowerCase())){
                reporter.reportLogPass("The order date:"+lsOrderDateForOrderTracking+" on order tracking page is the same as the one:"+lsOrderDateForOrderDetails+" on order details page");
            }
            else{
                reporter.reportLogFail("The order date:"+lsOrderDateForOrderTracking+" on order tracking page is not the same as the one:"+lsOrderDateForOrderDetails+" on order details page");
            }

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
