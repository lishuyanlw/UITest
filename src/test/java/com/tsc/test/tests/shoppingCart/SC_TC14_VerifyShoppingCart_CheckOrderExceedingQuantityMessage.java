package com.tsc.test.tests.shoppingCart;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SC_TC14_VerifyShoppingCart_CheckOrderExceedingQuantityMessage extends BaseTest{
	/*
	 * CER-858
	 */
	@Test(groups={"Regression","ShoppingCart","SauceTunnelTest"})
	public void SC_TC14_VerifyShoppingCart_CheckOrderExceedingQuantityMessage() throws IOException {

		String lsUserName = TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword = TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		try{
			getGlobalFooterPageThreadLocal().closePopupDialog();
			List<Map<String, String>> keyword = TestDataHandler.constantData.getShoppingCart().getLst_SearchKeywords();
			List<Map<String, Object>> data = getShoppingCartThreadLocal().verifyCartExistsForUser(customerEDP, accessToken, keyword,true);

			//Add the product with over 10 item in the inventory
			String lsProductNumberForOrderExceedingQuantity=TestDataHandler.constantData.getShoppingCart().getLblProductNumberForOrderExceedingQuantity();
			String lsExpectedOrderExceedingQuantityMessage=TestDataHandler.constantData.getShoppingCart().getLblOrderExceedingQuantityMessage();
			Map<String,Object> mapAddProductWithMoreThanTenItems=getShoppingCartThreadLocal().addSingleProductWithConditions(lsProductNumberForOrderExceedingQuantity, 10,1, String.valueOf(customerEDP), accessToken,false);
			data.add(mapAddProductWithMoreThanTenItems);

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

			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

			int findIndex = getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapAddProductWithMoreThanTenItems, shoppingCartMap);
			getShoppingCartThreadLocal().chooseShoppingItemByGivenItemIndexAndQuantity(findIndex, 10);
			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getShoppingCartThreadLocal().lblCartNoticeQuantityExceedingMessage);
			String lsActualOrderExceedingQuantityMessage = getShoppingCartThreadLocal().lblCartNoticeQuantityExceedingMessage.getText().trim();
			if (lsActualOrderExceedingQuantityMessage.equalsIgnoreCase(lsExpectedOrderExceedingQuantityMessage)) {
				reporter.reportLogPass("The order quantity exceeding message is displaying correctly");
			} else {
				reporter.reportLogFailWithScreenshot("The order quantity exceeding message is not displaying correctly");
			}

			getShoppingCartThreadLocal().chooseShoppingItemByGivenItemIndexAndQuantity(findIndex, 1);
			String lsCheckErrorMessage = getShoppingCartThreadLocal().checkCartNoticeMessageExisting();
			if (lsCheckErrorMessage==null||lsCheckErrorMessage.equalsIgnoreCase("multiPackMessage")) {
				reporter.reportLogPass("The order quantity exceeding message is not displaying as expected");
			} else {
				reporter.reportLogFail("The order quantity exceeding message is still displaying");
			}
		}finally {
			//To empty the cart for next run
			getShoppingCartThreadLocal().emptyCart(customerEDP,accessToken);
		}
	}
}

