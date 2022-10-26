package com.tsc.test.tests.guestCheckoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GCP_TC04_Verify_CreditCardType_Paypal extends BaseTest{
	/*
	 *
	 */
	@Test(groups={"Regression","GuestCheckout"})
	public void GCP_TC04_Verify_CreditCardType_Paypal() throws IOException {
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
			/**
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
			basePage.applyStaticWait(basePage.getStaticWaitForApplication());

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[1], lstSizeSecondItem[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);
			*/
			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut);
			getProductDetailPageThreadLocal().btnAddToBagPopupWindowButtonSectionCheckOut.click();
			basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().btnCreateAccountOrContinueAsGuest.isDisplayed();},120000);

			getGlobalLoginPageThreadLocal().goToGuestCheckoutPage();

			Map<String,Object> createdUserMap=getGuestCheckoutThreadLocal().createNewAccount(null,null,false);

			reporter.reportLog("Add invalid promo code for user to verify error message");
			List<String> lstInvalidPromoteCodeAndErrorMessage=TestDataHandler.constantData.getCheckOut().getLstInvalidPromoteCodeAndErrorMessage();
			String lblPromoCodeExpectedErrorMessage=lstInvalidPromoteCodeAndErrorMessage.get(1).replace("<promoteCode>","\""+lstInvalidPromoteCodeAndErrorMessage.get(0)+"\"");
			getRegularCheckoutThreadLocal().applyPromoteCodeForNegativeScenario(lstInvalidPromoteCodeAndErrorMessage.get(0));
            String lblPromoCodeErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryPromoteCodeErrorMessage);
            if(lblPromoCodeErrorMessage.equalsIgnoreCase(lblPromoCodeExpectedErrorMessage))
            	reporter.reportLogPass("Error Message for invalid promo code is as expected: "+lblPromoCodeErrorMessage);
            else
            	reporter.reportLogFailWithScreenshot("Error Message for invalid promo code: "+lblPromoCodeErrorMessage+" is not as expected: "+lblPromoCodeExpectedErrorMessage);
			reporter.reportLog("Add promo code on create user page");
			String lblPromoteCodeAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblPromoteCodeAppliedMessage();
			List<String> lstPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode();
			String lsAppliedPromoteCode=getRegularCheckoutThreadLocal().applyPromoteCodeForPositiveScenario(lstPromoteCode);
			String lblOrderSummaryPromoteCodeAppliedMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryPromoteCodeAppliedMessage);
			if(lblOrderSummaryPromoteCodeAppliedMessage.equalsIgnoreCase(lblPromoteCodeAppliedMessage)){
				reporter.reportLogPass("The applied message for valid promote code is tha same as the expected one");
			}
			else{
				reporter.reportLogFail("The applied message:'"+lblOrderSummaryPromoteCodeAppliedMessage+"' for invalid promote code is not tha same as the expected one:'"+lblPromoteCodeAppliedMessage+"'");
			}

			getGuestCheckoutThreadLocal().goToPaymentPage();

			reporter.reportLog("Verify promo code info on payment page");
			String lblOrderSummaryPromoteCodeAppliedCode=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryInputPromoteCode);
			if(lblOrderSummaryPromoteCodeAppliedCode.toLowerCase().equalsIgnoreCase(lsAppliedPromoteCode)){
				reporter.reportLogPass("The applied promote codes for valid promote code is the same as the expected promote code: "+lsAppliedPromoteCode);
			}
			else{
				reporter.reportLogFail("The applied message:'"+lblOrderSummaryPromoteCodeAppliedCode+"' for invalid promote code is not the same as the expected promote code: "+lsAppliedPromoteCode);
			}

			String lsText=basePage.getElementInnerText(getRegularCheckoutThreadLocal().btnOrderSummaryRemovePromoteCode);
			if(!lsText.isEmpty()){
				reporter.reportLogPass("The remove button for promo Code is displaying as expected.");
			}
			else{
				reporter.reportLogFail("The remove button for promo Code is not displaying as expected.");
			}

			reporter.reportLog("Add gift card on payment page");
			String lblGiftCardAppliedMessage=TestDataHandler.constantData.getCheckOut().getLblGiftCardAppliedMessage();
			List<Map<String,String>> lstGiftCard=TestDataHandler.constantData.getCheckOut().getLst_GiftCard();
			int initialGiftCardNumberLength=getRegularCheckoutThreadLocal().inputOrderSummaryGiftCardNumber.getAttribute("value").replace(" ","").length();
			boolean bAddingGiftCardSuccess=getRegularCheckoutThreadLocal().applyGiftCardForPositiveScenario(lstGiftCard,initialGiftCardNumberLength);
			if(bAddingGiftCardSuccess){
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
			}
			else{
				reporter.reportLogFail("Failed to apply valid gift card number, please check the data in yaml file");
			}

			reporter.reportLog("Verify OrderSummary Business Logic");
			List<Map<String, Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("mandatory");
			Map<String, Object> summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
			float subTotalForCheckOutList = (float) summaryMapForCheckOutList.get("subTotal");
			Map<String,Object> orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
			getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList, orderSummaryMapOnCheckoutPage, null);

			reporter.reportLog("Verify adding payment method");
			String lsBrowserType=System.getProperty("Browser");
			boolean bCheck=lsBrowserType.toLowerCase().contains("ios");
			Map<String,Object> mapAddedPayment;
			if(!bCheck){
				mapAddedPayment=getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("master");
				basePage.applyStaticWait(basePage.getStaticWaitForApplication());
				getGuestCheckoutThreadLocal().verifyInputCreditCardType(mapAddedPayment.get("cardType").toString());
				mapAddedPayment=getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("amex");
				basePage.applyStaticWait(basePage.getStaticWaitForApplication());
				getGuestCheckoutThreadLocal().verifyInputCreditCardType(mapAddedPayment.get("cardType").toString());
				mapAddedPayment=getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("visa");
				getGuestCheckoutThreadLocal().verifyInputCreditCardType(mapAddedPayment.get("cardType").toString());
			}

			reporter.reportLog("Verify PayPal Functionality");
			getGuestCheckoutThreadLocal().verifyPayPalFunctionality();

			//Adding credit card will fail due to ios blocking iframe issue on sauceLab, so instead to add tsc card
			//Remove gift card to avoid easy payment conflict
			if(bAddingGiftCardSuccess){
				getRegularCheckoutThreadLocal().removeGiftCard();
			}
			mapAddedPayment=getGuestCheckoutThreadLocal().addNewCreditOrEditExistingCard("tsc");
			//Fetching Order Summary after removing gift card
			orderSummaryMapOnCheckoutPage=getRegularCheckoutThreadLocal().getOrderSummaryDesc();

			getGuestCheckoutThreadLocal().goToReviewPage();

			//Fetching details from checkout page to be verified on Order Confirmation page
			productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
			summaryMapForCheckOutList = getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
			int itemCountForCheckOutList = (int) summaryMapForCheckOutList.get("itemCount");
			Map<String,Object> mapForShippingAddressAndPaymentOnCheckout=getRegularCheckoutThreadLocal().getShippingAndPaymentDesc(productListMapForCheckOutPage.get(0));
			Map<String,Object> easyPaymentMapOnCheckoutPage=getRegularCheckoutThreadLocal().getEasyPayDesc();

			reporter.reportLog("Verify Created Shipping Address Linkage with Checkout page");
			getGuestCheckoutThreadLocal().verifyCreatedShippingAddressLinkageWithCheckoutPage(createdUserMap);

			reporter.reportLog("Verify Created payment Linkage with Checkout page");
			getGuestCheckoutThreadLocal().verifyPaymentLinkageWithCheckoutPage(mapAddedPayment,mapForShippingAddressAndPaymentOnCheckout);

			getRegularCheckoutThreadLocal().goToOrderConfirmationPage();
			reporter.reportLog("Verification of guest checkout data on Order Confirmation page");
			getOrderConfirmationThreadLocal().verifyOrderConfirmationPageContents(productListMapForCheckOutPage,orderSummaryMapOnCheckoutPage,easyPaymentMapOnCheckoutPage,mapForShippingAddressAndPaymentOnCheckout,getShoppingCartThreadLocal(),lsAppliedPromoteCode,itemCountForCheckOutList,subTotalForCheckOutList);

		}
	}
}
