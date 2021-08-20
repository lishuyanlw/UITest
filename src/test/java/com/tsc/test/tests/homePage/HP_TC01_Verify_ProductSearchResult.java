package com.tsc.test.tests.homePage;

import java.io.IOException;
import java.util.List;

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

	List<String> lstSearchModel=TestDataHandler.constantDataVariables.getlst_SearchModel();
	List<String> lskeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword();
	List<String> lstSearchResultExpectedUrl=TestDataHandler.constantDataVariables.getlst_SearchResultExpectedUrl();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	List<String> lstBannerImagekeyword=TestDataHandler.constantDataVariables.getlst_BannerImagekeyword();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	
	int keyWordSize=lskeywordList.size();
	for(int i=0;i<keyWordSize;i++) {
		getProductResultsPageThreadLocal().getSearchResultLoad(lskeywordList.get(i));
		
		if(!lstSearchModel.get(i).equalsIgnoreCase("Product Name")) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
		}
		
		if(!lstSearchModel.get(i).equalsIgnoreCase("Special Characters")) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrl((new BasePage(this.getDriver())).getBaseURL()+lstSearchResultExpectedUrl.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
		}
				
		if(!lstSearchModel.get(i).equalsIgnoreCase("Special Characters")&&!lstSearchModel.get(i).equalsIgnoreCase("Product Number")) {
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
						
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
				
		//Verify "!@#$%^&*()_+" special keyword search
		if(lstSearchModel.get(i).equalsIgnoreCase("Special Characters")) {
			reporter.softAssert(getProductResultsPageThreadLocal().getProductResultCount()==0, "No search results return", "Still there are search results return");
		}
				
		//Verify "100501" keyword search
		if(lstSearchModel.get(i).equalsIgnoreCase("Product Number")) {
			reporter.softAssert(getProductResultsPageThreadLocal().VerifySearchResultWithProductItemNO(lskeywordList.get(i)), "The itemNO in search results just contains those with search product number", "the itemNO in search results don't just contain those with search product number");
		}
				
		//Verify "joan rivers" keyword search
		if(lstSearchModel.get(i).equalsIgnoreCase("Product Name")) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifyBannerImageContainSpecificWord(lstBannerImagekeyword.get(i)), "Banner imgaes contain Joan Rivers related word", "Banner imgaes do not contain Joan Rivers related word");
			
			reporter.softAssert(getProductResultsPageThreadLocal().getProductResultPageTitle().equalsIgnoreCase(lskeywordList.get(i)), "Search result page title is dispalyed as search keyword", "Search result page title is not dispalyed as search keyword");
		}
				
	}
	
	
	}
	
}
