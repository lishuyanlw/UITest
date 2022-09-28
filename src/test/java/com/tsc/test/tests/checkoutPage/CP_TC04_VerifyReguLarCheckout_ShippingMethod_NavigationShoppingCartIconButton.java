package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC04_VerifyReguLarCheckout_ShippingMethod_NavigationShoppingCartIconButton extends BaseTest{
	/*
	 * CER-880
	 * CER-875
	 * CER-879
	 */
	@Test(groups={"Regression","Checkout"})
	public void CP_TC04_VerifyReguLarCheckout_ShippingMethod_NavigationShoppingCartIconButton() throws IOException {
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

		getRegularCheckoutThreadLocal().navigateToCheckoutPage();
		int installmentsNumberForShoppingCart=2;
		getRegularCheckoutThreadLocal().setPaymentOptionByGivenInstallmentNumber(installmentsNumberForShoppingCart);

		reporter.reportLog("Comparison shipping price between shipping method section and OrderSummary section before changing");
		float shippingPriceInShippingMethodSection=getRegularCheckoutThreadLocal().getShippingPriceFromShippingMethodSection();
		Map<String, Object> orderSummaryMapForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		float shippingPriceInOrderSummary= (float) orderSummaryMapForCheckOutPage.get("nowPrice");
		if(Math.abs(shippingPriceInShippingMethodSection-shippingPriceInOrderSummary)<0.1){
			reporter.reportLogPass("The shipping price: "+shippingPriceInShippingMethodSection+" in shipping method section is equal to the one: "+shippingPriceInOrderSummary+" in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The shipping price: "+shippingPriceInShippingMethodSection+" in shipping method section is not equal to the one: "+shippingPriceInOrderSummary+" in OrderSummary section");
		}

		reporter.reportLog("Verify Change Shipping Method Dialog Contents");
		getRegularCheckoutThreadLocal().openChangeShippingMethodDialog();
		getRegularCheckoutThreadLocal().verifyChangeShippingMethodDialogContents();

		reporter.reportLog("Comparison shipping price between shipping method change dialog and shipping method section after changing");
		float shippingPriceChangedInDialog=getRegularCheckoutThreadLocal().changeShippingMethodInChangeShippingMethodDialog();
		getRegularCheckoutThreadLocal().closeChangeShippingMethodDialog(true);
		float shippingPriceChangedInShippingMethodSection=getRegularCheckoutThreadLocal().getShippingPriceFromShippingMethodSection();
		if(Math.abs(shippingPriceChangedInDialog-shippingPriceChangedInShippingMethodSection)<0.1){
			reporter.reportLogPass("The shipping price: "+shippingPriceChangedInDialog+" in shipping method change dialog is equal to the one: "+shippingPriceChangedInShippingMethodSection+" in shipping method section");
		}
		else{
			reporter.reportLogFail("The shipping price: "+shippingPriceChangedInDialog+" in shipping method change dialog is not equal to the one: "+shippingPriceChangedInShippingMethodSection+" in shipping method section");
		}

		reporter.reportLog("Comparison shipping price between shipping method section and OrderSummary section after changing");
		Map<String, Object> orderSummaryMapChangedForCheckOutPage = getRegularCheckoutThreadLocal().getOrderSummaryDesc();
		float shippingPriceChangedInOrderSummary= (float) orderSummaryMapChangedForCheckOutPage.get("nowPrice");
		if(Math.abs(shippingPriceChangedInShippingMethodSection-shippingPriceChangedInOrderSummary)<0.1){
			reporter.reportLogPass("The shipping price: "+shippingPriceChangedInShippingMethodSection+" in shipping method section is equal to the one: "+shippingPriceChangedInOrderSummary+" in OrderSummary section");
		}
		else{
			reporter.reportLogFail("The shipping price: "+shippingPriceChangedInShippingMethodSection+" in shipping method section is not equal to the one: "+shippingPriceChangedInOrderSummary+" in OrderSummary section");
		}

		List<Map<String,Object>> productListMapForCheckOutPage = getRegularCheckoutThreadLocal().getCheckoutItemListDesc("all");
		Map<String,Object> summaryMapForCheckOutList=getRegularCheckoutThreadLocal().getCheckoutItemCountAndSubTotal(productListMapForCheckOutPage);
		float subTotalForCheckOutList= (float) summaryMapForCheckOutList.get("subTotal");

		reporter.reportLog("Verify orderSummary business logic");
		getRegularCheckoutThreadLocal().verifyOrderSummaryBusinessLogic(subTotalForCheckOutList,orderSummaryMapChangedForCheckOutPage,null);

		reporter.reportLog("Verify installment business logic");
		getRegularCheckoutThreadLocal().verifyInstallmentBusinessLogic(installmentsNumberForShoppingCart,orderSummaryMapChangedForCheckOutPage);

		reporter.reportLog("Verify Navigation to ShoppingCart page by clicking GoToShoppingBag icon button in checkout header");
		getRegularCheckoutThreadLocal().GoToShoppingBag();
		String lsShoppingCartURLNavigatedFromCheckOutPage=basePage.URL();
		if(lsShoppingCartURLNavigatedFromCheckOutPage.toLowerCase().contains("shoppingcart")){
			reporter.reportLogPass("Navigated to ShoppingCart page by clicking GoToShoppingBag button in checkout header successfully");
		}
		else{
			reporter.reportLogFail("Failed to navigated to ShoppingCart page by clicking GoToShoppingBag button in checkout header");
		}
	}
}

