package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class HP_TC01_Verify_ProductSearchResult extends BaseTest{
	
	/**
	 * This method will test functions of product searching results
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"Home","Regression"})
	public void validateProductSearchResult() throws IOException {				
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLogWithScreenshot("Home Page");
	
	getProductResultsPageThreadLocal().getSearchResultLoad();
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageTitle(), "Page title of search result contains searching keyword", "page title of search result doesn't contain searching keyword");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrl(), "Url of search result matches expected url", "Url of search result doesn't match expected url");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(), "The default setting of items per page is 36", "The default setting of items per page isn't 36");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPriceBadge(), "PriceBadge in searching result is correct", "PriceBadge in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductHref(), "ProductHref in searching result is correct", "ProductHref in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductImage(), "ProductImage in searching result is correct", "ProductImage in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductVedioIcon(), "ProductVedioIcon in searching result is correct", "ProductVedioIcon in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductName(), "ProductName in searching result is correct", "ProductName in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductItemNO(), "ProductItemNO in searching result is correct", "ProductItemNO in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductNowPrice(), "ProductNowPrice in searching result is correct", "ProductNowPrice in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductWasPrice(), "ProductWasPrice in searching result is correct", "ProductWasPrice in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductEasyPay(), "ProductEasyPay in searching result is correct", "ProductEasyPay in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductReview(), "ProductReview in searching result is correct", "ProductReview in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductSwatch(), "ProductSwatch in searching result is correct", "ProductSwatch in searching result is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyProductFreeShipping(), "ProductFreeShipping in searching result is correct", "ProductFreeShipping in searching result is incorrect");
		
	}
	
}

