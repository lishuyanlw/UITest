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
	 * CER-889
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

		//Verifying that item exists in cart and if not, create a new cart for user
		List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
		getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,true);

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

		Map<String,Object> shippingAndPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getShippingAndPaymentDesc(productListMapForCheckOutPage.get(0));

		Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		Map<String,Object> easyPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getEasyPayDesc();

		getRegularCheckoutThreadLocal().goToOrderConfirmationPage();

		Map<String,Object> orderReceiptForOrderConfirmationPage=getOrderConfirmationThreadLocal().getReceiptDesc();

		List<Map<String,Object>> orderListMapForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderListDesc();
		Map<String,Object> itemCountAndSubTotalMap=getOrderConfirmationThreadLocal().getCheckoutItemCountAndSubTotal(orderListMapForOrderConfirmationPage);
		int itemCountForOrderConfirmationList= (int) itemCountAndSubTotalMap.get("itemCount");
		float subTotalForOrderConfirmationList= (float) itemCountAndSubTotalMap.get("subTotal");

		reporter.reportLog("Verify product list linkage between OrderConfirmationPage and CheckoutPage");
		if(itemCountForOrderConfirmationList==itemCountForCheckOutList){
			reporter.reportLogPass("The order item count in OrderConfirmation Page is the same as the one in CheckOut page");
		}
		else{
			reporter.reportLogFail("The order item count:"+itemCountForOrderConfirmationList+" in OrderConfirmation Page is the same as the one:"+itemCountForCheckOutList+" in CheckOut page");
		}

		if(Math.abs(subTotalForOrderConfirmationList-subTotalForCheckOutList)<0.1f){
			reporter.reportLogPass("The order subTotal in OrderConfirmation Page is the same as the one in CheckOut page");
		}
		else{
			reporter.reportLogFail("The order subTotal:"+subTotalForOrderConfirmationList+" in OrderConfirmation Page is the same as the one:"+subTotalForCheckOutList+" in CheckOut page");
		}

		int findIndex;
		Map<String,Object> checkoutItem;
		for(Map<String,Object> orderItem:orderListMapForOrderConfirmationPage){
			String lsShoppingCartText=(String)orderItem.get("productName");
			reporter.reportLog("Verify product:'"+lsShoppingCartText+"'");
			findIndex=getShoppingCartThreadLocal().findGivenProductIndexInProductList(orderItem,productListMapForCheckOutPage);
			if(findIndex!=-1){
				checkoutItem=productListMapForCheckOutPage.get(findIndex);
				getOrderConfirmationThreadLocal().verifyProductListLinkageBetweenOrderConfirmationPageAndCheckoutPage(orderItem,checkoutItem);
			}
			else{
				reporter.reportLogFail("");
			}
		}

		Map<String,Object> shippingAndPaymentMapForOrderConfirmationPage=getOrderConfirmationThreadLocal().getShippingAndPaymentDesc(orderListMapForOrderConfirmationPage.get(0));

		reporter.reportLog("Verify OrderSummary Business Logic");
		Map<String,Object> orderSummaryForOrderConfirmationPage=getOrderConfirmationThreadLocal().getOrderSummaryDesc();
		getOrderConfirmationThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForOrderConfirmationList,orderSummaryForOrderConfirmationPage,null);

		reporter.reportLog("verify OrderSummary Linkage Between OrderConfirmationPage And CheckoutPage");
		getOrderConfirmationThreadLocal().verifyOrderSummaryLinkageBetweenOrderConfirmationPageAndCheckoutPage(orderSummaryForOrderConfirmationPage,orderSummaryMapOnCheckoutPage);

		reporter.reportLog("Verify OrderSummary EasyPayment Business Logic");
		Map<String,Object> easyPaymentForOrderConfirmationPage=getOrderConfirmationThreadLocal().getEasyPayDesc();
		getOrderConfirmationThreadLocal().verifyInstallmentBusinessLogic(orderSummaryForOrderConfirmationPage);

		reporter.reportLog("verify EasyPayment Linkage Between OrderConfirmationPage And CheckoutPage");
		getRegularCheckoutThreadLocal().verifyEasyPaymentLinkageBetweenShoppingCartPageAndCheckoutPage(easyPaymentForOrderConfirmationPage,easyPaymentMapOnCheckoutPage);

		reporter.reportLog("verify Shipping and Payment Linkage Between OrderConfirmationPage And CheckoutPage");
		getOrderConfirmationThreadLocal().verifyShippingAndPaymentLinkageBetweenOrderConfirmationPageAndCheckoutPage(shippingAndPaymentMapForOrderConfirmationPage,shippingAndPaymentMapOnCheckoutPage);

		reporter.reportLog("Verify OrderConfirmation header Contents");
		getOrderConfirmationThreadLocal().verifyOrderConfirmationContents();

		reporter.reportLog("Verify Receipt Contents");
		getOrderConfirmationThreadLocal().verifyReceiptContents();

		reporter.reportLog("Verify Order List Contents");
		getOrderConfirmationThreadLocal().verifyOrderListContents();

		reporter.reportLog("Verify Payment Card Contents");
		getOrderConfirmationThreadLocal().verifyPaymentCardContents();

		reporter.reportLog("Verify OrderSummary Contents");
		getOrderConfirmationThreadLocal().verifyOrderSummaryContents();

		reporter.reportLog("Verify EasyPayment Contents");
		getOrderConfirmationThreadLocal().verifyEasyPayContents();

		reporter.reportLog("Verify Common Questions Contents");
		getOrderConfirmationThreadLocal().verifyCommonQuestionsContents();


	}
}

