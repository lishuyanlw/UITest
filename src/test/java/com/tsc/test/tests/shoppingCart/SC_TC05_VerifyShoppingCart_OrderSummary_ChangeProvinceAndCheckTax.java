package com.tsc.test.tests.shoppingCart;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC05_VerifyShoppingCart_OrderSummary_ChangeProvinceAndCheckTax extends BaseTest{
	/*
	 * CER-850
	 */
	@Test(groups={"Regression","Regression_Mobile","Regression_Tablet","SauceTunnelTest"})
	public void SC_TC05_VerifyShoppingCart_OrderSummary_ChangeProvinceAndCheckTax() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,true);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		(new BasePage(this.getDriver())).applyStaticWait(2000);
		getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

		int itemAmount=getShoppingCartThreadLocal().GetAddedItemAmount();
		float savingPrice=getShoppingCartThreadLocal().getSavingPriceFromShoppingCartHeader();
		float subTotal=getShoppingCartThreadLocal().getShoppingSubTotal();

		Map<String,Object> mapOrderSummary;
		Map<String,Object> mapTaxRate=getShoppingCartThreadLocal().getProvinceTaxRateMap();
		List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
		getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
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

