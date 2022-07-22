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

		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String,Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,true);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		(new BasePage(this.getDriver())).applyStaticWait(2000);
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

		Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
		reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
		getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

		Map<String,Object> map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,false);
		int itemCountInShoppingCartHeaderInitial= (int) map.get("itemCountInShoppingCartHeader");
		int shoppingItemCountInitial= (int) map.get("shoppingItemCount");
		int shoppingItemCountInSubtotalInitial= (int) map.get("shoppingItemCountInSubtotal");
		int itemCountInOrderSummaryInitial= (int) map.get("itemCountInOrderSummary");
		float subTotalShoppingCartInitial= (float) map.get("subTotalShoppingCart");
		float subTotalOrderSummaryInitial= (float) map.get("subTotalOrderSummary");
		if(itemCountInShoppingCartHeaderInitial==shoppingItemCountInitial&&
				shoppingItemCountInitial==shoppingItemCountInSubtotalInitial&&
				itemCountInShoppingCartHeaderInitial==itemCountInOrderSummaryInitial){
			reporter.reportLogPass("The initial added item count among Shopping cart header,Shopping cart list and OrderSummary are same");
		}
		else{
			reporter.reportLogFail("The initial added item count Shopping cart header,Shopping cart list and OrderSummary are not same");
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

		map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,false);
		int itemCountInShoppingCartHeaderCancel= (int) map.get("itemCountInShoppingCartHeader");
		int shoppingItemCountCancel= (int) map.get("shoppingItemCount");
		int shoppingItemCountInSubtotalCancel= (int) map.get("shoppingItemCountInSubtotal");
		int itemCountInOrderSummaryCancel= (int) map.get("itemCountInOrderSummary");
		float subTotalShoppingCartCancel= (float) map.get("subTotalShoppingCart");
		float subTotalOrderSummaryCancel= (float) map.get("subTotalOrderSummary");
		if(itemCountInShoppingCartHeaderCancel==shoppingItemCountCancel&&
				shoppingItemCountCancel==shoppingItemCountInSubtotalCancel&&
				itemCountInShoppingCartHeaderCancel==itemCountInOrderSummaryCancel){
			reporter.reportLogPass("The added item count among Shopping cart header,Shopping cart list and OrderSummary are same after clicking cancel button in remove dialog");
		}
		else{
			reporter.reportLogFail("The added item count among Shopping cart header,Shopping cart list and OrderSummary are not same after clicking cancel button in remove dialog");
		}
		if(itemCountInShoppingCartHeaderCancel==shoppingItemCountInitial&&
				shoppingItemCountCancel==shoppingItemCountInSubtotalInitial&&
				itemCountInShoppingCartHeaderCancel==itemCountInOrderSummaryInitial){
			reporter.reportLogPass("The added item count among Shopping cart header,Shopping cart list and OrderSummary after clicking cancel button in remove dialog are same as the initial ones");
		}
		else{
			reporter.reportLogFail("The added item count among Shopping cart header,Shopping cart list and OrderSummary after clicking cancel button in remove dialog are not same as the initial ones");
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

		map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,false);
		int itemCountInShoppingCartHeaderRemove= (int) map.get("itemCountInShoppingCartHeader");
		int shoppingItemCountRemove= (int) map.get("shoppingItemCount");
		int shoppingItemCountInSubtotalRemove= (int) map.get("shoppingItemCountInSubtotal");
		int itemCountInOrderSummaryRemove= (int) map.get("itemCountInOrderSummary");
		float subTotalShoppingCartRemove= (float) map.get("subTotalShoppingCart");
		float subTotalOrderSummaryRemove= (float) map.get("subTotalOrderSummary");
		float nowPrice= (float) mapRemoveDialog.get("productNowPrice");
		if(itemCountInShoppingCartHeaderRemove==shoppingItemCountRemove&&
				shoppingItemCountRemove==shoppingItemCountInSubtotalRemove&&
				itemCountInShoppingCartHeaderRemove==itemCountInOrderSummaryRemove){
			reporter.reportLogPass("The added item count among Shopping cart header,Shopping cart list and OrderSummary are same after clicking remove button in remove dialog");
		}
		else{
			reporter.reportLogFail("The added item count among Shopping cart header,Shopping cart list and OrderSummary are not same after clicking remove button in remove dialog");
		}
		if((itemCountInShoppingCartHeaderInitial-1)==shoppingItemCountRemove&&
				(shoppingItemCountInitial-1)==shoppingItemCountInSubtotalRemove&&
				(itemCountInShoppingCartHeaderInitial-1)==itemCountInOrderSummaryRemove){
			reporter.reportLogPass("The added item count among Shopping cart header,Shopping cart list and OrderSummary after clicking remove button in remove dialog are same as the initial ones");
		}
		else{
			reporter.reportLogPass("The added item count among Shopping cart header,Shopping cart list and OrderSummary after clicking remove button in remove dialog are not same as the initial ones");
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

		Map<String,Object> mapTaxRate=getShoppingCartThreadLocal().getProvinceTaxRateMap();
		getShoppingCartThreadLocal().setProvinceCodeForEstimatedTax("BC");
		Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,mapOrderSummary,mapTaxRate);
		getShoppingCartThreadLocal().verifyOrderSummaryContents();

		reporter.reportLog("Verify EasyPayment section content");
		mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().setInstallmentSetting(1);
		getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);
		getShoppingCartThreadLocal().verifyEasyPaymentContents();

//		//To empty the cart
//		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

	}
}

