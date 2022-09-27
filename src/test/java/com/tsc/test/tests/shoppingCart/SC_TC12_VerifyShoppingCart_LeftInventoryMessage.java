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

public class SC_TC12_VerifyShoppingCart_LeftInventoryMessage extends BaseTest{
	/*
	 * CER-855
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC12_VerifyShoppingCart_LeftInventoryMessage() throws IOException {
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
			List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,true);
			List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

			//Login using valid username and password
			getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
			BasePage basePage=new BasePage(this.getDriver());

			Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
			outputDataCriteria.put("style", "1");
			outputDataCriteria.put("size", "1");
			outputDataCriteria.put("quantity", "-10");
			if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
				String lsStyle=getProductDetailPageThreadLocal().selectedProduct.productEDPColor;
				String lsSize=getProductDetailPageThreadLocal().selectedProduct.productEDPSize;
				getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lsStyle, lsSize, 1);
				Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();
				int leftNumberInPDP=(int) PDPMap.get("productLeftNumber");

				basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
				basePage.waitForCondition(Driver -> {
					return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
				}, 30000);
				getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

				Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");
				int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(PDPMap, shoppingCartMap);
				List<Map<String,Object>> shoppingList=(List<Map<String,Object>>)shoppingCartMap.get("shoppingList");
				Map<String,Object> findMap=shoppingList.get(findIndex);
				int leftNumberInShoppingCart=(int) findMap.get("productLeftNumber");
				if(leftNumberInPDP==leftNumberInShoppingCart){
					reporter.reportLogPass("The left number message in Shopping cart is the same as the one in PDP");
				}
				else{
					reporter.reportLogFail("The left number message in Shopping cart is not the same as the one in PDP");
				}

				reporter.reportLog("Verify Shopping cart section content");
				getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);
				getShoppingCartThreadLocal().verifyShoppingCartContents("all");

				reporter.reportLog("Verify OrderSummary section content");
				int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
				float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
				float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();

				Map<String,Object> mapTaxRate=getShoppingCartThreadLocal().getProvinceTaxRateMap();
				getShoppingCartThreadLocal().setProvinceCodeForEstimatedTax("BC");
				Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
				getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,mapOrderSummary,mapTaxRate);
				getShoppingCartThreadLocal().verifyOrderSummaryContents();

				reporter.reportLog("Verify EasyPayment section content");
				mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
				if(getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()){
					List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
					getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
				}
				getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);
				getShoppingCartThreadLocal().verifyEasyPaymentContents();

			}
		}finally {
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

