package com.tsc.test.tests.productDetail;

import com.tsc.api.pojo.CartResponse;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.GlobalHeaderPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD_TC17_VerifyProductDetail_AddToBag_MergeCart_NotLoginFirst extends BaseTest{
	/*
	 * CER-840
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC17_VerifyProductDetail_AddToBag_MergeCart_NotLoginFirst() throws IOException {
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

		//
		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		outputDataCriteria.put("quantity", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForMultipleStyleAndSize",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPColor);
			reporter.reportLog(getProductDetailPageThreadLocal().selectedProduct.productEDPSize);

			//Including Style 1 and Style 2
			String[] lstStyle=getProductDetailPageThreadLocal().getStyleList();

			//The Size list for Style 1
			String[] lstSize1=getProductDetailPageThreadLocal().getSizeListForGivenStyle(0);
			//For Size list for Style 2
			String[] lstSize2=getProductDetailPageThreadLocal().getSizeListForGivenStyle(1);

			//To choose Style/Size/Quantity as needed
			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[1],lstSize2[2],1);

			Map<String,Object> PDPMap=getProductDetailPageThreadLocal().getPDPDesc();

			reporter.reportLog("Verify initial shopping cart bag counter before clicking AddToBag button");
			int shoppingCartBagCounterBeforeClickingAddToBagButton= getglobalheaderPageThreadLocal().getShoppingCartBagCounter();
			if(shoppingCartBagCounterBeforeClickingAddToBagButton==0){
				reporter.reportLogPass("The initial shopping cart bag counter is equal to 0");
			}
			else{
				reporter.reportLogFail("The initial shopping cart bag counter is not equal to 0, instead of "+shoppingCartBagCounterBeforeClickingAddToBagButton);
			}

			getProductDetailPageThreadLocal().openAddToBagPopupWindow();
			Map<String,Object> AddToBagMap=getProductDetailPageThreadLocal().getAddToBagDesc();
			getProductDetailPageThreadLocal().closeAddToBagPopupWindow();

			reporter.reportLog("Verify shopping cart bag counter after clicking AddToBag button");
			int shoppingCartBagCounterAfterClickingAddToBagButton= getglobalheaderPageThreadLocal().getShoppingCartBagCounter();
			if(shoppingCartBagCounterAfterClickingAddToBagButton>=1){
				reporter.reportLogPass("The shopping cart bag counter is greater than 0");
			}
			else{
				reporter.reportLogFail("The shopping cart bag counter is still equal to 0");
			}

			reporter.reportLog("Verify contents between PDP and AddToBag");
			getProductDetailPageThreadLocal().verifyContentsBetweenPDPAndAddToBag(PDPMap,AddToBagMap);
		}
		else {
			reporter.reportLogFail("Unable to find the matched product item");
		}
	}
}

