package com.tsc.test.tests.shoppingCart;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.SignInPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC16_VerifyShoppingCart_WithoutUserLogin extends BaseTest{
	/*
	 * CER-862
	 */
	@Test(groups={"Regression","ShoppingCart"})
	public void SC_TC16_VerifyShoppingCart_WithoutUserLogin() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();

		//Fetching test data from test data file
		String accessToken = getApiUserSessionDataMapThreadLocal().get("access_token").toString();
		int customerEDP = Integer.valueOf(getApiUserSessionDataMapThreadLocal().get("customerEDP").toString());
		getShoppingCartThreadLocal().emptyCart(Integer.valueOf(customerEDP),accessToken);

		BasePage basePage=new BasePage(this.getDriver());
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
			String[] lstStyle = getProductDetailPageThreadLocal().getStyleList();
			String[] lstSize0 = getProductDetailPageThreadLocal().getSizeListForGivenStyle(0);
			String[] lstSize1 = getProductDetailPageThreadLocal().getSizeListForGivenStyle(1);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0], lstSize0[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
			basePage.applyStaticWait(basePage.getStaticWaitForApplication());

			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[1], lstSize1[0], 1);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBag);
			basePage.waitForCondition(Driver -> {
				return getProductDetailPageThreadLocal().lblAddToBagPopupWindowTitle.isDisplayed();
			}, 30000);
			basePage.clickElement(getProductDetailPageThreadLocal().btnAddToBagPopupWindowClose);
			basePage.applyStaticWait(basePage.getStaticWaitForApplication());

			Map<String, Object> PDPMap = getProductDetailPageThreadLocal().getPDPDesc();
			getProductDetailPageThreadLocal().goToShoppingCartByClickingShoppingCartIconInGlobalHeader();
			Map<String, Object> shoppingCartMap = getShoppingCartThreadLocal().getShoppingSectionDetails("all");

			//To verify heading and Shopping Item List contents
			reporter.reportLog("To verify heading and Shopping Item List contents");
			getShoppingCartThreadLocal().verifyShoppingCartContents();

			if(getShoppingCartThreadLocal().checkIsDropdownMenuForInstallmentNumber()){
				List<String> lstOptionText=getShoppingCartThreadLocal().getInstallmentOptions();
				getShoppingCartThreadLocal().setInstallmentSetting(lstOptionText.get(1));
			}

			Map<String,Object> mapOrderSummary=getShoppingCartThreadLocal().getOrderSummaryDesc();
			float subTotal=getShoppingCartThreadLocal().getSubTotalFromShoppingList((List<Map<String,Object>>)shoppingCartMap.get("shoppingList"));
			reporter.reportLog("Verify OrderSummary section contents");
			getShoppingCartThreadLocal().verifyOrderSummaryContents();
			reporter.reportLog("Verify OrderSummary business logic");
			getShoppingCartThreadLocal().verifyOrderSummaryBusinessLogic(subTotal,mapOrderSummary,null);

			reporter.reportLog("Verify EasyPayment section contents");
			getShoppingCartThreadLocal().verifyEasyPaymentContents();
			reporter.reportLog("Verify EasyPayment business logic");
			getShoppingCartThreadLocal().verifyInstallmentBusinessLogic(mapOrderSummary);


			reporter.reportLog("Verify remove functions");
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

			reporter.reportLog("Verify clicking remove button action in remove dialog");
			getShoppingCartThreadLocal().closeRemoveDialogWithRemoveAction();
			shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("mandatory");

			int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
			if(findIndex==-1){
				reporter.reportLogPass("Unable to find the removed item");
			}
			else{
				reporter.reportLogFail("Still able to find the removed item");
			}

			reporter.reportLog("Verify clicking checkout button");
			String lsSignInTitle=TestDataHandler.constantData.getLoginUser().getLbl_SignInTitleFromCheckout();
			basePage.getReusableActionsInstance().javascriptScrollByVisibleElement(getShoppingCartThreadLocal().btnCartCheckoutButton);
			getShoppingCartThreadLocal().btnCartCheckoutButton.click();
			basePage.waitForCondition(Driver->{return getGlobalLoginPageThreadLocal().lblSignIn.isDisplayed();},20000);
			getGlobalLoginPageThreadLocal().verifySignInTitle(lsSignInTitle);
			if(basePage.URL().toLowerCase().contains("signin")){
				reporter.reportLogPass("The page has been navigated to SignIn page");
			}
			else{
				reporter.reportLogPassWithScreenshot("The page failed to be navigated to SignIn page");
			}
		}
	}
}

