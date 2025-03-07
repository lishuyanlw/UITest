package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC01_VerifyShoppingCart_PageHeadingAndLineItems extends BaseTest{
	/*
	 * CER-844
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC01_VerifyShoppingCart_PageHeadingAndLineItems() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);
		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",false,0);
		if(data.size()==0){
			keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
			data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",false,0);
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

		Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

		//To verify heading and Shopping Item List contents
		reporter.reportLog("To verify heading and Shopping Item List contents");
		getShoppingCartThreadLocal().verifyShoppingCartContents();

		reporter.reportLog("To verify Linkage Between Shopping Cart List And OrderSummary");
		getShoppingCartThreadLocal().verifyLinkageBetweenShoppingCartListAndOrderSummary(shoppingCartMap);

		reporter.reportLog("Verify added products using API");
		String productName;
		int findIndex;
		for (Map<String, Object> item : data) {
			productName=item.get("productName").toString();
			findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(item, shoppingCartMap);
			if(findIndex!=-1){
				reporter.reportLogPass("The added product "+productName+" using API can be found in ShoppingCart list");
			}
			else{
				reporter.reportLogFail("The added product "+productName+" using API cannot be found in ShoppingCart list");
			}
		}
	}
}

