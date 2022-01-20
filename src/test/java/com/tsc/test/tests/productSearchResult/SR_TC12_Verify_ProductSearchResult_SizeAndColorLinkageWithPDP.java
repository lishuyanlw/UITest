package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;

import com.tsc.pages.HomePage;
import com.tsc.pages.ProductDetailPage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC12_Verify_ProductSearchResult_SizeAndColorLinkageWithPDP extends BaseTest{
	/*
	 * 
	 * 
	 */
	@Test(groups={"ProductSearch","Regression","Regression_Tablet"})
	public void validateProductSearchResult_SizeAndColorLinkageWithPDP() throws IOException {
	getGlobalFooterPageThreadLocal().closePopupDialog();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_SearchKeyword_DropDown();
	List<String> lstKeywordList=TestDataHandler.constantData.getSearchResultPage().getLst_APISearchingKeyword();
	
	getProductResultsPageThreadLocal().getSearchResultLoad("iPads & Tablets");
	getProductResultsPageThreadLocal().verifyInfoLinkageWithPDP(getProductDetailPageThreadLocal());	
//	if(getProductResultsPageThreadLocal().findProductItemWithPreConditions(lstKeywordList)) {
//		getProductResultsPageThreadLocal().verifyInfoLinkageWithPDP(getProductDetailPageThreadLocal());	
//	}
 }
	
}

