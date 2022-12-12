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

		getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

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

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[1], lstSize1[0], 1);
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

			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");
			List<Map<String,Object>> shoppingCartItemList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");

			int findIndex = getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMapFirst, shoppingCartMap);
			if (findIndex != -1) {
				reporter.reportLogPass("The first added item can be found in shopping item list correctly");
			} else {
				reporter.reportLogFail("The first added item can not be found in shopping item list correctly");
			}

			findIndex = getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMapSecond, shoppingCartMap);
			if (findIndex != -1) {
				reporter.reportLogPass("The second added item can be found in shopping item list correctly");
			} else {
				reporter.reportLogFail("The second added item can not be found in shopping item list correctly");
			}
			boolean bMatch;
			if((boolean)shoppingCartItemList.get(0).get("productQuantityDisabled")){
				if(findIndex==1){
					bMatch=true;
				}
				else{
					bMatch=false;
				}
			}
			else{
				if(findIndex==0){
					bMatch=true;
				}
				else{
					bMatch=false;
				}
			}
			if(bMatch){
				reporter.reportLogPass("The newly added item is on the top of shoppingCart item list");
			}
			else{
				reporter.reportLogFail("The newly added item is not on the top of shoppingCart item list");
			}

			//To verify heading and Shopping Item List contents
			reporter.reportLog("To verify heading and Shopping Item List contents");
			getShoppingCartThreadLocal().verifyShoppingCartContents();

			Map<String,Object> map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,false);
			int shoppingItemCountInitial= (int) map.get("shoppingItemCount");
			int itemCountInOrderSummaryInitial= (int) map.get("itemCountInOrderSummary");
			int shoppingItemCountOnCheckoutButton= (int) map.get("itemCountOnCheckoutButton");
			float subTotalShoppingCartInitial= (float) map.get("subTotalShoppingCart");
			float subTotalOrderSummaryInitial= (float) map.get("subTotalOrderSummary");

			float donationValue=0.0f;
			int donationCount=0;
			if(getShoppingCartThreadLocal().checkJaysCareDonationExistingInOrderSummary()){
				donationValue=getShoppingCartThreadLocal().getJaysCareDonationValueInOrderSummary();
				donationCount=1;
			}
			if((itemCountInOrderSummaryInitial-shoppingItemCountInitial)==donationCount){
				reporter.reportLogPass("The initial added item count in Shopping cart list plus donation count is equal to then one in OrderSummary");
			}
			else{
				reporter.reportLogFail("The initial added item count in Shopping cart list plus donation count is not equal to then one in OrderSummary");
			}

			if(itemCountInOrderSummaryInitial==shoppingItemCountOnCheckoutButton){
				reporter.reportLogPass("The initial added item count in Shopping cart list plus donation count is equal to then one in OrderSummary");
			}
			else{
				reporter.reportLogFail("The initial added item count in Shopping cart list plus donation count is not equal to then one in OrderSummary");
			}

			if(Math.abs(Math.abs(subTotalOrderSummaryInitial-subTotalShoppingCartInitial)-donationValue)<0.1f){
				reporter.reportLogPass("The subTotal in orderSummary minus donation value is equal to the one in shopping cart list");
			}
			else{
				reporter.reportLogFail("The subTotal in orderSummary minus donation value is not equal to the one in shopping cart list");
			}

			reporter.reportLog("Verify checkout section contents");
			getShoppingCartThreadLocal().verifyCheckOutContents();
		}
		else {
			reporter.reportLogFail("Unable to find the matched product item");
		}
	}
}

