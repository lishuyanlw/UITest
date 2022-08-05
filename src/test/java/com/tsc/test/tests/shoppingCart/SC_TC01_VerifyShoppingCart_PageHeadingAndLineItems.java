package com.tsc.test.tests.shoppingCart;

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
		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,true);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		getShoppingCartThreadLocal().waitForCondition(Driver->{return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText())>0;},6000);
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

		Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

		//To verify heading and Shopping Item List contents
		reporter.reportLog("To verify heading and Shopping Item List contents");
		getShoppingCartThreadLocal().verifyShoppingCartContents("all");

		//To verify business logic Between Shopping Item List And SubTotal Section
		reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
		getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

		int itemAmountInShoppingCartHeader = getShoppingCartThreadLocal().GetAddedItemAmount();
		int shoppingItemListAmount = getShoppingCartThreadLocal().getItemCountFromShoppingList((List<Map<String, Object>>) shoppingCartMap.get("shoppingList"));
		int shoppingAmountInSubtotal = (int) shoppingCartMap.get("shoppingAmount");
		int itemAmountInOrderSummary = getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
		if (itemAmountInShoppingCartHeader == shoppingItemListAmount &&
				shoppingItemListAmount == shoppingAmountInSubtotal &&
				itemAmountInShoppingCartHeader == itemAmountInOrderSummary) {
			reporter.reportLogPass("The added item amount among Shopping cart header,Shopping cart list and OrderSummary are same");
		} else {
			reporter.reportLogFail("The added item amount among Shopping cart header,Shopping cart list and OrderSummary are not same");
		}

		reporter.reportLog("Verify added products using API");
		String productName;
		int findIndex;
		for (Map<String, Object> item : data) {
			productName=item.get("productName").toString();
			reporter.reportLog("Verify product name: "+productName);
			findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(item, shoppingCartMap);
			if(findIndex!=-1){
				reporter.reportLogPass("The added product"+productName+" using API can be found in ShoppingCart list");
			}
			else{
				reporter.reportLogFail("The added product"+productName+" using API cannot be found in ShoppingCart list");
			}
		}

		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
	}
}

