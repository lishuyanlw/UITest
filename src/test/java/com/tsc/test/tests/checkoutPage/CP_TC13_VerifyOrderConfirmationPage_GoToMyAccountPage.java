package com.tsc.test.tests.checkoutPage;

import com.tsc.api.apiBuilder.CartAPI;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CP_TC13_VerifyOrderConfirmationPage_GoToMyAccountPage extends BaseTest{
	/*
	 * CER-891
	 */
	@Test(groups={"Regression","Checkout"})
	public void CP_TC13_VerifyOrderConfirmationPage_GoToMyAccountPage() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		//To empty the cart
		getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

		//Verifying that item exists in cart and if not, create a new cart for user
		List<Map<String, String>> keyword = TestDataHandler.constantData.getCheckOut().getLstOrderDetailItems();
		getShoppingCartThreadLocal().verifyCartExistsForUser(Integer.valueOf(customerEDP), accessToken, keyword,true);

		//Delete all gift cards
		CartAPI cartAPI=new CartAPI();
		cartAPI.deleteAllGiftCardForUser(String.valueOf(customerEDP),accessToken);

		getGlobalFooterPageThreadLocal().closePopupDialog();

		List<String> lstPromoteCode=TestDataHandler.constantData.getCheckOut().getLst_PromoteCode();

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);
		BasePage basePage=new BasePage(this.getDriver());
		try {
			getShoppingCartThreadLocal().waitForCondition(Driver -> {
				return Integer.valueOf(getglobalheaderPageThreadLocal().CartBagCounter.getText()) > 0;
			}, 6000);
		}
		catch(Exception e){
			(new BasePage(this.getDriver())).applyStaticWait(3000);
		}

		getRegularCheckoutThreadLocal().navigateToCheckoutPage();

		if(!getRegularCheckoutThreadLocal().checkPaymentMethodErrorMessageExisting()){
			if(getRegularCheckoutThreadLocal().checkIfPaymentMethodIsTSC()){
				getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
				getRegularCheckoutThreadLocal().addOrChangePaymentMethod("visa");
			}
		}
		else{
			getRegularCheckoutThreadLocal().openAddOrChangePaymentMethodDialog();
			getRegularCheckoutThreadLocal().addNewCreditOrEditExistingCard("visa",true,false);
			getRegularCheckoutThreadLocal().closeUsingANewCardDialog(true);
		}
		boolean bTSC=getRegularCheckoutThreadLocal().checkIfPaymentMethodIsTSC();
		if(!bTSC){
			reporter.reportLogPass("The payment method is not TSC card");
		}
		else{
			reporter.reportLogFail("The payment method is TSC card");
		}

		getRegularCheckoutThreadLocal().ApplyPromoteCodeForPositiveScenario(lstPromoteCode);

		getRegularCheckoutThreadLocal().goToOrderConfirmationPage();

		String lsURLFromYamlFile=TestDataHandler.constantData.getMyAccount().getLnk_myAccountURL();
		getOrderConfirmationThreadLocal().goToMyAccountPage(lsURLFromYamlFile);

		getMyAccountPageThreadLocal().verifyAccountSummaryPanelList();
	}
}

