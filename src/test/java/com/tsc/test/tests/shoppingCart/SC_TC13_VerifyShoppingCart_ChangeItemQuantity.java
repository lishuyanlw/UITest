package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
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
		getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
		(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);

		//Delete all gift card
		CartAPI cartAPI=new CartAPI();
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		try{
			getGlobalFooterPageThreadLocal().closePopupDialog();
			//Fetching test data from test data file
			List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
			List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",true,0);
			if(data.size()==0){
				keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
				data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",false,0);
			}
			List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

			//Login using valid username and password
			getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
			BasePage basePage=new BasePage(this.getDriver());

			Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
			outputDataCriteria.put("style", "1");
			outputDataCriteria.put("size", "1");
			outputDataCriteria.put("quantity", "4");
			if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
				String lsStyle=getProductDetailPageThreadLocal().selectedProduct.productEDPColor;
				String lsSize=getProductDetailPageThreadLocal().selectedProduct.productEDPSize;
				getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lsStyle, lsSize, 1);
				Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

				basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
				basePage.waitForCondition(Driver -> {
					return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
				}, 30000);
				getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();
				getShoppingCartThreadLocal().setInstallmentNumberByRandomIndex();

				Map<String, Object> shoppingCartMapBeforeChange = getShoppingCartThreadLocal().getShoppingSectionDetails("all");
				Map<String,Object> mapOrderSummaryBeforeChange=getShoppingCartThreadLocal().getOrderSummaryDesc();
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
				int itemCountShoppingListAfterChange= (int) shoppingCartMapAfterChange.get("shoppingAmount");
				float itemSubTotalShoppingListAfterChange= (float) shoppingCartMapAfterChange.get("shoppingSubTotal");
				int itemCountOrderSummaryAfterChange= (int) mapOrderSummaryAfterChange.get("itemAmount");
				float itemSubTotalOrderSummaryAfterChange= (float) mapOrderSummaryAfterChange.get("subTotal");

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

				reporter.reportLog("Verify product quantity control actions");
				int maximumProductQuantity=getShoppingCartThreadLocal().getMaximumQuantityByGivenShoppingCartItemIndex(findIndex);
				reporter.reportLog("Set the product quantity to the maximal number:"+maximumProductQuantity);
				getShoppingCartThreadLocal().chooseShoppingItemByGivenItemIndexAndQuantity(findIndex,maximumProductQuantity);
				WebElement item=getShoppingCartThreadLocal().lstCartItems.get(findIndex);
				if(!getShoppingCartThreadLocal().checkProductQuantityPlusButtonEnabled(item)){
					reporter.reportLogPass("The Plus quantity button has been disabled when reaching the maximal product quantity");
				}
				else{
					reporter.reportLogFail("The Plus quantity button has not been disabled when reaching the maximal product quantity");
				}

				reporter.reportLog("Set the product quantity to the minimal number:1");
				getShoppingCartThreadLocal().chooseShoppingItemByGivenItemIndexAndQuantity(findIndex,1);
				item=getShoppingCartThreadLocal().lstCartItems.get(findIndex);
				if(!getShoppingCartThreadLocal().checkProductQuantityMinusButtonEnabled(item)){
					reporter.reportLogPass("The Minus quantity button has been disabled when reaching the minimal product quantity");
				}
				else{
					reporter.reportLogFail("The Minus quantity button has not been disabled when reaching the minimal product quantity");
				}

			}
		}finally {
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

