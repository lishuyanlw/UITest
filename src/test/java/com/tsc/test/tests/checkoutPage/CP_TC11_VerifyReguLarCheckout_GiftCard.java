package com.tsc.test.tests.checkoutPage;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC11_VerifyReguLarCheckout_GiftCard extends BaseTest{
	/*
	 * CER-888
	 */
	@Test(groups={"Regression","Checkout","CheckoutMobTab"})
	public void CP_TC11_VerifyReguLarCheckout_GiftCard() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());

		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

		//Verifying that item exists in cart and if not, create a new cart for user
		List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
		getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,"all",true,0);

		//Delete promote code and all gift cards
		CartAPI cartAPI=new CartAPI();
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lblGiftCardAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblGiftCardAppliedMessage();
		List<Map<String,String>> lstGiftCard=TestDataHandler.constantData.getCheckOut().getLst_GiftCard();
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

		int initialGiftCardNumberLength=getRegularCheckoutThreadLocal().inputOrderSummaryGiftCardNumber.getAttribute("value").replace(" ","").length();
		List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
		float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");

		reporter.reportLog("Verify gift card");
		getRegularCheckoutThreadLocal().setPaymentOptionByGivenIndex(0);
		String inValidGiftCardNumber=lstInvalidGiftCardAndErrorMessage.get(0);
		String invalidGiftCardPin=lstInvalidGiftCardAndErrorMessage.get(1);
		String invalidErrorMessage=lstInvalidGiftCardAndErrorMessage.get(2);
		reporter.reportLog("Verify empty gift card pin scenario");
		getRegularCheckoutThreadLocal().applyGiftCardForNegativeScenario(inValidGiftCardNumber, "",initialGiftCardNumberLength);
		String lsErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryGiftCardErrorMessage);
		if(lsErrorMessage.equalsIgnoreCase(lblEmptyGiftCardPinErrorMessage)){
			reporter.reportLogPass("The error message for empty Gift card pin is the same as the expected one");
		}
		else{
			reporter.reportLogFail("The error message:'"+lsErrorMessage+"' for empty Gift card pin is not the same as the expected one:'"+lblEmptyGiftCardPinErrorMessage+"'");
		}

		reporter.reportLog("Verify valid gift card with invalid pin scenario");
		String validGiftCardNumber=lstGiftCard.get(0).get("GiftCardNumber");
		getRegularCheckoutThreadLocal().applyGiftCardForNegativeScenario(validGiftCardNumber, invalidGiftCardPin,initialGiftCardNumberLength);
		lsErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryGiftCardErrorMessage);
		if(lsErrorMessage.equalsIgnoreCase(invalidErrorMessage)){
			reporter.reportLogPass("The error message for valid Gift card number and invalid pin is the same as the expected one");
		}
		else{
			reporter.reportLogFail("The error message:'"+lsErrorMessage+"' for valid Gift card number and invalid pin is not the same as the expected one:'"+invalidErrorMessage+"'");
		}

		reporter.reportLog("Verify invalid gift card scenario");
		getRegularCheckoutThreadLocal().applyGiftCardForNegativeScenario(inValidGiftCardNumber, invalidGiftCardPin,initialGiftCardNumberLength);
		lsErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryGiftCardErrorMessage);
		if(lsErrorMessage.equalsIgnoreCase(invalidErrorMessage)){
			reporter.reportLogPass("The error message for invalid Gift card number is the same as the expected one");
		}
		else{
			reporter.reportLogFail("The error message:'"+lsErrorMessage+"' for invalid Gift card number is not the same as the expected one:'"+invalidErrorMessage+"'");
		}

		reporter.reportLog("Verify valid gift card and pin scenario");
		String lsText;
		Map<String,Object> orderSummaryMapOnCheckoutPage=null;
		boolean bSuccess=getRegularCheckoutThreadLocal().applyGiftCardForPositiveScenario(lstGiftCard,initialGiftCardNumberLength);
		if(bSuccess){
			String lblOrderSummaryGiftCardAppliedMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryGiftCardAppliedMessage);
			if(lblOrderSummaryGiftCardAppliedMessage.toLowerCase().contains(lblGiftCardAppliedMessage.toLowerCase())){
				reporter.reportLogPass("The applied message for valid gift card and pin is tha same as the expected one");
			}
			else{
				reporter.reportLogFail("The applied message:'"+lblOrderSummaryGiftCardAppliedMessage+"' for valid gift card and pin is not tha same as the expected one:'"+lblGiftCardAppliedMessage+"'");
			}

			lsText=basePage.getElementInnerText(getRegularCheckoutThreadLocal().btnOrderSummaryRemoveGiftCard);
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The remove button for applied gift card is displaying correctly");
			}
			else{
				reporter.reportLogFail("The remove button for applied gift card code is not displaying correctly");
			}

			reporter.reportLog("Verify OrderSummary Business Logic");
			orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
			getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList, orderSummaryMapOnCheckoutPage, null);
		}
		else{
			reporter.reportLogFail("Failed to apply valid gift card number, please check the data in yaml file");
		}

		reporter.reportLog("Verify OrderSummary on ShoppingCart page");
		getRegularCheckoutThreadLocal().GoToShoppingBag();
		int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
		float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
		float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();
		Map<String,Object> orderSummaryMapOnShoppingCartPage=getShoppingCartThreadLocal().getOrderSummaryDesc();

		reporter.reportLog("Verify OrderSummary Business Logic");
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,orderSummaryMapOnShoppingCartPage,null);

		reporter.reportLog("Verify OrderSummary Linkage Between ShoppingCart Page And Checkout Page");
		getRegularCheckoutThreadLocal().verifyOrderSummaryLinkageBetweenShoppingCartPageAndCheckoutPage(orderSummaryMapOnShoppingCartPage,orderSummaryMapOnCheckoutPage);


	}
}

