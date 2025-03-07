package com.tsc.test.tests.orderTracking;

import com.tsc.api.pojo.GetGivenOrderResponse;
import com.tsc.api.pojo.PlaceOrderResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class OT_TC03_OrderTracking_ByOrderNumberAndBillingPostalCode extends BaseTest {
    /*
     *CER-911
     */
    @Test(groups={"OrderTracking","Regression"})
    public void OT_TC03_OrderTracking_ByOrderNumberAndBillingPostalCode() throws IOException, ParseException {
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

        //Adding TSC Credit Card to user for test
        getShoppingCartThreadLocal().addTSCCreditCardForUser(null,customerEDP,accessToken);

        //Adding place order
        List<Map<String,String>> itemsToBeAdded = TestDataHandler.constantData.getCheckOut().getLstOrderDetailItems();
        GetGivenOrderResponse getGivenOrderResponse = getMyAccountPageThreadLocal().getExistingOrderInEditableMode(2,customerEDP,accessToken);
        if(getGivenOrderResponse==null) {
            getMyAccountPageThreadLocal().placeOrderForUser(Integer.parseInt(customerEDP), accessToken, itemsToBeAdded, 2, "all", true, 0);
        }

        List<Map<String,Object>> dataList = getOrderTrackingThreadLocal().getPlacedOrderListForUser(2,null,customerEDP,accessToken,null,null,null,null);
        Map<String,Object> dataMapItem=dataList.get(0);
        String lsOrderNumberFromApi= (String) dataMapItem.get("orderNumber");
        String lsPostalCodeFromApi= (String) dataMapItem.get("postalCode");
        String lsOrderPlacedDateTimeFromApi= (String) dataMapItem.get("orderPlacedDateTime");

        List<Map<String,Object>> orderDetailsMapFromApi= (List<Map<String, Object>>) dataMapItem.get("orderDetails");

        List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
        getOrderTrackingThreadLocal().goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter( getGlobalFooterPageThreadLocal() ,lstNameAndLinks);

        String lsUrlBeforeGoToOrderTrackingPage=basePage.URL();

        if(!getOrderTrackingThreadLocal().goToOrderTrackingPageByOrderNumberAndBillingPostal(lsOrderNumberFromApi,lsPostalCodeFromApi)){
            reporter.reportLogFailWithScreenshot("Unable to navigate to order tracking page");
            return;
        }

        String lsOrderNumberForOrderTracking=getOrderTrackingThreadLocal().getOrderTrackingNumber();
        String lsOrderDateForOrderTracking=getOrderTrackingThreadLocal().getOrderDate();

        if(lsOrderNumberFromApi.substring(7).equalsIgnoreCase(lsOrderNumberForOrderTracking.substring(7))){
            reporter.reportLogPass("The order number:"+lsOrderNumberForOrderTracking+" on order tracking page is the same as the one:"+lsOrderNumberFromApi+" from API calling");
        }
        else{
            reporter.reportLogFail("The order number:"+lsOrderNumberForOrderTracking+" on order tracking page is not the same as the one:"+lsOrderNumberFromApi+" from API calling");
        }

        if(basePage.replaceBlank(lsOrderPlacedDateTimeFromApi.split(":")[0]).equalsIgnoreCase(basePage.replaceBlank(lsOrderDateForOrderTracking.split(":")[0]))){
            reporter.reportLogPass("The order date:"+lsOrderDateForOrderTracking+" on order tracking page is the same as the one:"+lsOrderPlacedDateTimeFromApi+" from API calling");
        }
        else{
            reporter.reportLogFail("The order date:"+lsOrderDateForOrderTracking+" on order tracking page is not the same as the one:"+lsOrderPlacedDateTimeFromApi+" from API calling");
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
        getOrderTrackingThreadLocal().verifyOrderListLinkageBetweenOrderDetailsPageAndOrderTrackingPage(orderDetailsMapFromApi,orderListMapForOrderTracking,"API");

        reporter.reportLog("Verify Back button in header");
        getOrderTrackingThreadLocal().verifyBackButton(lsUrlBeforeGoToOrderTrackingPage);

    }
}
