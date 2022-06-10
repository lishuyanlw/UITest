package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC05_VerifyProductDetail_ProductSize_Quantity extends BaseTest{
	/*
	 * CER-578
	 * CER-582
	 * CER-601
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC05_VerifyProductDetail_ProductSize_Quantity() throws IOException {
		getGlobalFooterPageThreadLocal().closePopupDialog();
		BasePage basePage=new BasePage(this.getDriver());

		reporter.softAssert(getglobalheaderPageThreadLocal().validateURL(basePage.getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");
		reporter.reportLog("ProductDetail Page");

		String lsQuantityNumberToShowLeftItemInfo=TestDataHandler.constantData.getSearchResultPage().getLbl_QuantityNumberToShowLeftItemInfo();
		List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();

		String lsProductNumber,lsUrl;

		Map<String,Object> outputDataCriteria= new HashMap<String,Object>();
		outputDataCriteria.put("style", "3");
		outputDataCriteria.put("size", "3");
		if(getProductDetailPageThreadLocal().goToProductItemWithPreConditions(lstKeywordList,"ConditionsForVideoAndStyleAndSizeWithoutCheckingSoldOutCriteria",outputDataCriteria)) {
			reporter.reportLog("Verify URL");
			lsProductNumber=getProductResultsPageThreadLocal().selectedProductItem.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.reportLog("Switch to ProductDetail page");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify product size changing action");
			getProductDetailPageThreadLocal().verifyProductSizeChangingAction();

			if(System.getProperty("Device").toLowerCase().contains("tablet") &&
					(System.getProperty("Browser").toLowerCase().contains("android") ||
							(!"".equals(System.getProperty("chromeMobileDevice")) && !System.getProperty("chromeMobileDevice").toLowerCase().contains("ipad")))){
				reporter.reportLog("Verify product TrueFit");
				getProductDetailPageThreadLocal().verifyProductSizeTrueFit();
			}

			reporter.reportLog("Verify product quantity");
			getProductDetailPageThreadLocal().verifyProductQuantityDropdown(Integer.parseInt(lsQuantityNumberToShowLeftItemInfo));
		}
		else {
			reporter.reportLogFail("Unable to find the product item with Size, TrueFit, Quantity and Left items info");
		}
	}
}

