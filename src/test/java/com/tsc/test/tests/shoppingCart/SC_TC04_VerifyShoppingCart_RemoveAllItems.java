package com.tsc.test.tests.shoppingCart;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC04_VerifyShoppingCart_RemoveAllItems extends BaseTest{
	/*
	 * CER-856
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC04_VerifyShoppingCart_RemoveAllItems() throws IOException {
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

		getShoppingCartThreadLocal().removeAllItemsFromShoppingCartList();

		if(getShoppingCartThreadLocal().lblCartParaMessageForEmptyCart.size()==2){
			reporter.reportLogPass("The empty cart message is displaying correctly");
		}
		else{
			reporter.reportLogFail("The empty cart message is not displaying correctly");
		}

		if(getShoppingCartThreadLocal().checkIfOrderSummaryAndEasyPaymentNotExisting()){
			reporter.reportLogPass("OrderSummary And EasyPayment is Not Existing");
		}
		else{
			reporter.reportLogFail("OrderSummary And EasyPayment is still Existing");
		}

		reporter.reportLog("Verify checkout section contents");
		getShoppingCartThreadLocal().verifyCheckOutContents();
	}
}

