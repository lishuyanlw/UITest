package com.tsc.test.tests.shoppingCart;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC10_VerifyShoppingCart_ShippingDateAndMultiPackMessage extends BaseTest{
	/*
	 * CER-853
	 */
	@Test(groups={"Regression","ShoppingCart","SauceTunnelTest"})
	public void SC_TC10_VerifyShoppingCart_ShippingDateAndMultiPackMessage() throws IOException {
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
		BasePage basePage=new BasePage(this.getDriver());

		String lsAdvancedOrderKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AdvancedOrderkeyword();
		if(getProductResultsPageThreadLocal().getSearchResultLoad(lsAdvancedOrderKeyword,true)) {
			String lsEstimatedShippingDate=basePage.getElementInnerText(getProductDetailPageThreadLocal().lblAdvanceOrderMsg);
			lsEstimatedShippingDate=lsEstimatedShippingDate.split(":")[1].trim();
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver->{return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();},30000);
			getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

			reporter.reportLog("Verify shipping message in shopping cart header");
			boolean bCheckGetItByShippingMessage=getShoppingCartThreadLocal().checkGetItByShippingMessageExisting();
			if(!bCheckGetItByShippingMessage){
				reporter.reportLogPass("The GetItByShippingMessage is not displaying in the shopping cart header");
			}
			else{
				reporter.reportLogFail("The GetItByShippingMessage is still displaying in the shopping cart header");
			}

			reporter.reportLog("Verify Estimated shipping message for first shopping item");
			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("optional");
			List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
			String lsFirstShoppingDate= (String) shoppingList.get(0).get("productShippingDate");
			if(lsFirstShoppingDate.contains("Est. Ship Date")){
				reporter.reportLogPass("The first shopping item is containing 'Est. Ship Date'");
			}
			else{
				reporter.reportLogFail("The first shopping item is not containing 'Est. Ship Date'");
			}

			reporter.reportLog("Verify the Estimated shipping message linkage between PDP and Shopping cart page");
			String lsShippingDateInfo,shippingDate;
			for(Map<String,Object> shoppingItem:shoppingList){
				lsShippingDateInfo= (String) shoppingItem.get("productShippingDate");
				shippingDate=lsShippingDateInfo.split(":")[1].split(",")[1].trim();
				if(lsShippingDateInfo.contains("Est. Ship Date")&&shippingDate.equalsIgnoreCase(lsEstimatedShippingDate)){
					reporter.reportLogPass("Able to find estimated shipping date correctly");
					break;
				}
				else{
					reporter.reportLogPass("Unable to find estimated shipping date");
				}
			}

			reporter.reportLog("Verify the MultiPack message in shopping cart header");
			String lsCartNoticeMessage=getShoppingCartThreadLocal().checkCartNoticeMessageExisting();
			if(!lsCartNoticeMessage.equalsIgnoreCase("errorMessage")){
				reporter.reportLogPass("The MultiPack message is displaying correctly");
			}
			else{
				reporter.reportLogFail("The MultiPack message is not displaying correctly");
			}
		}

		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

	}
}

