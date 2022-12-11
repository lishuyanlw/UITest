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
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC10_VerifyShoppingCart_ShippingDateAndMultiPackMessage() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		try{
			getGlobalFooterPageThreadLocal().closePopupDialog();
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

			List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
			List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);

			//Add advanced order product using API
			String lsAdvancedOrderKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_AdvancedOrderkeyword();
			Map<String,Object> mapAdvancedOrder=getShoppingCartThreadLocal().addSingleProductWithConditions(lsAdvancedOrderKeyword, 1,1, String.valueOf(customerEDP), accessToken,true);
			data.add(mapAdvancedOrder);
			String lsEstimatedShippingDate= (String) mapAdvancedOrder.get("advanceOrderMessage");
			lsEstimatedShippingDate=lsEstimatedShippingDate.split(":")[1].trim();

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
			getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

			reporter.reportLog("Verify Estimated shipping message for first shopping item");
			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("optional");
			List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
			String lsFirstShoppingDate= (String) shoppingList.get(0).get("productShippingDateTitle");
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
				shippingDate=lsShippingDateInfo.split(",")[1].trim();
				if(lsShippingDateInfo.contains("Est. Ship Date")&&shippingDate.equalsIgnoreCase(lsEstimatedShippingDate)){
					reporter.reportLogPass("Able to find estimated shipping date correctly");
					break;
				}
				else{
					reporter.reportLogPass("Unable to find estimated shipping date");
				}
			}

		}finally {
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

