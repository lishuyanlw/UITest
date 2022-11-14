package com.tsc.test.tests.checkoutPage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.DataConverter;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC14_VerifyOrderConfirmationPage_Contents_LinkageWithCheckoutPage extends BaseTest{
	/*
	 * CER-889
	 * CER-894
	 * CER-895
	 */
	@Test(groups={"Regression","Checkout","CheckoutMobTab"})
	public void CP_TC14_VerifyOrderConfirmationPage_Contents_LinkageWithCheckoutPage() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		JSONObject creditCardData = new DataConverter().readJsonFileIntoJSONObject("test-data/CreditCard.json");
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

		//Verifying that item exists in cart and if not, create a new cart for user
		List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLstOrderDetailItems();
		getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,"all",false);

		//To add advanced order Product
		String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AdvancedOrderkeyword();
		Map<String,Object> mapAPI=getShoppingCartThreadLocal().addSingleProductWithConditions(lsKeyword, 1,1, String.valueOf(customerEDP), accessToken,true);
		if(mapAPI==null){
			reporter.reportLogFail("Failed to add advanced order product");
		}

		//To add auto delivery order Product
		lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AutoDeliverykeyword();
		mapAPI=getShoppingCartThreadLocal().addSingleProductWithConditions(lsKeyword, 1,1, String.valueOf(customerEDP), accessToken,false);
		if(mapAPI==null){
			reporter.reportLogFail("Failed to add auto delivery product");
		}

		//Setting up initial test environment by deleting all cards associated with user and cart and adding TSC Card
		CartAPI cartAPI = new CartAPI();
		Response response = cartAPI.getAccountCartContentWithCustomerEDP(String.valueOf(customerEDP),accessToken);
		CartResponse cartResponse= JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
		getRegularCheckoutThreadLocal().deleteCreditCardForUserAndFromCart(cartResponse,String.valueOf(customerEDP),accessToken);

		//Adding TSC Credit Card for user
		AccountAPI accountAPI = new AccountAPI();
		Response tscCardResponse = accountAPI.addCreditCardToUser((JSONObject) creditCardData.get("tsc"),String.valueOf(customerEDP),accessToken);
		if(tscCardResponse.statusCode()==200)
			reporter.reportLog("New TSC Credit Card is added for user as default Card");
		else
			reporter.reportLogFail("New TSC Credit Card is not added for user as default Card");

		//Delete promote code and all gift cards
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

		/**
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
		}*/
		boolean bTSC=getRegularCheckoutThreadLocal().checkIfPaymentMethodIsTSC();
		if(bTSC){
			reporter.reportLogPass("The payment method is TSC card");
		}
		else{
			reporter.reportLogFail("The payment method is not TSC card");
		}

		String lsPromoteCodeOnCheckoutPage="";
		if(!getRegularCheckoutThreadLocal().checkPromoteCodeRemoveButtonExisting()){
			reporter.reportLog("Add valid promote code scenario");
			lsPromoteCodeOnCheckoutPage=getRegularCheckoutThreadLocal().applyPromoteCodeForPositiveScenario(lstPromoteCode);
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

		Map<String,Object> shippingAndPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getShippingAndPaymentDesc(productListMapForCheckOutPage.get(0));

		Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		Map<String,Object> easyPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getEasyPayDesc();

		getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
		reporter.reportLog("Verification of guest checkout data on Order Confirmation page");
		getOrderConfirmationThreadLocal().verifyOrderConfirmationPageContents(productListMapForCheckOutPage,orderSummaryMapOnCheckoutPage,easyPaymentMapOnCheckoutPage,shippingAndPaymentMapOnCheckoutPage,getShoppingCartThreadLocal(),null,itemCountForCheckOutList,subTotalForCheckOutList);
	}
}

