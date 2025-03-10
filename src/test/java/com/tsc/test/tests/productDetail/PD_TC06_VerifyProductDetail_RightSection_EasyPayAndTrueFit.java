package com.tsc.test.tests.productDetail;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PD_TC06_VerifyProductDetail_RightSection_EasyPayAndTrueFit extends BaseTest{
	/*
	 * CER-572
	 * CER-588
	 * CER-600
	 * CER-816
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC06_VerifyProductDetail_RightSection_EasyPayAndTrueFit() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

//		String lsKeyword=TestDataHandler.constantData.getSearchResultPage().getLbl_productTrueFitAndSizingChart();
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
		reporter.reportLog("Switch to ProductDetail page");
		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "1");
		outputDataCriteria.put("size", "1");

		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ProductWithEasyPaySizeChartAndReviews",outputDataCriteria)) {
//		if(getProductResultsPageThreadLocal().getSearchResultLoad(lsKeyword,true)){
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
//			lsProductNumber=lsKeyword;
			reporter.reportLog("Verify URL for Product Number: "+lsProductNumber);
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify Easy payment");
			getProductDetailPageThreadLocal().verifyEasyPay();

			if(!System.getProperty("Browser").equalsIgnoreCase("sauceioschrome")){
				reporter.reportLog("Verify product size TrueFit");
				getProductDetailPageThreadLocal().verifyProductSizeTrueFit();
			}
			else{
				reporter.reportLog("TrueFit functionality is not tested for ios Mobile and Tablet due to cross-origin frame issue");
			}

		}
		else{
			reporter.reportLogFail("Test case Failed!");
		}
	}

}

