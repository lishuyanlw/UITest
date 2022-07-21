package com.tsc.test.tests.shoppingCart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.tsc.api.apiBuilder.ProductAPI;
import com.tsc.api.pojo.CartResponse;
import com.tsc.api.util.JsonParser;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC02_VerifyShoppingCart_RemoveItem_CheckSubTotalAndOrderSummary extends BaseTest{
	/*
	 * CER-840
	 */
	@Test(groups={"Regression","Regression_Mobile","Regression_Tablet","SauceTunnelTest"})
	public void SC_TC02_VerifyShoppingCart_RemoveItem_CheckSubTotalAndOrderSummary() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String,Object>> data = new ProductAPI().getProductDetailsToBeAddedToCartForUser(keyword);
		Response response = getShoppingCartThreadLocal().addItemsToCartForUser(data,customerEDP,accessToken,null);
		CartResponse cartResponse = JsonParser.getResponseObject(response.asString(), new TypeReference<CartResponse>() {});
		Map<String,Map<String,Object>> cartMap = getProductDetailPageThreadLocal().getShoppingBagItemsDetailAddedForUser(cartResponse);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPColor);
			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSize(getProductDetailPageThreadLocal().selectedProduct.productEDPColor,getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

			getProductDetailPageThreadLocal().openAddToBagPopupWindow();
			getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

			Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			int itemAmountInShoppingCartHeaderInitial=getShoppingCartThreadLocal().GetAddedItemAmount();
			int shoppingItemListAmountInitial=getShoppingCartThreadLocal().getItemAmountInShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
			int shoppingAmountInSubtotalInitial=(int)shoppingCartMap.get("shoppingAmount");
			int itemAmountInOrderSummaryInitial=getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
			float subTotalShoppingCartInitial=getShoppingCartThreadLocal().getShoppingSubTotal();
			float subTotalOrderSummaryInitial=getShoppingCartThreadLocal().getOrderSummarySubTotal();
			if(itemAmountInShoppingCartHeaderInitial==shoppingItemListAmountInitial&&
					shoppingItemListAmountInitial==shoppingAmountInSubtotalInitial&&
					itemAmountInShoppingCartHeaderInitial==itemAmountInOrderSummaryInitial){
				reporter.reportLogPass("The initial added item amount among Shopping cart header,Shopping cart list and OrderSummary are same");
			}
			else{
				reporter.reportLogFail("The initial added item amount Shopping cart header,Shopping cart list and OrderSummary are not same");
			}

			Map<String, WebElement> mapButtons=getShoppingCartThreadLocal().getFirstCartItemWithAvailableRemoveButton();
			WebElement cartItem=mapButtons.get("cartItem");
			WebElement removeButton=mapButtons.get("removeButton");

			Map<String,Object> mapCartItem=getShoppingCartThreadLocal().getShoppingItemDesc(cartItem,"mandatory");

			getShoppingCartThreadLocal().openRemoveDialog(removeButton);

			reporter.reportLog("Verify remove dialog contents");
			getShoppingCartThreadLocal().verifyRemoveDialogContents();
			Map<String,Object> mapRemoveDialog=getShoppingCartThreadLocal().getRemoveDialogDesc();

			reporter.reportLog("Compare the contents between cart item and remove dialog");
			getShoppingCartThreadLocal().verifyContentsBetweenCartItemAndRemoveDialog(mapCartItem,mapRemoveDialog);

			reporter.reportLog("Verify clicking cancel button action in remove dialog");
			getShoppingCartThreadLocal().closeRemoveDialogWithoutRemoveAction(true);
			shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
			if(findIndex!=-1){
				reporter.reportLogPass("Able to find the removed item");
			}
			else{
				reporter.reportLogFail("Unable to find the removed item");
			}

			int itemAmountInShoppingCartHeaderCancel=getShoppingCartThreadLocal().GetAddedItemAmount();
			int shoppingItemListAmountCancel=getShoppingCartThreadLocal().getItemAmountInShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
			int shoppingAmountInSubtotalCancel=(int)shoppingCartMap.get("shoppingAmount");
			int itemAmountInOrderSummaryCancel=getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
			float subTotalShoppingCartCancel=getShoppingCartThreadLocal().getShoppingSubTotal();
			float subTotalOrderSummaryCancel=getShoppingCartThreadLocal().getOrderSummarySubTotal();
			if(itemAmountInShoppingCartHeaderCancel==shoppingItemListAmountCancel&&
					shoppingItemListAmountCancel==shoppingAmountInSubtotalCancel&&
					itemAmountInShoppingCartHeaderCancel==itemAmountInOrderSummaryCancel){
				reporter.reportLogPass("The added item amount among Shopping cart header,Shopping cart list and OrderSummary are same after clicking cancel button in remove dialog");
			}
			else{
				reporter.reportLogFail("The added item amount among Shopping cart header,Shopping cart list and OrderSummary are not same after clicking cancel button in remove dialog");
			}
			if(itemAmountInShoppingCartHeaderCancel==shoppingItemListAmountInitial&&
					shoppingItemListAmountCancel==shoppingAmountInSubtotalInitial&&
					itemAmountInShoppingCartHeaderCancel==itemAmountInOrderSummaryInitial){
				reporter.reportLogPass("The added item amount among Shopping cart header,Shopping cart list and OrderSummary after clicking cancel button in remove dialog are same as the initial ones");
			}
			else{
				reporter.reportLogFail("The added item amount among Shopping cart header,Shopping cart list and OrderSummary after clicking cancel button in remove dialog are not same as the initial ones");
			}
			if(Math.abs(subTotalShoppingCartInitial-subTotalShoppingCartCancel)<0.1&&
					Math.abs(subTotalOrderSummaryInitial-subTotalOrderSummaryCancel)<0.1){
				reporter.reportLogPass("No changes for the subtotal in both shopping cart and orderSummary");
			}
			else{
				reporter.reportLogFail("There are changes for the subtotal in both shopping cart and orderSummary");
			}

			getShoppingCartThreadLocal().openRemoveDialog(removeButton);
			mapRemoveDialog=getShoppingCartThreadLocal().getRemoveDialogDesc();

			reporter.reportLog("Verify clicking remove button action in remove dialog");
			getShoppingCartThreadLocal().closeRemoveDialogWithRemoveAction();
			shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
			if(findIndex==-1){
				reporter.reportLogPass("Unable to find the removed item");
			}
			else{
				reporter.reportLogFail("Still able to find the removed item");
			}

			int itemAmountInShoppingCartHeaderRemove=getShoppingCartThreadLocal().GetAddedItemAmount();
			int shoppingItemListAmountRemove=getShoppingCartThreadLocal().getItemAmountInShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
			int shoppingAmountInSubtotalRemove=(int)shoppingCartMap.get("shoppingAmount");
			int itemAmountInOrderSummaryRemove=getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
			float subTotalShoppingCartRemove=getShoppingCartThreadLocal().getShoppingSubTotal();
			float subTotalOrderSummaryRemove=getShoppingCartThreadLocal().getOrderSummarySubTotal();
			float nowPrice= (float) mapRemoveDialog.get("productNowPrice");
			if(itemAmountInShoppingCartHeaderRemove==shoppingItemListAmountRemove&&
					shoppingItemListAmountRemove==shoppingAmountInSubtotalRemove&&
					itemAmountInShoppingCartHeaderRemove==itemAmountInOrderSummaryRemove){
				reporter.reportLogPass("The added item amount among Shopping cart header,Shopping cart list and OrderSummary are same after clicking remove button in remove dialog");
			}
			else{
				reporter.reportLogFail("The added item amount among Shopping cart header,Shopping cart list and OrderSummary are not same after clicking remove button in remove dialog");
			}
			if((itemAmountInShoppingCartHeaderInitial-1)==shoppingItemListAmountRemove&&
					(shoppingItemListAmountInitial-1)==shoppingAmountInSubtotalRemove&&
					(itemAmountInShoppingCartHeaderInitial-1)==itemAmountInOrderSummaryRemove){
				reporter.reportLogPass("The added item amount among Shopping cart header,Shopping cart list and OrderSummary after clicking remove button in remove dialog are same as the initial ones");
			}
			else{
				reporter.reportLogPass("The added item amount among Shopping cart header,Shopping cart list and OrderSummary after clicking remove button in remove dialog are not same as the initial ones");
			}
			if(Math.abs(subTotalShoppingCartInitial-subTotalShoppingCartRemove-nowPrice)<0.1&&
					Math.abs(subTotalOrderSummaryInitial-subTotalOrderSummaryRemove-nowPrice)<0.1){
				reporter.reportLogPass("The difference between shopping cart subtotal and orderSummary is correct");
			}
			else{
				reporter.reportLogFail("The difference between shopping cart subtotal and orderSummary is not correct");
			}

			reporter.reportLog("Verify OrderSummary section content");
			int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
			float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
			float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();
			Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
			getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,mapOrderSummary,null);
			getShoppingCartThreadLocal().verifyOrderSummaryContents();

			reporter.reportLog("Verify EasyPayment section content");
			getShoppingCartThreadLocal().setInstallmentSetting(1);
			getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);
			getShoppingCartThreadLocal().verifyEasyPaymentContents();


		}
		else {
			reporter.reportLogFail("Unable to find the matched product item");
		}
	}
}

