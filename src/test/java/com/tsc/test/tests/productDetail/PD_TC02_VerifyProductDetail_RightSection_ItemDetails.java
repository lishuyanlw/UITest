package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC02_VerifyProductDetail_RightSection_ItemDetails extends BaseTest{
	/*
	 * CER-572
	 * CER-588
	 * CER-600
	 *
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC02_VerifyProductDetail_RightSection_ItemDetails() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("video", "0");
		outputDataCriteria.put("style", "2");
		outputDataCriteria.put("size", "2");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"AllConditionsWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify product name,brand name and product number");
			getProductDetailPageThreadLocal().verifyProductBasicInfo();

			reporter.reportLog("Verify product review");
			getProductDetailPageThreadLocal().verifyProductReview();

			reporter.reportLog("Verify product price and shipping");
			getProductDetailPageThreadLocal().verifyProductPriceAndShipping();

			reporter.reportLog("Verify product style");
			getProductDetailPageThreadLocal().verifyProductStyle();

		}
		else {
			reporter.reportLogFail("Unable to find the product item with Review, EasyPay, Swatch item>=4 and Video");
		}
	}

}

