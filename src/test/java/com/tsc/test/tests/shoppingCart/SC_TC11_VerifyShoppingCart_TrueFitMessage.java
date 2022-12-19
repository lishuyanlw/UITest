package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC11_VerifyShoppingCart_TrueFitMessage extends BaseTest{
	/*
	 * CER-861
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC11_VerifyShoppingCart_TrueFitMessage() throws IOException {

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		try{
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
			(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);

			getGlobalFooterPageThreadLocal().closePopupDialog();
			//Fetching test data from test data file
			List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
			List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);
			//List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
			List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();

			//Login using valid username and password
			getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
			BasePage basePage=new BasePage(this.getDriver());

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
				basePage.applyStaticWait(2000);

				getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSize0[1], 1);
				basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
				basePage.waitForCondition(Driver -> {
					return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
				}, 30000);
				basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
				basePage.applyStaticWait(2000);

				getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

				Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
				boolean bCheckDuplicatedStyleAndSize = getShoppingCartThreadLocal().checkProductWithSameStyleAndDifferentSizesInShoppingItemList(shoppingCartMap);
				if (bCheckDuplicatedStyleAndSize) {
					reporter.reportLogPass("Able to find the product with same style and different sizes in shopping cart list");
				} else {
					reporter.reportLogFail("Unable to find the product with same style and different sizes in shopping cart list");
				}
			}
		}finally {
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

