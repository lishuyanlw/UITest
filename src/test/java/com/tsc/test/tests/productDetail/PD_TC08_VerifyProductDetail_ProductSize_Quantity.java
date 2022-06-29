package com.tsc.test.tests.productDetail;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class PD_TC08_VerifyProductDetail_ProductSize_Quantity extends BaseTest{
	/*
	 * CER-578
	 * CER-582
	 * CER-601
	 * CER-817
	 */
	@Test(groups={"ProductDetail","Regression","Regression_Mobile","Regression_Tablet"})
	public void PD_TC08_VerifyProductDetail_ProductSize_Quantity() throws IOException {
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
			lsProductNumber=getProductDetailPageThreadLocal().selectedProduct.productNumber;
			lsUrl=basePage.URL();
			reporter.softAssert(lsUrl.contains("productdetails"),"The Url is containing productdetails","The Url is not containing productdetails");
			reporter.reportLog("Switch to ProductDetail page");
			reporter.softAssert(lsUrl.contains(lsProductNumber),"The Url is containing selected product number of "+lsProductNumber,"The Url is not containing selected product number of "+lsProductNumber);

			reporter.reportLog("Verify product size changing action");
			getProductDetailPageThreadLocal().verifyProductSize();

			if(!System.getProperty("Browser").equalsIgnoreCase("sauceioschrome")){
				reporter.reportLog("Verify product size TrueFit");
				getProductDetailPageThreadLocal().verifyProductSizeTrueFit();
			}
			else{
				reporter.reportLog("TrueFit functionality is not tested for ios Mobile and Tablet due to cross-origin frame issue");
			}

			reporter.reportLog("Verify product quantity");
			getProductDetailPageThreadLocal().verifyProductQuantityDropdown(Integer.parseInt(lsQuantityNumberToShowLeftItemInfo));
		}
		else {
			reporter.reportLogFail("Unable to find the product item with Size, TrueFit, Quantity and Left items info");
		}
	}
}

