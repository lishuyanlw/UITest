package com.tsc.test.tests.guestCheckoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCP_TC02_VerifyPaymentContents extends BaseTest{
	/*
	 * CER-900
	 */
	@Test(groups={"Regression","GuestCheckout"})
	public void GCP_TC02_VerifyPaymentContents() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

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

			Map<String,String> createdUserMap=getGuestCheckoutThreadLocal().createNewAccount(null,null,true);

			getGuestCheckoutThreadLocal().goToPaymentPage();

			reporter.reportLog("Verify Checkout Product List");
			getGuestCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();
			getGuestCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();

			reporter.reportLog("Verify payment Contents");
			getGuestCheckoutThreadLocal(). verifyAddingNewCardContents();

			reporter.reportLog("Verify OrderSummary Contents");
			getRegularCheckoutThreadLocal().verifyOrderSummaryContents();

			reporter.reportLog("Verify Promote Code Contents and ContinueToPayment Button");
			getRegularCheckoutThreadLocal().verifyPromoteCodeContents();

			reporter.reportLog("Verify Promote Code Contents and Continue To Review Button");
			getGuestCheckoutThreadLocal().verifyGiftCardAndContinueToReviewButtonContents();
		}
	}
}
