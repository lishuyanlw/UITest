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

public class CP_TC12_VerifyOrderConfirmationPage_Contents_LinkageWithCheckoutPage extends BaseTest{
	/*
	 * CER-888
	 */
	@Test(groups={"Regression","Checkout"})
	public void CP_TC12_VerifyOrderConfirmationPage_Contents_LinkageWithCheckoutPage() throws IOException {
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
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lblPromoteCodeAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblPromoteCodeAppliedMessage();
		List<String> lstPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode();

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

		if(!getRegularCheckoutThreadLocal().checkPaymentMethodErrorMessageExisting()){
			if(!getRegularCheckoutThreadLocal().checkIfPaymentMethodIsTSC()){
				getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
				getRegularCheckoutThreadLocal().addOrChangePaymentMethod("tsc");
			}
		}
		else{
			getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
			getRegularCheckoutThreadLocal().addNewTSCCard();
			getRegularCheckoutThreadLocal().closeUsingANewCardDialog(true);
		}

		if(!getRegularCheckoutThreadLocal().checkPromoteCodeRemoveButtonExisting()){
			reporter.reportLog("Add valid promote code scenario");
			getRegularCheckoutThreadLocal().ApplyPromoteCodeForPositiveScenario(lstPromoteCode);
			String lblOrderSummaryPromoteCodeAppliedMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryPromoteCodeAppliedMessage);
			if(lblOrderSummaryPromoteCodeAppliedMessage.equalsIgnoreCase(lblPromoteCodeAppliedMessage)){
				reporter.reportLogPass("The applied message for valid promote code is tha same as the expected one");
			}
			else{
				reporter.reportLogFail("The applied message:'"+lblOrderSummaryPromoteCodeAppliedMessage+"' for invalid promote code is not tha same as the expected one:'"+lblPromoteCodeAppliedMessage+"'");
			}
		}

		getRegularCheckoutThreadLocal().setPaymentOptionByRandomIndex();
		int installmentNumberInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentNumberFromPaymentOptionText();

		List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
		float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");
		Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		Map<String,Object> easyPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getEasyPayDesc();

		getRegularCheckoutThreadLocal().goToOrderConfirmationPage();

		Map<String,Object> orderReceiptForOrderConfirmationPage=getOrderConfirmationThreadLocal().getReceiptDesc();
		List<Map<String,Object>> orderListMapForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderListDesc();
		Map<String,Object> orderSummaryForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderSummaryDesc();
		Map<String,Object> easyPaymentForOrderConfirmationPage=getOrderConfirmationThreadLocal().getEasyPayDesc();

		getOrderConfirmationThreadLocal().verifyOrderConfirmationContents();
		getOrderConfirmationThreadLocal().verifyReceiptContents();
		getOrderConfirmationThreadLocal().verifyOrderListContents();
		getOrderConfirmationThreadLocal().verifyPaymentCardContents();
		getOrderConfirmationThreadLocal().verifyOrderSummaryContents();
		getOrderConfirmationThreadLocal().verifyEasyPayContents();
		getOrderConfirmationThreadLocal().verifyCommonQuestionsContents();


	}
}

