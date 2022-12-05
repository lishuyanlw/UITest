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

public class SC_TC13_VerifyShoppingCart_ChangeItemQuantity extends BaseTest{
	/*
	 * CER-855
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC13_VerifyShoppingCart_ChangeItemQuantity() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());

		//Delete all gift card
		CartAPI cartAPI=new CartAPI();
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		try{
			getGlobalFooterPageThreadLocal().closePopupDialog();
			//Fetching test data from test data file
			List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
			List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);
			List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

			//Login using valid username and password
			getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
			BasePage basePage=new BasePage(this.getDriver());

			Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
			outputDataCriteria.put("style", "2");
			outputDataCriteria.put("size", "2");
			outputDataCriteria.put("quantity", "8");
			if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
				String lsStyle=getProductDetailPageThreadLocal().selectedProduct.productEDPColor;
				String lsSize=getProductDetailPageThreadLocal().selectedProduct.productEDPSize;
				getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lsStyle, lsSize, 1);
				Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

				basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
				basePage.waitForCondition(Driver -> {
					return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
				}, 30000);
				getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

				if(getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()){
					List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
					getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
				}

				Map<String, Object> shoppingCartMapBeforeChange = getShoppingCartThreadLocal().getShoppingSectionDetails("all");
				Map<String,Object> mapOrderSummaryBeforeChange=getShoppingCartThreadLocal().getOrderSummaryDesc();
				int itemCountInShoppingCartHeaderBeforeChange = getShoppingCartThreadLocal().GetAddedItemAmount();
				int itemCountShoppingListBeforeChange= (int) shoppingCartMapBeforeChange.get("shoppingAmount");
				float itemSubTotalShoppingListBeforeChange= (float) shoppingCartMapBeforeChange.get("shoppingSubTotal");
				int itemCountOrderSummaryBeforeChange= (int) mapOrderSummaryBeforeChange.get("itemAmount");
				float itemSubTotalOrderSummaryBeforeChange= (float) mapOrderSummaryBeforeChange.get("subTotal");

				int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMap, shoppingCartMapBeforeChange);
				Map<String,Object> mapDifference=getShoppingCartThreadLocal().changeShoppingItemQuantityByGivenIndex(findIndex);
				int itemQuantityDifference= (int) mapDifference.get("itemQuantityDifference");
				float itemTotalDifference= (float) mapDifference.get("itemTotalDifference");

				Map<String, Object> shoppingCartMapAfterChange = getShoppingCartThreadLocal().getShoppingSectionDetails("all");
				Map<String,Object> mapOrderSummaryAfterChange=getShoppingCartThreadLocal().getOrderSummaryDesc();
				int itemCountInShoppingCartHeaderAfterChange = getShoppingCartThreadLocal().GetAddedItemAmount();
				int itemCountShoppingListAfterChange= (int) shoppingCartMapAfterChange.get("shoppingAmount");
				float itemSubTotalShoppingListAfterChange= (float) shoppingCartMapAfterChange.get("shoppingSubTotal");
				int itemCountOrderSummaryAfterChange= (int) mapOrderSummaryAfterChange.get("itemAmount");
				float itemSubTotalOrderSummaryAfterChange= (float) mapOrderSummaryAfterChange.get("subTotal");

				if((itemCountInShoppingCartHeaderAfterChange-itemCountInShoppingCartHeaderBeforeChange)==itemQuantityDifference){
					reporter.reportLogPass("The item count for shopping cart header is changing correctly ");
				}
				else{
					reporter.reportLogFail("The item count for shopping cart header is not changing correctly ");
				}

				if((itemCountShoppingListAfterChange-itemCountShoppingListBeforeChange)==itemQuantityDifference){
					reporter.reportLogPass("The item count for shopping cart list is changing correctly ");
				}
				else{
					reporter.reportLogFail("The item count for shopping cart list is not changing correctly ");
				}

				if((itemCountOrderSummaryAfterChange-itemCountOrderSummaryBeforeChange)==itemQuantityDifference){
					reporter.reportLogPass("The item count for OrderSummary is changing correctly ");
				}
				else{
					reporter.reportLogFail("The item count for OrderSummary is not changing correctly ");
				}

				if(Math.abs(Math.abs(itemSubTotalShoppingListAfterChange-itemSubTotalShoppingListBeforeChange)-Math.abs(itemTotalDifference))<0.1){
					reporter.reportLogPass("The subtotal for shopping cart list is changing correctly ");
				}
				else{
					reporter.reportLogFail("The subtotal for shopping cart list is not changing correctly ");
				}

				if(Math.abs(Math.abs(itemSubTotalOrderSummaryAfterChange-itemSubTotalOrderSummaryBeforeChange)-Math.abs(itemTotalDifference))<0.1){
					reporter.reportLogPass("The subtotal for OrderSummary is changing correctly ");
				}
				else{
					reporter.reportLogFail("The subtotal for OrderSummary is not changing correctly ");
				}

				reporter.reportLog("Verify EasyPayment business logic");
				getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummaryAfterChange);

			}
		}finally {
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

