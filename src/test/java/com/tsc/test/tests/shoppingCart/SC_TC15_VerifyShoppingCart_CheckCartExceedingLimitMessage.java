package com.tsc.test.tests.shoppingCart;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SC_TC15_VerifyShoppingCart_CheckCartExceedingLimitMessage extends BaseTest{
	/*
	 * CER-859
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC15_VerifyShoppingCart_CheckCartExceedingLimitMessage() throws IOException {
		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());

		try{
			getGlobalFooterPageThreadLocal().closePopupDialog();
			//Fetching test data from test data file
			String lsExpectedCartExceedingLimitMessage=TestDataHandler.constantData.getShoppingCart().getLblCartExceedingLimitMessage();
			//To empty the cart
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);

			//To Add 10 product EDP No with 10 quantity
			List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
			getShoppingCartThreadLocal().addMultiProductEDPNo(lstKeywordList.get(2), String.valueOf(customerEDP), accessToken,15,10,10);

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
			getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();

			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getShoppingCartThreadLocal().lblCartNoticeQuantityExceedingMessage);
			String lsActualCartExceedingLimitMessage = getShoppingCartThreadLocal().lblCartNoticeQuantityExceedingMessage.getText().trim();
			if (lsActualCartExceedingLimitMessage.equalsIgnoreCase(lsExpectedCartExceedingLimitMessage)) {
				reporter.reportLogPass("The cart exceeding limit message is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The cart exceeding limit message is not displaying correctly");
			}

			boolean bCheckoutButtonDisabled=getShoppingCartThreadLocal().checkIfCheckOutButtonDisabled();
			if(bCheckoutButtonDisabled){
				reporter.reportLogPass("The checkout button is disabled after ordering oversize shopping items");
			}
			else{
				reporter.reportLogFail("The checkout button is disabled after ordering oversize shopping items");
			}

			for(int i=getShoppingCartThreadLocal().lstItemRemoveButtonFromCart.size()-2;i>=0;i--){
				WebElement removeButton=getShoppingCartThreadLocal().lstItemRemoveButtonFromCart.get(i);
				getShoppingCartThreadLocal().openRemoveDialog(removeButton);
				getShoppingCartThreadLocal().closeRemoveDialogWithRemoveAction();
				basePage.waitForPageToLoad();
				//Applying static wait here after wait for page load function again
				//as sometimes page loads but DOM is still getting refreshed and hence Stale Element Exception is thrown
				basePage.applyStaticWait(3000);
			}
			getShoppingCartThreadLocal().chooseShoppingItemByGivenItemIndexAndQuantity(0, 1);
			String lsCheckErrorMessage = getShoppingCartThreadLocal().checkCartNoticeMessageExisting();
			if (lsCheckErrorMessage==null||lsCheckErrorMessage.equalsIgnoreCase("multiPackMessage")) {
				reporter.reportLogPass("The cart exceeding limit message is not displaying as expected");
			} else {
				reporter.reportLogFail("The cart exceeding limit message is still displaying");
			}

			bCheckoutButtonDisabled=getShoppingCartThreadLocal().checkIfCheckOutButtonDisabled();
			if(!bCheckoutButtonDisabled){
				reporter.reportLogPass("The checkout button is enabled after ordering not oversize shopping items");
			}
			else{
				reporter.reportLogFail("The checkout button is disabled after ordering not oversize shopping items");
			}
		}finally {
			//To empty the cart for next test run
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

