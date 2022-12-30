package com.tsc.test.tests.productDetail;

import com.tsc.api.pojo.CartResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD_TC18_VerifyProductDetail_AddToBag_MergeCart_LogInFirst extends BaseTest{
	/*
	 * CER-840
	 */
	@Test(groups={"Regression","Regression_Mobile","Regression_Tablet","SauceTunnelTest"})
	public void PD_TC18_VerifyProductDetail_AddToBag_MergeCart_LogInFirst() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		//List<String> lstKeywordList=TestDataHandler.constantData.getCheckOut().getLst_SearchingKeywordForPlaceOrder();
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
			Map<String,Object> AddToBagMap=getProductDetailPageThreadLocal().getAddToBagDesc();

			reporter.reportLog("Verify initial shopping cart bag counter before clicking AddToBag button");
			int shoppingCartBagCounterBeforeClickingAddToBagButton= getglobalheaderPageThreadLocal().getShoppingCartBagCounter();
			if(shoppingCartBagCounterBeforeClickingAddToBagButton>=2){
				reporter.reportLogPass("The initial shopping cart bag counter is no less than 2");
			}
			else{
				reporter.reportLogFail("The initial shopping cart bag counter is less than 2, instead of "+shoppingCartBagCounterBeforeClickingAddToBagButton);
			}

			getProductDetailPageThreadLocal().goToShoppingCartFromAddToBagPopupWithLoginFirst();

			reporter.reportLog("Verify shopping cart bag counter after clicking AddToBag button with the added item number in cart title");
			int shoppingItemAmount=getShoppingCartThreadLocal().getShoppingAmount();
			int shoppingCartBagCounterAfterClickingAddToBagButton= getglobalheaderPageThreadLocal().getShoppingCartBagCounter();
			if(shoppingCartBagCounterAfterClickingAddToBagButton==shoppingItemAmount){
				reporter.reportLogPass("The shopping cart bag counter is equal to the added shopping item number in cart title");
			}
			else{
				reporter.reportLogFail("The shopping cart bag counter is not equal to the added shopping item number:"+shoppingItemAmount+" in cart title, instead of "+shoppingCartBagCounterAfterClickingAddToBagButton);
			}

			reporter.reportLog("Verify shopping cart bag counter after clicking AddToBag button with shopping item list");
			int shoppingListAmount=getShoppingCartThreadLocal().lstCartItems.size();
			shoppingCartBagCounterAfterClickingAddToBagButton= getglobalheaderPageThreadLocal().getShoppingCartBagCounter();
			if(shoppingCartBagCounterAfterClickingAddToBagButton==shoppingListAmount){
				reporter.reportLogPass("The shopping cart bag counter is equal to shopping item amount");
			}
			else{
				reporter.reportLogFail("The shopping cart bag counter is not equal to shopping item amount:"+shoppingListAmount+", instead of "+shoppingCartBagCounterAfterClickingAddToBagButton);
			}

			Map<String,Object> shoppingCartMap=getShoppingCartThreadLocal().getShoppingSectionDetails("all");

			//To verify Contents among PDP, AddToBag And ShoppingCartSection Details
			reporter.reportLog("To verify Contents on ShoppingCartSection Details with AddToBag information from UI interface");
			getShoppingCartThreadLocal().verifyContentsOnShoppingCartSectionDetailsWithAddToBag(PDPMap,AddToBagMap,shoppingCartMap,false);

			reporter.reportLog("To verify Contents on ShoppingCartSection Details with addToBag information from API calling");
			for(Map.Entry<String,Map<String,Object>> entry:cartMap.entrySet()){
				reporter.reportLog("Verify product number: "+entry.getKey());
				AddToBagMap=entry.getValue();
				getShoppingCartThreadLocal().verifyContentsOnShoppingCartSectionDetailsWithAddToBag(PDPMap,AddToBagMap,shoppingCartMap,true);
			}

		}
		else {
			reporter.reportLogFail("Unable to find the matched product item");
		}
	}
}

