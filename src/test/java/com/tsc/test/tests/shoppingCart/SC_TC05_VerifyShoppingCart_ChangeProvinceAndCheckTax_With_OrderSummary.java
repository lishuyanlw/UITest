package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC05_VerifyShoppingCart_ChangeProvinceAndCheckTax_With_OrderSummary extends BaseTest{
	/*
	 * CER-850
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC05_VerifyShoppingCart_ChangeProvinceAndCheckTax_With_OrderSummary() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
		List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,"all",true,0);
		if(data.size()==0){
			keyword = TestDataHandler.constantData.getCheckOut().getLst_SearchKeywords();
			data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,"all",false,0);
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
		if (getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()) {
			List<String> lstOptionText = getShoppingCartThreadLocal().getInstallmentOptions();
			getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
		}

		int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
		float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
		float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();

		Map<String,Object> mapOrderSummary;
		Map<String,Object> mapTaxRate=getShoppingCartThreadLocal().getProvinceTaxRateMap();
		if(getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()){
			List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
			getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
		}

		for(Map.Entry<String,Object> entry:mapTaxRate.entrySet()){
			reporter.reportLog("Verify province: "+entry.getKey());
			getShoppingCartThreadLocal().setProvinceCodeForEstimatedTax(entry.getKey());
			mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
			getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(itemAmount,savingPrice,subTotal,mapOrderSummary,mapTaxRate);

			reporter.reportLog("Verify EasyPayment section content related to "+entry.getKey());
			getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);
		}
	}
}

