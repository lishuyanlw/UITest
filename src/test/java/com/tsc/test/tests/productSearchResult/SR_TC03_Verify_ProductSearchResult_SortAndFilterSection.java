package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.ProductResultsPage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC03_Verify_ProductSearchResult_SortAndFilterSection extends BaseTest{
	
	/**
	 * This method will test sort and filter sections of product searching results.
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_FilterSection() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<String> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();
	List<String> lsSortOption=TestDataHandler.constantDataVariables.getlst_SortOption();
	List<WebElement> productList;
		
	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0));
	reporter.softAssert(getProductResultsPageThreadLocal().verifySortOptions(lsSortOption), "Sort options in search result filters are correct", "Sort options in search result filters are incorrect");
	
	if(getProductResultsPageThreadLocal().chooseSortOptionByVisibleText("Price: Highest first")) {		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyHighestPriceFirstSort(), "Sort option of Price: Highest first works", "Sort option of Price: Highest first does not work");
		
		List<String> lstSortByHighestPriceUrl=TestDataHandler.constantDataVariables.getlst_SortByHighestPriceUrl();
		reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectHighestPriceSort(lsKeywordList.get(0),lstSortByHighestPriceUrl), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0)), "Search result message result matches the expected message", "Search result message result does not match the expected message");
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList);
		}	
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
	}
	
			
	}
}
