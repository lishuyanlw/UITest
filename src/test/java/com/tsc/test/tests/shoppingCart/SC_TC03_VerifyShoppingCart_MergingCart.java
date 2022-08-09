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

		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		BasePage basePage = new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL() + "/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
			String[] lstStyle = getProductDetailPageThreadLocal().getStyleList();
			String[] lstSize0 = getProductDetailPageThreadLocal().getSizeListForGivenStyle(0);
			String[] lstSize1 = getProductDetailPageThreadLocal().getSizeListForGivenStyle(1);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSize0[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
			basePage.applyStaticWait(basePage.getStaticWaitForApplication());
			Map<String, Object> PDPMapFirst = getProductDetailPageThreadLocal().getPDPDesc();

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSize0[1], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
			basePage.applyStaticWait(basePage.getStaticWaitForApplication());
			Map<String, Object> PDPMapSecond = getProductDetailPageThreadLocal().getPDPDesc();

			//Login using valid username and password
			getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
			getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();
			if(getShoppingCartThreadLocal().checkContainPreviouslyAddedItemsMessageExisting()){
				reporter.reportLogPass("The Cart containing previously added items message is displaying correctly");
			}
			else{
				reporter.reportLogPassWithScreenshot("The Cart containing previously added items message is not displaying correctly");
			}

			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

			int findIndex = getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMapFirst, shoppingCartMap);
			if (findIndex != -1) {
				reporter.reportLogPass("The first added item can be found in shopping item list correctly");
			} else {
				reporter.reportLogFail("The first added item can be found in shopping item list correctly");
			}

			findIndex = getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMapSecond, shoppingCartMap);
			if (findIndex != -1) {
				reporter.reportLogPass("The second added item can be found in shopping item list correctly");
			} else {
				reporter.reportLogFail("The second added item iscan be found in shopping item list correctly");
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

