package com.tsc.test.tests.shoppingCart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.AccountAPI;
import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.api.pojo.AccountCartResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC03_VerifyShoppingCart_MergingCart extends BaseTest{
	/*
	 * CER-848
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC03_VerifyShoppingCart_MergingCart() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage = new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList = TestDataHandler.constantData.getSearchResultPage().getLst_ShoppingCartSearchKeyword();
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

		Map<String, Object> outputDataCriteria = new HashMap<String, Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		if (getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList, "AllConditionsWithoutCheckingSoldOutCriteria", outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber = getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl = basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"), "The Url is containing productdetails", "The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber), "The Url is containing selected product number of " + lsProductNumber, "The Url is not containing selected product number of " + lsProductNumber);

			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPColor);
			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSize(getProductDetailPageThreadLocal().selectedProduct.productEDPColor, getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			Map<String, Object> PDPMap = getProductDetailPageThreadLocal().getPDPDesc();

			getProductDetailPageThreadLocal().openAddToBagPopupWindow();
			getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

			int findIndex = getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMap, shoppingCartMap);
			if (findIndex == 0) {
				reporter.reportLogPass("The latest added item is displaying on the top of shopping item list correctly");
			} else {
				reporter.reportLogFail("The latest added item is not displaying on the top of shopping item list correctly");
			}

			//To verify heading and Shopping Item List contents
			reporter.reportLog("To verify heading and Shopping Item List contents");
			getShoppingCartThreadLocal().verifyShoppingCartContents("all");

			//To verify business logic Between Shopping Item List And SubTotal Section
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			Map<String,Object> map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,true);
			int itemCountInShoppingCartHeader= (int) map.get("itemCountInShoppingCartHeader");
			int shoppingItemCount= (int) map.get("shoppingItemCount");
			int shoppingItemCountInSubtotal= (int) map.get("shoppingItemCountInSubtotal");
			int itemCountInOrderSummary= (int) map.get("itemCountInOrderSummary");
			if (itemCountInShoppingCartHeader == shoppingItemCount &&
					shoppingItemCount == shoppingItemCountInSubtotal &&
					itemCountInShoppingCartHeader == itemCountInOrderSummary) {
				reporter.reportLogPass("The added item count among Shopping cart header,Shopping cart list and OrderSummary are same");
			} else {
				reporter.reportLogFail("The added item count among Shopping cart header,Shopping cart list and OrderSummary are not same");
			}

			reporter.reportLog("Verify added products using API");
			String productName;
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


			reporter.reportLog("Verify checkout section contents");
			getShoppingCartThreadLocal().verifyCheckOutContents(false);

			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
		else {
			reporter.reportLogFail("Unable to find the matched product item");
		}
	}
}

