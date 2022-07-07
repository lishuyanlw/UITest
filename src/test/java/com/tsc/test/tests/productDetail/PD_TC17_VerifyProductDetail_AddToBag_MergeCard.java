package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.data.pojos.ConstantData;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD_TC17_VerifyProductDetail_AddToBag_MergeCard extends BaseTest{
	/*
	 * CER-840
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC17_VerifyProductDetail_AddToBag_MergeCard() throws IOException {
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
		getProductDetailPageThreadLocal().addItemsToShoppingCartForUser(lstKeywordList,customerEDP, accessToken);
		//Login using valid username and password
		getGlobalLoginPageThreadLocal().Login(lsUserName, lsPassword);

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

			//Including Style 1 and Style 1
			String[] lstStyle=getProductDetailPageThreadLocal().selectedProduct.productEDPColor.split("|");

			//For Style 1
			String[] lstSize1=getProductDetailPageThreadLocal().selectedProduct.productEDPSize.split("|")[0].split(":");
			//For Style 2
			String[] lstSize2=getProductDetailPageThreadLocal().selectedProduct.productEDPSize.split("|")[1].split(":");

			//To choose Style/Size/Quantity as needed
			getProductDetailPageThreadLocal().chooseGivenStyleAndSizeAndQuantity(lstStyle[0],lstSize1[0],1);

		}
		else {
			reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
		}
	}
}

