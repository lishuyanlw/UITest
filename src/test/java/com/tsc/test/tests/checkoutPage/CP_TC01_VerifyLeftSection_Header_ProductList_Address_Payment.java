package com.tsc.test.tests.checkoutPage;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC01_VerifyLeftSection_Header_ProductList_Address_Payment extends BaseTest{
	/*
	 * CER-868 - Checkout - Verify Page header, line items, different section and its data
	 */
	@Test(groups={"Regression","Checkout","CheckoutMobTab"})
	public void CP_TC01_VerifyLeftSection_Header_ProductList_Address_Payment() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);

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
		getShoppingCartThreadLocal().goToCheckoutPage();

		reporter.reportLog("Verify header Contents");
		getRegularCheckoutThreadLocal().verifyCheckoutHeaderContents();

		reporter.reportLog("Verify Mandatory Contents For Checkout ProductList");
		getRegularCheckoutThreadLocal().verifyMandatoryContentsForCheckoutProductList();

		reporter.reportLog("Verify optional Contents For Checkout ProductList");
		getRegularCheckoutThreadLocal().verifyOptionalContentsForCheckoutProductList();

		reporter.reportLog("Verify Address And Payment Contents");
		getRegularCheckoutThreadLocal().verifyAddressAndPaymentContents();
	}
}
