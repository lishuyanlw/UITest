package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC06_VerifyShoppingCart_ChangeChangeInstallmentNumber_And_OrderSummary extends BaseTest{
	/*
	 * CER-851
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC06_VerifyShoppingCart_ChangeChangeInstallmentNumber_And_OrderSummary() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		List<Map<String,String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
		List<Map<String,Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP,accessToken,keyword,"all",true,0);

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

		reporter.reportLog("Verify EasyPayment sections contents");
		Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();

		List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
		int loopSize=lstOptionText.size();
		for(int i=1;i<loopSize;i++){
			getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(i));
			int easyPayNumber = Integer.valueOf(lstOptionText.get(i));
			getShoppingCartThreadLocal().waitForCondition(Driver->{return
					getShoppingCartThreadLocal().getFutureMonthlyPaymentNumber()==easyPayNumber-1;},20000);
			reporter.reportLog("Verify installment number "+ lstOptionText.get(i));
			getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);
			getShoppingCartThreadLocal().verifyEasyPaymentContents();
		}
	}
}

