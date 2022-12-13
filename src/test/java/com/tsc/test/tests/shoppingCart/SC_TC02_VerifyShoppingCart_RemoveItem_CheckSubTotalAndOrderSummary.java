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

		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);

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

		reporter.reportLog("To verify Linkage Between Shopping Cart List And OrderSummary at initial stage");
		Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
		getShoppingCartThreadLocal().verifyLinkageBetweenShoppingCartListAndOrderSummary(shoppingCartMap);

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

		reporter.reportLog("To verify Linkage Between Shopping Cart List And OrderSummary after clicking cancel button on remove dialog");
		getShoppingCartThreadLocal().verifyLinkageBetweenShoppingCartListAndOrderSummary(shoppingCartMap);

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

		reporter.reportLog("To verify Linkage Between Shopping Cart List And OrderSummary after clicking remove button on remove dialog");
		getShoppingCartThreadLocal().verifyLinkageBetweenShoppingCartListAndOrderSummary(shoppingCartMap);

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

