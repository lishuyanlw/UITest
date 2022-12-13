package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC10_VerifyShoppingCart_FavoriteIcon_MultiPackDiscount extends BaseTest{
	/*
	 * CER-853
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC10_VerifyShoppingCart_FavoriteIcon_MultiPackDiscount() throws IOException {
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
			List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_ShoppingCartSearchKeyword();

			//Login using valid username and password
			getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
			BasePage basePage=new BasePage(this.getDriver());

			Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
			outputDataCriteria.put("style", "1");
			outputDataCriteria.put("size", "1");
			outputDataCriteria.put("quantity", "2");
			if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
				String lsStyle=getProductDetailPageThreadLocal().selectedProduct.productEDPColor;
				String lsSize=getProductDetailPageThreadLocal().selectedProduct.productEDPSize;
				getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lsStyle, lsSize, 1);

				getProductDetailPageThreadLocal().highLightedFavoriteIcon();

				basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
				basePage.waitForCondition(Driver -> {
					return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
				}, 30000);
				getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

				reporter.reportLog("Verify favorite icon action");
				reporter.reportLog("Verify if favorite icon in shopping cart is highlighted as expected after highlighted on PDP");
				int firstNotFreeShippingItemIndex=getShoppingCartThreadLocal().getFirstNotFreeShippingCartItemInShoppingList();
				WebElement item=getShoppingCartThreadLocal().lstCartItems.get(firstNotFreeShippingItemIndex);
				boolean bHighLightedFavIconOnShoppingCart=getShoppingCartThreadLocal().checkIfProductFavIconHighLighted(item);
				if(bHighLightedFavIconOnShoppingCart){
					reporter.reportLogPass("The favorite icon in shopping cart is highlighted as expected");
				}
				else{
					reporter.reportLogFail("The favorite icon in shopping cart is not highlighted");
				}

				reporter.reportLog("Verify if favorite icon in shopping cart is not highlighted as expected after clicking highlighted favorite icon");
				getShoppingCartThreadLocal().unHighLightedFavoriteIcon();
				bHighLightedFavIconOnShoppingCart=getShoppingCartThreadLocal().checkIfProductFavIconHighLighted(item);
				if(!bHighLightedFavIconOnShoppingCart){
					reporter.reportLogPass("The favorite icon in shopping cart is not highlighted as expected");
				}
				else{
					reporter.reportLogFail("The favorite icon in shopping cart is highlighted");
				}

				reporter.reportLog("Verify if favorite icon in shopping cart is highlighted as expected after clicking not highlighted favorite icon again");
				getShoppingCartThreadLocal().highLightedFavoriteIcon();
				bHighLightedFavIconOnShoppingCart=getShoppingCartThreadLocal().checkIfProductFavIconHighLighted(item);
				if(bHighLightedFavIconOnShoppingCart){
					reporter.reportLogPass("The favorite icon in shopping cart is highlighted as expected");
				}
				else{
					reporter.reportLogFail("The favorite icon in shopping cart is not highlighted");
				}

				reporter.reportLog("Verify Multipack shipping discount");
				reporter.reportLog("Verify only 1 shopping cart item in shopping cart list");
				boolean bMultiPack=getShoppingCartThreadLocal().checkMultiPackShippingDiscountExistingInOrderSummary();
				if(!bMultiPack){
					reporter.reportLogPass("Unable to find Multipack shipping discount item in orderSummary");
				}
				else{
					reporter.reportLogFail("Found Multipack shipping discount item in orderSummary wrongly");
				}

				reporter.reportLog("Verify increasing 1 more shopping cart item in shopping cart list");
				int notFreeShippingItemIndex=getShoppingCartThreadLocal().getFirstNotFreeShippingCartItemInShoppingList();
				getShoppingCartThreadLocal().changeShoppingItemQuantityByGivenIndex(notFreeShippingItemIndex);
				bMultiPack=getShoppingCartThreadLocal().checkMultiPackShippingDiscountExistingInOrderSummary();
				if(bMultiPack){
					reporter.reportLogPass("Able to find Multipack shipping discount item in orderSummary");
				}
				else{
					reporter.reportLogFail("Unable to find Multipack shipping discount item in orderSummary");
				}

				reporter.reportLog("Verify OrderSummary Contents");
				getShoppingCartThreadLocal().verifyOrderSummaryContents();
				reporter.reportLog("Verify OrderSummary Business Logic");
				Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
				float subTotal=getShoppingCartThreadLocal().getSubTotalFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
				Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
				getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,null);
			}
		}finally {
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}
