package com.tsc.test.tests.homePage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
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

	//Verify "dyson vacuum" keyword search
	getProductResultsPageThreadLocal().getSearchResultLoad(TestDataHandler.constantDataVariables.getlbl_SearchKeyword_DysonVacuum());
		
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(TestDataHandler.constantDataVariables.getlst_SearchResultMessage_DysonVacuum()), "Search result message result matches the expected message", "Search result message result does not match the expected message");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrl((new BasePage(this.getDriver())).getBaseURL()+TestDataHandler.constantDataVariables.getlbl_SearchResultExpectedUrl_DysonVacuum()), "Url of search result matches expected url", "Url of search result doesn't match expected url");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
	
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting()), "The default setting of items per page is "+TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting(), "The default setting of items per page isn't "+TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting());
	
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
	
	//Verify "!@#$%^&*()_+" keyword search
	
	getProductResultsPageThreadLocal().getSearchResultLoad(TestDataHandler.constantDataVariables.getlbl_SearchKeyword_SpecialCharacters());
		
	reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(TestDataHandler.constantDataVariables.getlst_SearchResultMessage_SpecialCharacters()), "Search result message result matches the expected message", "Search result message result does not match the expected message");
	
	reporter.softAssert(getProductResultsPageThreadLocal().getProductResultCount()==0, "No search results return", "Still there are search results return");
	
	
	}
	
}
