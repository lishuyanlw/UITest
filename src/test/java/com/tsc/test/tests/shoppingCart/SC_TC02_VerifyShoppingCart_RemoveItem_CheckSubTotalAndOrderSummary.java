package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC02_VerifyShoppingCart_RemoveItem_CheckSubTotalAndOrderSummary extends BaseTest{
	/*
	 * CER-849
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC02_VerifyShoppingCart_RemoveItem_CheckSubTotalAndOrderSummary() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String,Object>> addedItemMapList=getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,"all",false,0);
		if(addedItemMapList.size()==0){
			keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
			addedItemMapList=getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,"all",false,0);
			if(addedItemMapList.size()<=1){
				keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
				addedItemMapList=getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,"all",false,0);
			}
		}

		//Delete all gift card
		CartAPI cartAPI=new CartAPI();
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		try {
			getShoppingCartThreadLocal().waitForCondition(Driver -> {
				return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
			}, 6000);
		}
		catch(Exception e){
			(new BasePage(this.getDriver())).applyStaticWait(3000);
		}
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();
		getShoppingCartThreadLocal().setInstallmentNumberByRandomIndex();

		Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
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
		shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");

		int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
		if(findIndex!=-1){
			reporter.reportLogPass("Able to find the removed item");
		}
		else{
			reporter.reportLogFail("Unable to find the removed item");
		}

		map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,false);
		int shoppingItemCountCancel= (int) map.get("shoppingItemCount");
		int itemCountInOrderSummaryCancel= (int) map.get("itemCountInOrderSummary");
		int shoppingItemCountOnCheckoutButtonCancel= (int) map.get("itemCountOnCheckoutButton");
		float subTotalShoppingCartCancel= (float) map.get("subTotalShoppingCart");
		float subTotalOrderSummaryCancel= (float) map.get("subTotalOrderSummary");

		if((itemCountInOrderSummaryCancel-shoppingItemCountCancel)==donationCount){
			reporter.reportLogPass("The initial added item count in Shopping cart list plus donation count is equal to then one in OrderSummary after clicking Cancel button");
		}
		else{
			reporter.reportLogFail("The initial added item count in Shopping cart list plus donation count is not equal to then one in OrderSummary after clicking Cancel button");
		}

		if(itemCountInOrderSummaryCancel==shoppingItemCountOnCheckoutButtonCancel){
			reporter.reportLogPass("The initial added item count in Shopping cart list plus donation count is equal to then one in OrderSummary after clicking Cancel button");
		}
		else{
			reporter.reportLogFail("The initial added item count in Shopping cart list plus donation count is not equal to then one in OrderSummary after clicking Cancel button");
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
		shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");

		findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
		if(findIndex==-1){
			reporter.reportLogPass("Unable to find the removed item");
		}
		else{
			reporter.reportLogFail("Still able to find the removed item");
		}

		map=getShoppingCartThreadLocal().getItemCountAndPriceInfo(shoppingCartMap,false);
		int shoppingItemCountRemove= (int) map.get("shoppingItemCount");
		int itemCountInOrderSummaryRemove= (int) map.get("itemCountInOrderSummary");
		int shoppingItemCountOnCheckoutButtonRemove= (int) map.get("itemCountOnCheckoutButton");
		float subTotalShoppingCartRemove= (float) map.get("subTotalShoppingCart");
		float subTotalOrderSummaryRemove= (float) map.get("subTotalOrderSummary");
		float nowPrice= (float) mapRemoveDialog.get("productNowPrice");
		int quantity= (int) mapRemoveDialog.get("productQuantity");
		float removeCount=nowPrice*quantity;

		if((itemCountInOrderSummaryRemove-shoppingItemCountRemove)==donationCount){
			reporter.reportLogPass("The added item count in Shopping cart list plus donation count is equal to then one in OrderSummary after clicking Remove button");
		}
		else{
			reporter.reportLogFail("The added item count in Shopping cart list plus donation count is not equal to then one in OrderSummary after clicking Remove button");
		}

		if(itemCountInOrderSummaryRemove==shoppingItemCountOnCheckoutButtonRemove){
			reporter.reportLogPass("The added item count in Shopping cart list plus donation count is equal to then one in OrderSummary after clicking Remove button");
		}
		else{
			reporter.reportLogFail("The added item count in Shopping cart list plus donation count is not equal to then one in OrderSummary after clicking Remove button");
		}

		if(Math.abs(subTotalShoppingCartInitial-subTotalShoppingCartRemove-removeCount)<0.1&&
				Math.abs(subTotalOrderSummaryInitial-subTotalOrderSummaryRemove-removeCount)<0.1){
			reporter.reportLogPass("The difference between shopping cart subtotal and orderSummary is correct");
		}
		else{
			reporter.reportLogFail("The difference between shopping cart subtotal and orderSummary is not correct");
		}

		reporter.reportLog("Verify OrderSummary section content");
		float subTotal=getShoppingCartThreadLocal().getOrderSummarySubTotal();

		Map<String,Object> mapTaxRate=getShoppingCartThreadLocal().getProvinceTaxRateMap();
		getShoppingCartThreadLocal().setProvinceCodeForEstimatedTax("BC");
		Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,mapTaxRate);
		getShoppingCartThreadLocal().verifyOrderSummaryContents();

		reporter.reportLog("Verify EasyPayment section content");
		mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);
		getShoppingCartThreadLocal().verifyEasyPaymentContents();
	}
}

