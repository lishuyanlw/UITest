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

public class CP_TC10_VerifyReguLarCheckout_PromoteCode_GiftCard extends BaseTest{
	/*
	 * CER-888
	 */
	@Test(groups={"Regression","Checkout"})
	public void CP_TC10_VerifyReguLarCheckout_PromoteCode_GiftCard() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		//To add Product With Multiple Shipping Methods
		String lsKeyword=TestDataHandler.constantData.getCheckOut().getLblProductNumberWithMultipleShippingMethods();
		Map<String,Object> mapAPI=getShoppingCartThreadLocal().addSingleProductWithConditions(lsKeyword, 1,1, String.valueOf(customerEDP), accessToken,false);

		//Delete promote code and all gift cards
		CartAPI cartAPI=new CartAPI();
		Response response=cartAPI.getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP), accessToken);
		AccountCartResponse accountCartGet= JsonParser.getResponseObject(response.asString(), new TypeReference<AccountCartResponse>() {});
		String GuidId=accountCartGet.getCartGuid();
		cartAPI.deletePromoCodeAppliedOnCart(accessToken,GuidId);
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lblPromoteCodeAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblPromoteCodeAppliedMessage();
		String lblGiftCardAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblGiftCardAppliedMessage();
		List<String> lstPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode();
		List<Map<String,String>> lstGiftCard=TestDataHandler.constantData.getCheckOut().getLst_GiftCard();
		List<String> lstInvalidPromoteCodeAndErrorMessage=TestDataHandler.constantData.getCheckOut().getLstInvalidPromoteCodeAndErrorMessage();
		String lblPromoteCodeErrorMessage=lstInvalidPromoteCodeAndErrorMessage.get(1).replace("<promoteCode>","\""+lstInvalidPromoteCodeAndErrorMessage.get(0)+"\"");
		List<String> lstInvalidGiftCardAndErrorMessage=TestDataHandler.constantData.getCheckOut().getLstInvalidGiftCardAndErrorMessage();
		String lblEmptyGiftCardPinErrorMessage=TestDataHandler.constantData.getCheckOut().getLblEmptyGiftCardPinErrorMessage();

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

		reporter.reportLog("Verify invalid promote code scenario");
		getRegularCheckoutThreadLocal().ApplyPromoteCodeForNegativeScenario(lstInvalidPromoteCodeAndErrorMessage.get(0));
		String lblOrderSummaryPromoteCodeErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryPromoteCodeErrorMessage);
		if(lblOrderSummaryPromoteCodeErrorMessage.equalsIgnoreCase(lblPromoteCodeErrorMessage)){
			reporter.reportLogPass("The error message for invalid promote code is tha same as the expected one");
		}
		else{
			reporter.reportLogFail("The error message:'"+lblOrderSummaryPromoteCodeErrorMessage+"' for invalid promote code is tha same as the expected one:'"+lblPromoteCodeErrorMessage+"'");
		}

		reporter.reportLog("Verify valid promote code scenario");
		getRegularCheckoutThreadLocal().ApplyPromoteCodeForNegativeScenario(lstInvalidPromoteCodeAndErrorMessage.get(0));


	}
}

