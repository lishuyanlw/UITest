package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CP_TC03_VerifyReguLarCheckout_ShippingDate_MultiPackMessage extends BaseTest{
	/*
	 * CER-873
	 */
	@Test(groups={"Regression","Checkout"})
	public void CP_TC03_VerifyReguLarCheckout_ShippingDate_MultiPackMessage() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());

		getGlobalFooterPageThreadLocal().closePopupDialog();
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

		reporter.reportLog("Verify the scenario of ShippingDate for each checkout item scenario with different checkout item");
		List<Map<String, String>> keywordForDifferentProducts = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keywordForDifferentProducts,true);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		BasePage basePage=new BasePage(this.getDriver());
		try {
			getShoppingCartThreadLocal().waitForCondition(Driver -> {
				return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
			}, 6000);
		}
		catch(Exception e){
			(new BasePage(this.getDriver())).applyStaticWait(3000);
		}
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();
		if(getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()){
			List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
			getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
		}
		int installmentsNumberForShoppingCart=getShoppingCartThreadLocal().getInstallmentNumber();
		getShoppingCartThreadLocal().goToCheckoutPage();

		List<Map<String,Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");

		String lsText;
		for(Map<String,Object> checkoutItem:productListMapForCheckOutPage){
			lsText=checkoutItem.get("productName").toString();
			reporter.reportLog("Verify product: "+lsText);
			if(checkoutItem.get("productShippingDate")!=null){
				reporter.reportLogPass("The shipping date is displaying correctly");
			}
			else{
				reporter.reportLogFail("The shipping date is not displaying correctly");
			}
		}

		String lsCheckoutShippingDate=getRegularCheckoutThreadLocal().getShippingDateInHeader();
		if(lsCheckoutShippingDate==null){
			reporter.reportLogPass("The GetItByShippingMessage is not displaying in the checkout page separately");
		}
		else{
			reporter.reportLogFail("The GetItByShippingMessage is still displaying in the checkout page separately");
		}

		productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		Map<String,Object> summaryMapForCheckOutList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		int itemCountForCheckOutList= (int) summaryMapForCheckOutList.get("itemCount");
		float subTotalForCheckOutList= (float) summaryMapForCheckOutList.get("subTotal");

		reporter.reportLog("Verify orderSummary business logic");
		Map<String,Object> orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList,orderSummaryMapForCheckOutPage,null);

		reporter.reportLog("Verify installment business logic");
		Map<String,Object> easyPaymentMapForCheckOutPage = getRegularCheckoutThreadLocal().getEasyPayDesc();
		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart,orderSummaryMapForCheckOutPage);

		reporter.reportLog("Verify the scenario of ShippingDate in header");
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

		Map<String, String> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords().get(0);
		List<Map<String, String>> keywordList=new ArrayList<>();
		keywordList.add(keyword);
		data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keywordList,true);
		basePage.refresh();

		lsCheckoutShippingDate=getRegularCheckoutThreadLocal().getShippingDateInHeader();
		if(lsCheckoutShippingDate!=null){
			reporter.reportLogPass("The GetItByShippingMessage is displaying in the checkout page separately");
		}
		else{
			reporter.reportLogFail("The GetItByShippingMessage is not displaying in the checkout page separately");
		}

		if(getRegularCheckoutThreadLocal().checkOrderSummarySavingPriceExisting()){
			reporter.reportLogPass("The saving price in orderSummary section is displaying correctly.");
		}
		else{
			reporter.reportLogFail("The saving price in orderSummary section is not displaying correctly.");
		}

		productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		if(productListMapForCheckOutPage.get(0).get("productFreeShipping")!=null&&
				(float)productListMapForCheckOutPage.get(0).get("productNowPrice")<0.1f){

		}
		summaryMapForCheckOutList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		itemCountForCheckOutList= (int) summaryMapForCheckOutList.get("itemCount");
		subTotalForCheckOutList= (float) summaryMapForCheckOutList.get("subTotal");

		int itemCountInHeader=getRegularCheckoutThreadLocal().getOrderItemCount();
		if(itemCountForCheckOutList==itemCountInHeader){
			reporter.reportLogPass("The item count: "+itemCountForCheckOutList+" in checkout item list is equal to the one: "+itemCountInHeader+" in the header");
		}
		else{
			reporter.reportLogFail("The item count: "+itemCountForCheckOutList+" in checkout item list is not equal to the one: "+itemCountInHeader+" in the header");
		}

		reporter.reportLog("Verify orderSummary business logic");
		orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList,orderSummaryMapForCheckOutPage,null);

		reporter.reportLog("Verify installment business logic");
		easyPaymentMapForCheckOutPage = getRegularCheckoutThreadLocal().getEasyPayDesc();
		installmentsNumberForShoppingCart=getRegularCheckoutThreadLocal().getInstallmentNumberFromPaymentOptionText();
		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart,orderSummaryMapForCheckOutPage);

		reporter.reportLog("Verify the scenario of shippingDate for each checkout item scenario with Advanced order item");
		//Add advanced order product using API
		String lsAdvancedOrderKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AdvancedOrderkeyword();
		Map<String,Object> mapAdvancedOrder=getShoppingCartThreadLocal().addSingleProductWithConditions(lsAdvancedOrderKeyword, 1,1, String.valueOf(customerEDP), accessToken,true);
		data.add(mapAdvancedOrder);
		basePage.refresh();
		getRegularCheckoutThreadLocal().setPaymentOptionByGivenInstallmentNumber(installmentsNumberForShoppingCart);

		productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");

		for(Map<String,Object> checkoutItem:productListMapForCheckOutPage){
			lsText=checkoutItem.get("productName").toString();
			reporter.reportLog("Verify product: "+lsText);
			if(checkoutItem.get("productShippingDate")!=null){
				reporter.reportLogPass("The shipping date is displaying correctly");
			}
			else{
				reporter.reportLogFail("The shipping date is not displaying correctly");
			}
		}

		lsCheckoutShippingDate=getRegularCheckoutThreadLocal().getShippingDateInHeader();
		if(lsCheckoutShippingDate==null){
			reporter.reportLogPass("The GetItByShippingMessage is not displaying in the checkout page separately");
		}
		else{
			reporter.reportLogFail("The GetItByShippingMessage is still displaying in the checkout page separately");
		}

		productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		summaryMapForCheckOutList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		itemCountForCheckOutList= (int) summaryMapForCheckOutList.get("itemCount");
		subTotalForCheckOutList= (float) summaryMapForCheckOutList.get("subTotal");

		reporter.reportLog("Verify orderSummary business logic");
		orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList,orderSummaryMapForCheckOutPage,null);

		reporter.reportLog("Verify installment business logic");
		easyPaymentMapForCheckOutPage = getRegularCheckoutThreadLocal().getEasyPayDesc();
		installmentsNumberForShoppingCart=getRegularCheckoutThreadLocal().getInstallmentNumberFromPaymentOptionText();
		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart,orderSummaryMapForCheckOutPage);
	}
}

