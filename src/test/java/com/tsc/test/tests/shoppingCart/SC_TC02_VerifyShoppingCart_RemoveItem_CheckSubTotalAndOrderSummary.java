package com.tsc.test.tests.shoppingCart;

import com.tsc.api.pojo.CartResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SC_TC02_VerifyShoppingCart_RemoveItem_CheckSubTotalAndOrderSummary extends BaseTest{
	/*
	 * CER-840
	 */
	@Test(groups={"Regression","Regression_Mobile","Regression_Tablet","SauceTunnelTest"})
	public void SC_TC02_VerifyShoppingCart_RemoveItem_CheckSubTotalAndOrderSummary() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		String lsUserName=TestDataHandler.constantData.getApiUserSessionParams().getLbl_username();
		String lsPassword=TestDataHandler.constantData.getApiUserSessionParams().getLbl_password();

		//Fetching test data from test data file
		ConstantData.APIUserSessionParams apiUserSessionParams = TestDataHandler.constantData.getApiUserSessionParams();
		apiUserSessionData = apiResponseThreadLocal.get().getApiUserSessionData(lsUserName,lsPassword,apiUserSessionParams.getLbl_grantType(),apiUserSessionParams.getLbl_apiKey());

		String accessToken = apiUserSessionData.get("access_token").toString();
		String customerEDP = apiUserSessionData.get("customerEDP").toString();
		CartResponse cartResponse = getProductDetailPageThreadLocal().addItemsToShoppingCartForUser(lstKeywordList,customerEDP, accessToken);
		Map<String,Map<String,Object>> cartMap = getProductDetailPageThreadLocal().getShoppingBagItemsDetailAddedForUser(cartResponse);

		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);

		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "-10");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPColor);
			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			getProductDetailPageThreadLocal().chooseGivenStyleAndSize(getProductDetailPageThreadLocal().selectedProduct.productEDPColor,getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

			getProductDetailPageThreadLocal().openAddToBagPopupWindow();
			getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

			Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			Map<String, WebElement> mapButtons=getShoppingCartThreadLocal().getFirstCartItemWithAvailableRemoveButton();
			WebElement cartItem=mapButtons.get("cartItem");
			WebElement removeButton=mapButtons.get("removeButton");

			Map<String,Object> mapCartItem=getShoppingCartThreadLocal().getShoppingItemDesc(cartItem,"all");

			getShoppingCartThreadLocal().openRemoveDialog(removeButton);

			reporter.reportLog("Verify remove dialog contents");
			getShoppingCartThreadLocal().verifyRemoveDialogContents();
			Map<String,Object> mapRemoveDialog=getShoppingCartThreadLocal().getRemoveDialogDesc();

			reporter.reportLog("Compare the contents between cart item and remove dialog");
			getShoppingCartThreadLocal().verifyContentsBetweenCartItemAndRemoveDialog(mapCartItem,mapRemoveDialog);

			reporter.reportLog("Verify clicking cancel button action in remove dialog");
			getShoppingCartThreadLocal().closeRemoveDialogWithoutRemoveAction(true);
			shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			int findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
			if(findIndex!=-1){
				reporter.reportLogPass("Able to find the removed item");
			}
			else{
				reporter.reportLogFail("Unable to find the removed item");
			}

			getShoppingCartThreadLocal().openRemoveDialog(removeButton);

			reporter.reportLog("Verify clicking remove button action in remove dialog");
			getShoppingCartThreadLocal().closeRemoveDialogWithRemoveAction();
			shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");
			reporter.reportLog("To verify business logic Between Shopping Item List And SubTotal Section");
			getShoppingCartThreadLocal().verifyBusinessLogicBetweenShoppingItemListAndSubTotalSection(shoppingCartMap);

			findIndex=getShoppingCartThreadLocal().findGivenProductIndexInShoppingCartItemList(mapRemoveDialog,shoppingCartMap);
			if(findIndex==-1){
				reporter.reportLogPass("Unable to find the removed item");
			}
			else{
				reporter.reportLogFail("Still able to find the removed item");
			}

			reporter.reportLog("Verify OrderSummary section content");
			getShoppingCartThreadLocal().verifyOrderSummaryContents();

			reporter.reportLog("Verify EasyPayment section content");
			getShoppingCartThreadLocal().verifyEasyPaymentContents();


		}
		else {
			reporter.reportLogFail("Unable to find the matched product item");
		}
	}
}

