package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.AccountCartResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC10_VerifyReguLarCheckout_PromoteCode extends BaseTest{
	/*
	 * CER-888
	 */
	@Test(groups={"Regression","Checkout","CheckoutMobTab"})
	public void CP_TC10_VerifyReguLarCheckout_PromoteCode() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

		//Verifying that item exists in cart and if not, create a new cart for user
		List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
		getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,true);
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lblPromoteCodeAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblPromoteCodeAppliedMessage();
		List<String> lstPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode();
		List<String> lstInvalidPromoteCodeAndErrorMessage=TestDataHandler.constantData.getCheckOut().getLstInvalidPromoteCodeAndErrorMessage();
		String lblPromoteCodeErrorMessage=lstInvalidPromoteCodeAndErrorMessage.get(1).replace("<promoteCode>","\""+lstInvalidPromoteCodeAndErrorMessage.get(0)+"\"");

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

		getRegularCheckoutThreadLocal().navigateToCheckoutPage();

		reporter.reportLog("Verify promote code");
		String lsText;
		reporter.reportLog("Verify invalid promote code scenario");
		getRegularCheckoutThreadLocal().ApplyPromoteCodeForNegativeScenario(lstInvalidPromoteCodeAndErrorMessage.get(0));
		String lblOrderSummaryPromoteCodeErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryPromoteCodeErrorMessage);
		if(lblOrderSummaryPromoteCodeErrorMessage.equalsIgnoreCase(lblPromoteCodeErrorMessage)){
			reporter.reportLogPass("The error message for invalid promote code is tha same as the expected one");
		}
		else{
			reporter.reportLogFail("The error message:'"+lblOrderSummaryPromoteCodeErrorMessage+"' for invalid promote code is not tha same as the expected one:'"+lblPromoteCodeErrorMessage+"'");
		}

		reporter.reportLog("Verify valid promote code scenario");
		getRegularCheckoutThreadLocal().ApplyPromoteCodeForPositiveScenario(lstPromoteCode);
		String lblOrderSummaryPromoteCodeAppliedMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryPromoteCodeAppliedMessage);
		if(lblOrderSummaryPromoteCodeAppliedMessage.equalsIgnoreCase(lblPromoteCodeAppliedMessage)){
			reporter.reportLogPass("The applied message for valid promote code is tha same as the expected one");
		}
		else{
			reporter.reportLogFail("The applied message:'"+lblOrderSummaryPromoteCodeAppliedMessage+"' for valid promote code is not the same as the expected one:'"+lblPromoteCodeAppliedMessage+"'");
		}

		lsText=basePage.getElementInnerText(getRegularCheckoutThreadLocal().btnOrderSummaryRemovePromoteCode);
		if(!lsText.isEmpty()){
			reporter.reportLogPass("The remove button for applied promote code is displaying correctly");
		}
		else{
			reporter.reportLogFail("The remove button for applied promote code is not displaying correctly");
		}

		getRegularCheckoutThreadLocal().setPaymentOptionByRandomIndex();
		int installmentNumberInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentNumberFromPaymentOptionText();

		List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
		float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");
		Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		Map<String,Object> easyPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getEasyPayDesc();

		reporter.reportLog("Verify OrderSummary Business Logic");
		getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList, orderSummaryMapOnCheckoutPage, null);

		reporter.reportLog("Verify Installment Business Logic");
		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentNumberInPaymentOption, orderSummaryMapOnCheckoutPage);

		reporter.reportLog("Verify OrderSummary on ShoppingCart page");
		getRegularCheckoutThreadLocal().GoToShoppingBag();
		int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
		float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
		float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();
		Map<String,Object> orderSummaryMapOnShoppingCartPage=getShoppingCartThreadLocal().getOrderSummaryDesc();
		Map<String,Object> easyPaymentMapOnShoppingCartPage=getShoppingCartThreadLocal().getEasyPayDesc();

		reporter.reportLog("Verify OrderSummary Business Logic");
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,orderSummaryMapOnShoppingCartPage,null);

		reporter.reportLog("Verify OrderSummary Linkage Between ShoppingCart Page And Checkout Page");
		getRegularCheckoutThreadLocal().verifyOrderSummaryLinkageBetweenShoppingCartPageAndCheckoutPage(orderSummaryMapOnShoppingCartPage,orderSummaryMapOnCheckoutPage);

		reporter.reportLog("verify EasyPayment Linkage Between ShoppingCart Page And Checkout Page");
		getRegularCheckoutThreadLocal().verifyEasyPaymentLinkageBetweenShoppingCartPageAndCheckoutPage(easyPaymentMapOnShoppingCartPage,easyPaymentMapOnCheckoutPage);

	}
}

