package com.tsc.test.tests.shoppingCart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC01_VerifyShoppingCart_PageHeadingAndLineItems extends BaseTest{
	/*
	 * CER-840
	 */
	@Test(groups={"Regression","Regression_Mobile","Regression_Tablet","SauceTunnelTest"})
	public void SC_TC01_VerifyShoppingCart_PageHeadingAndLineItems() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage = new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,true);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber, lsUrl;
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

		Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

		//To verify heading and Shopping Item List contents
		reporter.reportLog("To verify heading and Shopping Item List contents");
		getShoppingCartThreadLocal().verifyShoppingCartContents(true, false, false);

		//To verify business logic Between Shopping Item List And SubTotal Section
		reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
		getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

		int itemAmountInShoppingCartHeader = getShoppingCartThreadLocal().GetAddedItemAmount();
		int shoppingItemListAmount = getShoppingCartThreadLocal().getItemAmountInShoppingList((List<Map<String, Object>>) shoppingCartMap.get("shoppingList"));
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
	}
}

