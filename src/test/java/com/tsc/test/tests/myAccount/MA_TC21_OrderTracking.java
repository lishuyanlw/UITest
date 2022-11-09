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
        String lblUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
        String lblPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

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
        }
        else{
            getMyAccountPageThreadLocal().verifyNoOrderRecordsMessage(expectedNoOrderRecorderMessage);
        }
    }
}
