package com.tsc.test.tests.orderTracking;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OT_TC04_OrderTracking_GestCheckout_ByOrderNumberAndBillingPostalCode extends BaseTest{
	/*
	 * CER-916
	 */
	@Test(groups={"Regression","GuestCheckout"})
	public void OT_TC04_OrderTracking_GestCheckout_ByOrderNumberAndBillingPostalCode() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
			String[] lstStyle = getProductDetailPageThreadLocal().getStyleList();
			String[] lstSizeFirstItem = getProductDetailPageThreadLocal().getSizeListForGivenStyle(0);
			//String[] lstSizeSecondItem = getProductDetailPageThreadLocal().getSizeListForGivenStyle(1);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSizeFirstItem[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);

			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut);
			getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut.click();
			basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().btnCreateAccountOrContinueAsGuest.isDisplayed();},120000);

			getGlobalLoginPageThreadLocal().goToGuestCheckoutPage();
			List<Map<String,Object>> checkoutItemListMap=getGuestCheckoutThreadLocal().getCheckoutItemListDesc("mandatory");

			Map<String,Object> createdUserMap=getGuestCheckoutThreadLocal().createNewAccount(null,null,false);
			String postalCode= (String) createdUserMap.get("postalCode");

			getGuestCheckoutThreadLocal().goToPaymentPage();
			getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("tsc");

			reporter.reportLog("Navigate to Review Screen");
			getGuestCheckoutThreadLocal().goToReviewPage();

			getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
			String orderNumber=getOrderConfirmationThreadLocal().getOrderNumber();
			Map<String,Object> receiptMap=getOrderConfirmationThreadLocal().getReceiptDesc();
			String orderDateOnOrderConfirmationPage= (String) receiptMap.get("orderDate");
			List<Map<String,Object>> orderItemListMapForOrderConfirmation=getOrderConfirmationThreadLocal().getOrderListDesc();

			List<List<String>> lstNameAndLinks=TestDataHandler.constantData.getFooterSection().getLst_NameAndLinks();
			getOrderTrackingThreadLocal().goToTrackOrderPortalThroughClickingTrackYourOrderItemOnGlobalFooter( getGlobalFooterPageThreadLocal() ,lstNameAndLinks);

			String lsUrlBeforeGoToOrderTrackingPage=basePage.URL();
			getOrderTrackingThreadLocal().goToOrderTrackingPageByOrderNumberAndBillingPostal(orderNumber,postalCode);

			String lsOrderNumberForOrderTracking=getOrderTrackingThreadLocal().getOrderTrackingNumber();
			String lsOrderDateForOrderTracking=getOrderTrackingThreadLocal().getOrderDate();

			if(lsOrderNumberForOrderTracking.contains(orderNumber)){
				reporter.reportLogPass("The order number:"+lsOrderNumberForOrderTracking+" on order tracking page is the same as the one:"+orderNumber+" on orderConfirmation page");
			}
			else{
				reporter.reportLogFail("The order number:"+lsOrderNumberForOrderTracking+" on order tracking page is not the same as the one:"+orderNumber+" on orderConfirmation page");
			}

			if(basePage.replaceBlank(lsOrderDateForOrderTracking).replace(",","").toLowerCase().contains(basePage.replaceBlank(orderDateOnOrderConfirmationPage).replace(",","").toLowerCase())){
				reporter.reportLogPass("The order date:"+lsOrderDateForOrderTracking+" on order tracking page is the same as the one:"+orderDateOnOrderConfirmationPage+" on OrderConfirmation page");
			}
			else{
				reporter.reportLogFail("The order date:"+lsOrderDateForOrderTracking+" on order tracking page is not the same as the one:"+orderDateOnOrderConfirmationPage+" on OrderConfirmation pag");
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

			reporter.reportLog("Verify Order List Linkage Between OrderConfirmationPage And OrderTrackingPage");
			getOrderTrackingThreadLocal().verifyOrderListLinkageBetweenOrderDetailsPageAndOrderTrackingPage(orderItemListMapForOrderConfirmation,orderListMapForOrderTracking,"orderConfirmationPage");

			reporter.reportLog("Verify Back button in header");
			getOrderTrackingThreadLocal().verifyBackButton(lsUrlBeforeGoToOrderTrackingPage);
		}
	}
}
