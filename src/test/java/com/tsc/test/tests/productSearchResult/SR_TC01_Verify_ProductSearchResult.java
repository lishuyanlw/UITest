package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC01_Verify_ProductSearchResult extends BaseTest{
	
	/**
	 * This method will test functions of product searching results
	 *
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<String> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword();	
	String lsSearchResultExpectedUrl=TestDataHandler.constantDataVariables.getlbl_SearchResultExpectedUrl();
	String lsSearchResultExpectedUrlWithoutKeyword=TestDataHandler.constantDataVariables.getlbl_SearchResultExpectedUrlWithoutKeyword();
	
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	List<WebElement> productList;
	
	int keyWordSize=lsKeywordList.size();
	for(int i=0;i<keyWordSize;i++) {		
		getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(i));
		
		String lsTestModel=getProductResultsPageThreadLocal().judgeTestModel();	
		reporter.reportLog("Search Model and keyword : "+lsTestModel+" : "+lsKeywordList.get(i));
		
		switch(lsTestModel) {
		case "NormalSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrlWithRegexPattern(lsSearchResultExpectedUrl,lsKeywordList.get(i)), "Url of search result matches expected url regex pattern", "Url of search result doesn't match expected url regex pattern");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrl(lsSearchResultExpectedUrlWithoutKeyword,lsKeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			
			productList=getProductResultsPageThreadLocal().getProductList();
			if(productList.size()>0) {
				getProductResultsPageThreadLocal().verifySearchResultContent(productList);
			}	
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			break;
		case "NoSearchResult":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(1),lsKeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			reporter.softAssert(getProductResultsPageThreadLocal().getProductResultCount()==0, "No search results return", "Still there are search results return");
			break;
		case "ProductNumberSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrlWithRegexPattern(lsSearchResultExpectedUrl,lsKeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(i)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			reporter.softAssert(getProductResultsPageThreadLocal().VerifySearchResultWithProductItemNO(lsKeywordList.get(i)), "The itemNO in search results just contains those with search product number", "the itemNO in search results don't just contain those with search product number");
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			break;
		case "BannerImageSearch":
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultUrlWithRegexPattern(lsSearchResultExpectedUrl,lsKeywordList.get(i)), "Url of search result matches expected url", "Url of search result doesn't match expected url");
			if(getProductResultsPageThreadLocal().getBannerImageListSize()>0) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyBannerImageContainSpecificWord(lsKeywordList.get(i)), "Banner imgaes contain keyword", "Banner imgaes do not contain keyword");
			}
						
			String lsTitle=getProductResultsPageThreadLocal().getProductResultPageTitle();
			reporter.softAssert(lsTitle.equalsIgnoreCase(lsKeywordList.get(i))||lsTitle.equalsIgnoreCase("NoTitle"), "Search result page title is dispalyed as search keyword", "Search result page title is not dispalyed as search keyword");
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			
			productList=getProductResultsPageThreadLocal().getProductList();
			if(productList.size()>0) {
				getProductResultsPageThreadLocal().verifySearchResultContent(productList);
			}	
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
			
			if(this.getDriver().findElements(getProductResultsPageThreadLocal().byProductTitleAndText).size()==1) {
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandTitleContainKeyword(lsKeywordList.get(i)), "The tilte in product title and text region contains search keyword", "The tilte in product title and text region does not contain search keyword");
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandTextContainKeyword(lsKeywordList.get(i)), "The content in product title and text region contains search keyword", "The content in product title and text region does not contain search keyword");
				reporter.softAssert(getProductResultsPageThreadLocal().verifyProductBrandMoreOrLessButton(), "The More/Less button works", "The More/Less button does not work");
			}
			break;		
		}
	}

}

}
