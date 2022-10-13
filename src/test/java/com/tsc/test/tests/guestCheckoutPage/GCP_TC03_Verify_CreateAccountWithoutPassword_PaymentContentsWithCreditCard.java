package com.tsc.test.tests.guestCheckoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCP_TC03_Verify_CreateAccountWithoutPassword_PaymentContentsWithCreditCard extends BaseTest{
	/*
	 * CER-899
	 * CER-900
	 * CER-901
	 */
	@Test(groups={"Regression","GuestCheckout"})
	public void GCP_TC03_Verify_CreateAccountWithoutPassword_PaymentContentsWithCreditCard() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
			String[] lstStyle = getProductDetailPageThreadLocal().getStyleList();
			String[] lstSize0 = getProductDetailPageThreadLocal().getSizeListForGivenStyle(0);
			String[] lstSize1 = getProductDetailPageThreadLocal().getSizeListForGivenStyle(1);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSize0[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
			basePage.applyStaticWait(basePage.getStaticWaitForApplication());

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[1], lstSize1[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);

			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut);
			getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut.click();
			basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().btnCreateAccountOrContinueAsGuest.isDisplayed();},120000);

			getGlobalLoginPageThreadLocal().goToGuestCheckoutPage();

			Map<String,Object> createdUserMap=getGuestCheckoutThreadLocal().createNewAccount(null,null,false);

			getGuestCheckoutThreadLocal().goToPaymentPage();

			reporter.reportLog("Verify Checkout Product List");
			getGuestCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();
			getGuestCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();

			reporter.reportLog("Verify payment Contents");
			getGuestCheckoutThreadLocal(). verifyAddingNewCardContents();

			reporter.reportLog("Verify OrderSummary Contents");
			getRegularCheckoutThreadLocal().verifyOrderSummaryContents();

			reporter.reportLog("Verify OrderSummary Business Logic");
			List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
			Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
			float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");
			Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
			getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList, orderSummaryMapOnCheckoutPage, null);

			reporter.reportLog("Verify Promote Code Contents and ContinueToPayment Button");
			getRegularCheckoutThreadLocal().verifyPromoteCodeContents();

			reporter.reportLog("Verify Promote Code Contents and Continue To Review Button");
			getGuestCheckoutThreadLocal().verifyGiftCardAndContinueToReviewButtonContents();

			Map<String,Object> mapAddedPayment=getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("visa");

			getGuestCheckoutThreadLocal().goToReviewPage();

			reporter.reportLog("Verify Created Shipping Address Linkage with Checkout page");
			productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
			Map<String,Object> mapForShippingAddressAndPaymentOnCheckout=getRegularCheckoutThreadLocal().getShippingAndPaymentDesc(productListMapForCheckOutPage.get(0));
			getGuestCheckoutThreadLocal().verifyCreatedShippingAddressLinkageWithCheckoutPage(createdUserMap);

			reporter.reportLog("Verify Created payment Linkage with Checkout page");
			getGuestCheckoutThreadLocal().verifyPaymentLinkageWithCheckoutPage(mapAddedPayment,mapForShippingAddressAndPaymentOnCheckout);

		}
	}
}
