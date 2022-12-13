package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC14_VerifyShoppingCart_CheckJaysCareDonation extends BaseTest{
	/*
	 * CER-870 - Shopping Cart - Verify blue jays donation addition
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC14_VerifyShoppingCart_CheckJaysCareDonation() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);

		List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",false,0);
		if(data.size()==0){
			keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
			data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",false,0);
		}

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

		reporter.reportLog("Before Adding Jays Care Donation Item scenario");
		int itemCountInOrderSummaryBeforeAddingDonationItem=getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
		reporter.reportLog("Verify Jays Care Donation Contents");
		getShoppingCartThreadLocal().verifyJaysCareDonationContents();
		reporter.reportLog("Verify OrderSummary Contents");
		getShoppingCartThreadLocal().verifyOrderSummaryContents();
		reporter.reportLog("Verify OrderSummary Business Logic");
		Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");
		float subTotal=getShoppingCartThreadLocal().getSubTotalFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
		Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,null);

		reporter.reportLog("Adding Jays Care Donation Item into orderSummary scenario");
		float presetDonationValue=getShoppingCartThreadLocal().setRandomJaysCareDonationItem();
		reporter.reportLog("Verify Jays Care Donation value in Cart");
		getShoppingCartThreadLocal().verifyBlueJayDonationAdditionInCart(presetDonationValue);

		int selectedDonationItemIndex=getShoppingCartThreadLocal().getSelectedJaysCareDonationItemIndex();
		if(selectedDonationItemIndex!=-1){
			reporter.reportLogPass("Found selected Jays Care Donation button after adding it into orderSummary");
		}
		else{
			reporter.reportLogFail("Unable to find selected Jays Care Donation button after adding it into orderSummary");
		}

		reporter.reportLog("Verify Jays Care Donation Contents");
		getShoppingCartThreadLocal().verifyJaysCareDonationContents();
		reporter.reportLog("Verify OrderSummary Contents");
		getShoppingCartThreadLocal().verifyOrderSummaryContents();
		reporter.reportLog("Verify OrderSummary Business Logic");
		mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,null);
		int itemCountInOrderSummaryAfterAddingDonationItem=getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
		if(itemCountInOrderSummaryAfterAddingDonationItem==(itemCountInOrderSummaryBeforeAddingDonationItem+1)){
			reporter.reportLogPass("The shopping cart item count after adding donation item is equal to the one before adding donation item plus 1");
		}
		else{
			reporter.reportLogFail("The shopping cart item count:"+itemCountInOrderSummaryAfterAddingDonationItem+" after adding donation is equal to the one:"+itemCountInOrderSummaryBeforeAddingDonationItem+" before adding donation item plus 1");
		}

		reporter.reportLog("Removing Jays Care Donation Item from orderSummary scenario");
		getShoppingCartThreadLocal().removeJaysCareDonationItemFromOrderSummary();

		selectedDonationItemIndex=getShoppingCartThreadLocal().getSelectedJaysCareDonationItemIndex();
		if(selectedDonationItemIndex==-1){
			reporter.reportLogPass("Unable to find selected Jays Care Donation button after removed from orderSummary");
		}
		else{
			reporter.reportLogFail("Found selected Jays Care Donation button after removed from orderSummary wrongly");
		}

		reporter.reportLog("Verify OrderSummary Contents");
		getShoppingCartThreadLocal().verifyOrderSummaryContents();
		reporter.reportLog("Verify OrderSummary Business Logic");
		mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
		getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,null);
		int itemCountInOrderSummaryAfterRemovingDonationItem=getShoppingCartThreadLocal().getShoppingItemAmountFromOrderSummarySection();
		if(itemCountInOrderSummaryAfterRemovingDonationItem==itemCountInOrderSummaryBeforeAddingDonationItem){
			reporter.reportLogPass("The shopping cart item count after removing donation item is equal to the one before adding donation item");
		}
		else{
			reporter.reportLogFail("The shopping cart item count:"+itemCountInOrderSummaryAfterRemovingDonationItem+" after removing donation item is equal to the one:"+itemCountInOrderSummaryBeforeAddingDonationItem+" before adding donation item");
		}
	}
}
