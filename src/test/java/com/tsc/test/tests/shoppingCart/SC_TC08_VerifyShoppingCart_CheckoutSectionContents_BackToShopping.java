package com.tsc.test.tests.shoppingCart;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC08_VerifyShoppingCart_CheckoutSectionContents_BackToShopping extends BaseTest{
	/*
	 * CER-857
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC08_VerifyShoppingCart_CheckoutSectionContents_BackToShopping() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);

		getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);
		(new CartAPI()).deletePromoCodeAppliedOnCart(String.valueOf(customerEDP),accessToken);

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

		getShoppingCartThreadLocal().verifyCheckoutSectionContents();

		BasePage basePage=new BasePage(this.getDriver());
		String currentURL=basePage.URL();
		basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getShoppingCartThreadLocal().lnkBackToShopping);
		getShoppingCartThreadLocal().lnkBackToShopping.click();
		basePage.waitForCondition(Driver->{return !currentURL.equalsIgnoreCase(basePage.URL());},15000);
		String expectedURL=System.getProperty("QaUrl");
		String actualURL=basePage.URL();
		if(actualURL.equalsIgnoreCase(expectedURL))
			reporter.reportLogPass("The page has been navigated to home page after clicking BackToShopping link");
		else
			reporter.reportLogFail("The page has not been navigated to home page i.e.: "+expectedURL+" after clicking BackToShopping link and navigated to: "+actualURL);
	}
}

