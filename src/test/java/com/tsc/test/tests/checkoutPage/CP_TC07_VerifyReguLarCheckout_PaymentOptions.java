package com.tsc.test.tests.checkoutPage;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC07_VerifyReguLarCheckout_PaymentOptions extends BaseTest{
	/*
	 * CER-886
	 * CER-887
	 */
	@Test(groups={"Regression","Checkout","CheckoutMobTab"})
	public void CP_TC07_VerifyReguLarCheckout_PaymentOptions() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		//To add Product With Multiple Shipping Methods
		String lsKeyword=TestDataHandler.constantData.getCheckOut().getLblProductNumberWithMultipleShippingMethods();
		getShoppingCartThreadLocal().addSingleProductWithConditions(lsKeyword, 1,1, String.valueOf(customerEDP), accessToken,false);

		//Delete all gift cards
		CartAPI cartAPI=new CartAPI();
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		getGlobalFooterPageThreadLocal().closePopupDialog();

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

		getShoppingCartThreadLocal().setInstallmentNumberByRandomIndex();
		int installmentsNumberForShoppingCart = getShoppingCartThreadLocal().getInstallmentNumber();
		Map<String,Object> easyPaymentMapInShoppingCart=getShoppingCartThreadLocal().getEasyPayDesc();
		float installmentAmountInShoppingCart= (float) easyPaymentMapInShoppingCart.get("futureMonthlyPayment");

		getRegularCheckoutThreadLocal().navigateToCheckoutPage();
		int initialGiftCardNumberLength=getRegularCheckoutThreadLocal().inputOrderSummaryGiftCardNumber.getAttribute("value").length();

		reporter.reportLog("Verify the linkage between default payment options in checkout page and shopping cart page");
		int installmentNumberInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentNumberFromPaymentOptionText();
		float installmentAmountInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentAmountFromPaymentOptionText();
		if(installmentNumberInPaymentOption==installmentsNumberForShoppingCart){
			reporter.reportLogPass("The installment number In PaymentOption for checkout page is equal to the one for Shopping cart page");
		}
		else{
			reporter.reportLogFail("The installment number:"+installmentNumberInPaymentOption+" In PaymentOption for checkout page is equal to the one:"+installmentsNumberForShoppingCart+" for Shopping cart page");
		}

		if(Math.abs(installmentAmountInPaymentOption-installmentAmountInShoppingCart)<0.1f){
			reporter.reportLogPass("The installment Amount In PaymentOption for checkout page is equal to the future payment in easyPayment for Shopping cart page");
		}
		else{
			reporter.reportLogFail("The installment Amount:"+installmentAmountInPaymentOption+" In PaymentOption for checkout page is equal to the future payment:"+installmentAmountInShoppingCart+" in easyPayment for Shopping cart page");
		}

		reporter.reportLog("Verify the linkage between full payment option and orderSummary");
		Map<String,Object> orderSummaryMap=getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		getRegularCheckoutThreadLocal().setPaymentOptionByGivenIndex(0);
		installmentAmountInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentAmountFromPaymentOptionText();
		float subTotalInOrderSummary= (float) orderSummaryMap.get("subTotal");
		if(Math.abs(installmentAmountInPaymentOption-subTotalInOrderSummary)<0.1f){
			reporter.reportLogPass("The installment Amount In PaymentOption is equal to the subtotal In orderSummary");
		}
		else{
			reporter.reportLogFail("The installment Amount:"+installmentAmountInPaymentOption+" In PaymentOption is equal to the subtotal:"+subTotalInOrderSummary+" In orderSummary");
		}

		reporter.reportLog("Verify the linkage between payment options for not full payment and easyPayment");
		getRegularCheckoutThreadLocal().setPaymentOptionByRandomIndex();
		installmentNumberInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentNumberFromPaymentOptionText();
		installmentAmountInPaymentOption=getRegularCheckoutThreadLocal().getInstallmentAmountFromPaymentOptionText();
		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentNumberInPaymentOption,orderSummaryMap);

		Map<String,Object> easyPaymentMap=getRegularCheckoutThreadLocal().getEasyPayDesc();
		float installmentAmountInEasyPayment= (float) easyPaymentMap.get("futureMonthlyPayment");
		if(Math.abs(installmentAmountInPaymentOption-installmentAmountInEasyPayment)<0.1f){
			reporter.reportLogPass("The installment Amount In PaymentOption is equal to the future payment In EasyPayment");
		}
		else{
			reporter.reportLogFail("The installment Amount:"+installmentAmountInPaymentOption+" In PaymentOption is equal to the future payment:"+installmentAmountInEasyPayment+" In EasyPayment");
		}

		reporter.reportLog("Very the negative test scenario of applying gift card on not full payment options");
		List<Map<String,String>> giftCardList=TestDataHandler.constantData.getCheckOut().getLst_GiftCard();
		String giftCardNumber=giftCardList.get(0).get("GiftCardNumber");
		String giftCardPin=giftCardList.get(0).get("GiftCardPin");
		String lsErrorMessageInYamlFile=TestDataHandler.constantData.getCheckOut().getLblGiftCardPromoteErrorMessageForEasyPayment();
		getRegularCheckoutThreadLocal().applyGiftCard(giftCardNumber, giftCardPin,initialGiftCardNumberLength,false);
		String lsActualErrorMessage=basePage.getElementInnerText(getRegularCheckoutThreadLocal().lblOrderSummaryGiftCardErrorMessage);
		if(lsActualErrorMessage.contains(lsErrorMessageInYamlFile)){
			reporter.reportLogPass("The actual error message is the same as the one in Yaml file");
		}
		else{
			reporter.reportLogFail("The actual error message:'"+lsActualErrorMessage+"' is the same as the one:'"+lsErrorMessageInYamlFile+"' in Yaml file");
		}

	}
}

