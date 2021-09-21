package com.tsc.test.tests.productSearchResult;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.tsc.data.Handler.TestDataHandler;
import com.tsc.pages.HomePage;
import com.tsc.pages.base.BasePage;
import com.tsc.test.base.BaseTest;

public class SR_TC04_Verify_ProductSearchResult_SortAndFilterSectionFunction extends BaseTest{
	
	/**
	 * This method will test the functions of sort and filter sections of product searching results.
	 * @author Wei.Li
	 */	
	@Test(groups={"ProductSearch","Regression"})
	public void validateProductSearchResult_FilterSectionFunction() throws IOException {	
	(new HomePage(this.getDriver())).closeadd();
	
	reporter.softAssert(getglobalheaderPageThreadLocal().validateURL((new BasePage(this.getDriver())).getBaseURL()+"/"), "TSC url is correct", "TSC url is incorrect");		
	reporter.reportLog("ProductSearch Page");
	
	List<List<String>> lsKeywordList=TestDataHandler.constantDataVariables.getlst_SearchKeyword_DropDown();
	List<List<String>> lstSearchResultMessage=TestDataHandler.constantDataVariables.getlst_SearchResultMessage();
	String lsSearchResultPageDefaultSetting=TestDataHandler.constantDataVariables.getlbl_SearchResultPageDefaultSetting();	
	List<WebElement> productList;
	String lsMsg;
		

	getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));	

	//Test sort
	if(getProductResultsPageThreadLocal().chooseSortOptionByVisibleText("Price: Highest first")) {
		lsMsg=getProductResultsPageThreadLocal().verifyHighestPriceFirstSort();
		if(lsMsg.isEmpty()) {
			reporter.reportLogPass("Sort option of Price: Highest first works");
		}else {
			reporter.reportLogFail(lsMsg);
		}				
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlAfterSelectSortStrategy(lsKeywordList.get(0).get(0),"HighestPrice"), "The Url contains keyword and sortKey=HighestPrice", "The Url does not contain keyword and sortKey=HighestPrice");		
		
		lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
		if(lsMsg.isEmpty()) {
			reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
		}else {
			reporter.reportLogFail(lsMsg);
		}
				
		reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
		reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
		
		productList=getProductResultsPageThreadLocal().getProductList();
		if(productList.size()>0) {
			getProductResultsPageThreadLocal().verifySearchResultContent(productList);
		}	
		
		reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
	}
	else {
		reporter.reportLogFail("Choosing Price: Highest first option failed");
	}

	//Test General filter option
	List<List<String>> lstGeneralTwoLevelFilterOption=TestDataHandler.constantDataVariables.getlst_GeneralTwoLevelFilterOption();
	for(List<String> lstItem:lstGeneralTwoLevelFilterOption) {
		if(getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1))) {
			reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct dimensions and keyword", "The Url does not contain correct dimensions and keyword");
			
			lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
			}else {
				reporter.reportLogFail(lsMsg);
			}
						
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			
			productList=getProductResultsPageThreadLocal().getProductList();
			if(productList.size()>0) {
				getProductResultsPageThreadLocal().verifySearchResultContent(productList);
			}	
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
		}
		else {
			reporter.reportLogFail("Choosing filter of "+"'"+lstItem.get(0)+"/"+lstItem.get(1)+"' failed");
		}
		
		//To recover the initial test environment
		if(getProductResultsPageThreadLocal().getClearAllFiltersButtonStatus()) {
			getProductResultsPageThreadLocal().closeAllSelectedFilters();
		}
		else {
			getProductResultsPageThreadLocal().getSearchResultLoad(lsKeywordList.get(0).get(0));
		}		
	}	

	//Test filter by price	
	List<List<String>> lstFilterByPrice=TestDataHandler.constantDataVariables.getlst_FilterByPrice();
	for(List<String> lstItem:lstFilterByPrice) {
		if(getProductResultsPageThreadLocal().selectFilterItemInLeftPanel(lstItem.get(0), lstItem.get(1))) {
			//To verify the first item
			lsMsg=getProductResultsPageThreadLocal().verifyFilterByPrice(lstItem.get(2),true);
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("The first item for filter by price works");
			}else {
				reporter.reportLogFail(lsMsg);
			}
			//To verify all items
			lsMsg=getProductResultsPageThreadLocal().verifyFilterByPrice(lstItem.get(2),false);
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Filter by price works");
			}else {
				reporter.reportLogFail(lsMsg);
			}	
			reporter.softAssert(getProductResultsPageThreadLocal().verifyUrlContainDimensionAndKeyword(lsKeywordList.get(0).get(0)), "The Url contains correct keyword", "The Url does not contain correct keyword");
			
			lsMsg=getProductResultsPageThreadLocal().verifySearchResultMessage(lstSearchResultMessage.get(0),lsKeywordList.get(0).get(0));
			if(lsMsg.isEmpty()) {
				reporter.reportLogPass("Search result message result of '"+getProductResultsPageThreadLocal().lsSearchResultMessage+"' matches the expected message");
			}else {
				reporter.reportLogFail(lsMsg);
			}
						
			reporter.softAssert(getProductResultsPageThreadLocal().verifyShowingTextPatternInFilters(), "Showing text pattern in filters is correct", "Showing text pattern in filters is incorrect");
			reporter.softAssert(getProductResultsPageThreadLocal().verifySearchResultPageNumberDefaultSetting(lsSearchResultPageDefaultSetting), "The default setting of items per page is "+lsSearchResultPageDefaultSetting, "The default setting of items per page isn't "+lsSearchResultPageDefaultSetting);
			
			productList=getProductResultsPageThreadLocal().getProductList();
			if(productList.size()>0) {
				getProductResultsPageThreadLocal().verifySearchResultContent(productList);
			}	
			
			reporter.softAssert(getProductResultsPageThreadLocal().verifyProductPagination(), "Product pagination is existing", "Product pagination is not existing");
		}
		else {
			reporter.reportLogFail("Choosing filter of "+lstItem.get(0)+"/"+lstItem.get(1)+" failed");
		}
		getProductResultsPageThreadLocal().closeAllSelectedFilters();
	}

	}
}

