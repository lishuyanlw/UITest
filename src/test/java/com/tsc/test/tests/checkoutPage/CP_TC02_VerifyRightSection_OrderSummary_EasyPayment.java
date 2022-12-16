package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC02_VerifyRightSection_OrderSummary_EasyPayment extends BaseTest{
	/*
	 * CER-869
	 */
	@Test(groups={"Regression","Checkout","CheckoutMobTab"})
	public void CP_TC02_VerifyRightSection_OrderSummary_EasyPayment() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);
		if(data.size()==0){
			keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
			data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);
		}

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
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
		getShoppingCartThreadLocal().goToCheckoutPage();

		reporter.reportLog("Verify OrderSummary Contents");
		getRegularCheckoutThreadLocal().verifyOrderSummaryContents();

		reporter.reportLog("Verify EasyPayment Contents");
		getRegularCheckoutThreadLocal().verifyEasyPayContents();

		reporter.reportLog("Verify promote code Contents");
		getRegularCheckoutThreadLocal().verifyPromoteCodeContents();

		reporter.reportLog("Verify Gift Card And Place Order Contents");
		getRegularCheckoutThreadLocal().verifyGiftCardAndPlaceOrderContents();
	}
}
